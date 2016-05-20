/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.prijava;

import MainForm.DijalogBoksPrikazPoruke;
import builder.DirectorForm;
import builder.prijava.PrijavaFizickoBuilder;
import builder.prijava.PrijavaParvnoBuilder;
import builder.prijava.PrijavaPravnoBuilder;
import builder.ucesnik.UcesnikFizickoBuilder;
import builder.ucesnik.UcesnikFizickoIzmeniBuilder;
import builder.ucesnik.UcesnikPravnoIzmeniBuilder;
import domen.Nadmetanje;
import domen.OpstiDomenskiObjekat;
import domen.PrijavaFizicko;
import domen.PrijavaPravno;
import domen.UcesnikFizicko;
import domen.UcesnikPravno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import komunikacija.Komunikacija;
import koordinator.form.KoordinatorForm;
import model.table.UcesnikTableModel;
import decorator.form.prijava.BtnOdaberiUcesnikaZaPrijavu;
import decorator.form.prijava.BtnPrijavaTableDodaj;
import decorator.form.ucesnik.BtnUcesnikIzmeniPanelForm;
import panel.form.oef.OpstaEkranskaForma;
import panel.form.ucesnik.UcesnikTablePanelForm;
import util.Konstante;
import util.TransferObjekat;

/**
 *
 * @author Mladen
 */
public class KontrolerBtnOdaberiUcesnikaZaPrijavu {
    private Object panel;
    private Komunikacija komunikacija;
    
    public KontrolerBtnOdaberiUcesnikaZaPrijavu(Object panel){
        this.panel = panel;
        try {
            komunikacija = Komunikacija.getInstance();
        } catch (Exception e) {
            System.out.println("Neuspelo uspostavljanje veze sa serverom");
        }
        
        setControler(panel);
    }

     private void setControler(Object panel) {        
        
        BtnOdaberiUcesnikaZaPrijavu btnOdaberiUcesnikaZaPrijavu = (BtnOdaberiUcesnikaZaPrijavu) panel;
        
        btnOdaberiUcesnikaZaPrijavu.btnPanel.btnPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 
                UcesnikTablePanelForm ucesnikTablePanelForm = (UcesnikTablePanelForm)btnOdaberiUcesnikaZaPrijavu.oef;                
                int selectedRow = ucesnikTablePanelForm.getTblUcesnik().getSelectedRow();
                if(selectedRow == -1) return;
                UcesnikTableModel ucesnikTableModel = (UcesnikTableModel) ucesnikTablePanelForm.getUcesnikTableModel();
                OpstiDomenskiObjekat odo = ucesnikTableModel.getListaUcesnika().get(selectedRow);
                Nadmetanje n = (Nadmetanje)ucesnikTablePanelForm.getOdo();
                
                if(odo instanceof UcesnikFizicko){
                    
                    PrijavaFizicko pf = new PrijavaFizicko();
                    pf.setNadmetanje(n);
                    pf.setPonudjacFizicko((UcesnikFizicko)odo);                                       
                    
                    TransferObjekat DTO = new TransferObjekat();
                    DTO.setOperacija(Konstante.ADD_PRIJAVA);
                    DTO.setParametar(pf);
                    DTO = komunikacija.izvrsiSo(DTO);                    
                    if(DTO.getSignal().compareTo(Konstante.ADD_PRIJAVA_OK)==0){                        
                        builder.DirectorForm director = new DirectorForm(
                                new PrijavaFizickoBuilder()
                        );
                        OpstaEkranskaForma oef = director.Konstruisi();
                        oef.setOdo((OpstiDomenskiObjekat) DTO.getOdgovor());
                        oef.KonvertujDomenskiObjekatUGrafickiObjekat();
                        KoordinatorForm.instance().postaviFormu(oef);
                    }
                PrikazPoruku(DTO.getSignal());                    
                }else{
                                        
                    PrijavaPravno pp = new PrijavaPravno();
                    pp.setNadmetanje(n);
                    pp.setUcesnikPravno((UcesnikPravno)odo);                                       
                    
                    TransferObjekat DTO = new TransferObjekat();
                    DTO.setOperacija(Konstante.ADD_PRIJAVA);
                    DTO.setParametar(pp);
                    DTO = komunikacija.izvrsiSo(DTO);                    
                    if(DTO.getSignal().compareTo(Konstante.ADD_PRIJAVA_OK)==0){                        
                        builder.DirectorForm director = new DirectorForm(
                                new PrijavaPravnoBuilder()
                        );
                        OpstaEkranskaForma oef = director.Konstruisi();
                        oef.setOdo((OpstiDomenskiObjekat) DTO.getOdgovor());
                        oef.KonvertujDomenskiObjekatUGrafickiObjekat();
                        KoordinatorForm.instance().postaviFormu(oef);
                    }
                    PrikazPoruku(DTO.getSignal());
                }
                
            }
        });
     }
     
    void PrikazPoruku(String signal)
    { Boolean prikazi = new Boolean(true);
      DijalogBoksPrikazPoruke DBPP = DijalogBoksPrikazPoruke.getInstance();
      int signal1 = DBPP.PrikazPoruke(signal);
      if (signal1 == 1)
        { DBPP.show();
          DBPP.pack();
        }
    }
}
