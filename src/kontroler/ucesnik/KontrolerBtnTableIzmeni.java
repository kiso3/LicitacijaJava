/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.ucesnik;

import builder.DirectorForm;
import builder.ucesnik.UcesnikFizickoBuilder;
import builder.ucesnik.UcesnikFizickoIzmeniBuilder;
import builder.ucesnik.UcesnikPravnoBuilder;
import builder.ucesnik.UcesnikPravnoIzmeniBuilder;
import domen.OpstiDomenskiObjekat;
import domen.UcesnikFizicko;
import domen.UcesnikPravno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import komunikacija.Komunikacija;
import koordinator.form.KoordinatorForm;
import decorator.form.ucesnik.BtnUcesnikTableIzmeni;
import javax.swing.table.DefaultTableModel;
import model.table.UcesnikTableModel;
import panel.form.oef.OpstaEkranskaForma;
import panel.form.ucesnik.UcesnikTablePanelForm;

/**
 *
 * @author Mladen
 */
public class KontrolerBtnTableIzmeni {
    private Object panel;
    private Komunikacija komunikacija;
    public KontrolerBtnTableIzmeni(Object panel){
        this.panel = panel;
        try {
            komunikacija = Komunikacija.getInstance();
        } catch (Exception e) {
            System.out.println("Neuspelo uspostavljanje veze sa serverom");
        }
        
        setControler(panel);
    }

    private void setControler(Object panel) {
        BtnUcesnikTableIzmeni btnUcesnikTableIzmeni = (BtnUcesnikTableIzmeni) panel;
        
        btnUcesnikTableIzmeni.btnPanel.btnPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UcesnikTablePanelForm ucesnikTablePanelForm = (UcesnikTablePanelForm)btnUcesnikTableIzmeni.oef;                
                int selectedRowSorter = ucesnikTablePanelForm.getTblUcesnik().getSelectedRow();
                int selectedRow = ucesnikTablePanelForm.getTblUcesnik().getRowSorter().convertRowIndexToModel(selectedRowSorter);
                UcesnikTableModel ucesnikTableModel = (UcesnikTableModel) ucesnikTablePanelForm.getUcesnikTableModel();
                OpstiDomenskiObjekat odo = ucesnikTableModel.getListaUcesnika().get(selectedRow);
                if(odo instanceof UcesnikFizicko){
                    builder.DirectorForm director = new DirectorForm(new UcesnikFizickoIzmeniBuilder());
                    OpstaEkranskaForma oef = director.Konstruisi();
                    oef.setOdo((UcesnikFizicko) odo);                    
                    oef.KonvertujDomenskiObjekatUGrafickiObjekat();
                    KoordinatorForm.instance().postaviFormu(oef);
                    
                }else{
                    builder.DirectorForm director = new DirectorForm(new UcesnikPravnoIzmeniBuilder());
                    OpstaEkranskaForma oef = director.Konstruisi();
                    oef.setOdo((UcesnikPravno) odo);
                    oef.KonvertujDomenskiObjekatUGrafickiObjekat();
                    KoordinatorForm.instance().postaviFormu(oef);
                }
            }
        });
    }
}
