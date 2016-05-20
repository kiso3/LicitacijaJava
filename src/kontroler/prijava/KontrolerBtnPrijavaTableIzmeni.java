/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.prijava;

import builder.DirectorForm;
import builder.prijava.PrijavaFizickoIzmeniBuilder;
import builder.prijava.PrijavaPravnoBuilder;
import domen.Nadmetanje;
import domen.OpstiDomenskiObjekat;
import domen.PrijavaFizicko;
import domen.PrijavaPravno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import komunikacija.Komunikacija;
import koordinator.form.KoordinatorForm;
import model.table.OdoTableModel;
import decorator.form.prijava.BtnPrijavaTableIzmeni;
import panel.form.prijava.PrijaveZaNadmetanjePanelForm;
import panel.form.oef.OpstaEkranskaForma;

/**
 *
 * @author Mladen
 */
public class KontrolerBtnPrijavaTableIzmeni {
    private Object panel;
    private Komunikacija komunikacija;
    public KontrolerBtnPrijavaTableIzmeni(Object panel){
        this.panel = panel;
        try {
            komunikacija = Komunikacija.getInstance();
        } catch (Exception e) {
            System.out.println("Neuspelo uspostavljanje veze sa serverom");
        }
        
        setControler(panel);
    }

    private void setControler(Object panel) {
        BtnPrijavaTableIzmeni btnPrijavaTableIzmeni = (BtnPrijavaTableIzmeni) panel;
        
        btnPrijavaTableIzmeni.btnPanel.btnPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrijaveZaNadmetanjePanelForm prijaveZaNadmetanjePanelForm = (PrijaveZaNadmetanjePanelForm)btnPrijavaTableIzmeni.oef;                
                int selectedRow = prijaveZaNadmetanjePanelForm.getTblNdmetanje().getSelectedRow();
                OdoTableModel odoTableModel = (OdoTableModel) prijaveZaNadmetanjePanelForm.getTableModel();
                OpstiDomenskiObjekat odo = odoTableModel.getListaUcesnika().get(selectedRow);
                Nadmetanje nadmetanje = (Nadmetanje) prijaveZaNadmetanjePanelForm.getOdo();
                if(odo instanceof PrijavaFizicko){
                    builder.DirectorForm director = new DirectorForm(new PrijavaFizickoIzmeniBuilder());
                    OpstaEkranskaForma oef = director.Konstruisi();
                    PrijavaFizicko pp = (PrijavaFizicko) odo;                    
                    pp.setNadmetanje(nadmetanje);
                    oef.setOdo(pp);
                    oef.KonvertujDomenskiObjekatUGrafickiObjekat();
                    KoordinatorForm.instance().postaviFormu(oef);
                    
                }else{
                    builder.DirectorForm director = new DirectorForm(new PrijavaPravnoBuilder());
                    OpstaEkranskaForma oef = director.Konstruisi();
                    PrijavaPravno pp = (PrijavaPravno) odo;                    
                    pp.setNadmetanje(nadmetanje);
                    oef.setOdo((PrijavaPravno) odo);
                    oef.KonvertujDomenskiObjekatUGrafickiObjekat();
                    KoordinatorForm.instance().postaviFormu(oef);
                }
            }
        });
    }
}
