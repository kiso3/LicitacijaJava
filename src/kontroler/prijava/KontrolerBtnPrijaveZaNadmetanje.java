/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.prijava;

import builder.DirectorForm;
import builder.prijava.PrijaveZaNadmetanjeBuilder;
import builder.ucesnik.UcesnikFizickoIzmeniBuilder;
import builder.ucesnik.UcesnikPravnoBuilder;
import domen.OpstiDomenskiObjekat;
import domen.Prijava;
import domen.UcesnikFizicko;
import domen.UcesnikPravno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import komunikacija.Komunikacija;
import koordinator.form.KoordinatorForm;
import decorator.form.ucesnik.BtnUcesnikTableIzmeni;
import model.table.UcesnikTableModel;
import decorator.form.prijava.BtnPrijaveZaNadmetanje;
import panel.form.prijava.NadmetanjeZaOglasPanelForm;
import panel.form.oef.OpstaEkranskaForma;
import panel.form.ucesnik.UcesnikTablePanelForm;

/**
 *
 * @author Mladen
 */
public class KontrolerBtnPrijaveZaNadmetanje {
    private BtnPrijaveZaNadmetanje panel;
    private Komunikacija komunikacija;
    public KontrolerBtnPrijaveZaNadmetanje(Object panel){
        this.panel = (BtnPrijaveZaNadmetanje) panel;
        try {
            komunikacija = Komunikacija.getInstance();
            setControler();
        } catch (Exception e) {
            System.out.println("Neuspelo uspostavljanje veze sa serverom");
        }        
    }

    private void setControler() {        
        
        panel.btnPanel.btnPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NadmetanjeZaOglasPanelForm nadmetanjeZaOglasPanelForm = (NadmetanjeZaOglasPanelForm)panel.oef;                
                int selectedRow = nadmetanjeZaOglasPanelForm.getTblNdmetanje().getSelectedRow();
                if(selectedRow == -1) return;
                OpstiDomenskiObjekat odo = nadmetanjeZaOglasPanelForm.getTableModel().getListaUcesnika().get(selectedRow);                               
                    builder.DirectorForm director = new DirectorForm(new PrijaveZaNadmetanjeBuilder(odo));
                    OpstaEkranskaForma oef = director.Konstruisi();
                    //oef.setOdo(odo);                                          
                    oef.KonvertujDomenskiObjekatUGrafickiObjekat();
                    KoordinatorForm.instance().postaviFormu(oef); 
            }
        });
    }
}
