/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.ucesnik;

import decorator.form.UnosForm;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import kontroler.ucesnik.KontrolerTFPretraga;
import kontroler.ucesnik.KontrolerTableUcesnik;
import model.table.UcesnikTableModel;
import panel.form.oef.OpstaEkranskaForma;
import panel.form.ucesnik.UcesnikTablePanelForm;
import panel.ucesnik.TFPretraga;

/**
 *
 * @author Mladen
 */
public class UcesnikTableForm extends UnosForm{ //ConcreateComponent

    private UcesnikTablePanelForm ucesnikTablePanelForm;
    
    public UcesnikTableForm(UcesnikTablePanelForm ucesnikTablePanelForm) {
        super(ucesnikTablePanelForm);
        
        this.ucesnikTablePanelForm = ucesnikTablePanelForm;
    }
        
    @Override
    public void setPanel() {
        ucesnikTablePanelForm.setTblUcesnik(new JTable());
        ucesnikTablePanelForm.setUcesnikTableModel(new UcesnikTableModel());
        ucesnikTablePanelForm.setjScrollPane(new JScrollPane());
        ucesnikTablePanelForm.setTfPretraga(new TFPretraga());
    }

    @Override
    public void setControler() {
        new KontrolerTableUcesnik(this.ucesnikTablePanelForm);
        new KontrolerTFPretraga(this.ucesnikTablePanelForm);

    }
    
}
