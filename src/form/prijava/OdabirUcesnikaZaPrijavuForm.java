/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.prijava;

import decorator.form.UnosForm;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import kontroler.ucesnik.KontrolerTableUcesnik;
import kontroler.prijava.KontrolerBtnOdaberiUcesnikaZaPrijavu;
import kontroler.prijava.KontrolerTableOdabirUcesnikaZaPrijavu;
import model.table.UcesnikTableModel;
import panel.form.ucesnik.UcesnikTablePanelForm;
import panel.ucesnik.TFIme;

/**
 *
 * @author Mladen
 */
public class OdabirUcesnikaZaPrijavuForm extends UnosForm{ //ConcreateComponent
    
    private UcesnikTablePanelForm ucesnikTablePanelForm;
    
    public OdabirUcesnikaZaPrijavuForm(UcesnikTablePanelForm ucesnikTablePanelForm) {
        super(ucesnikTablePanelForm);
        
        this.ucesnikTablePanelForm = ucesnikTablePanelForm;
    }

    
    
    @Override
    public void setPanel() {       
        ucesnikTablePanelForm.setTblUcesnik(new JTable());
        ucesnikTablePanelForm.setUcesnikTableModel(new UcesnikTableModel());
        ucesnikTablePanelForm.setjScrollPane(new JScrollPane());
    }

    @Override
    public void setControler() {
        new KontrolerTableOdabirUcesnikaZaPrijavu(this.ucesnikTablePanelForm);
    }
}
