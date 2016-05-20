/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.prijava;

import decorator.form.UnosForm;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import kontroler.prijava.KontrolerCBoxOglas;
import kontroler.prijava.KontrolerTableNadmetanje;
import model.table.NadmetanjeTableModel;
import panel.form.prijava.NadmetanjeZaOglasPanelForm;
import panel.form.ucesnik.UcesnikPanelForm;
import panel.oglas.CBoxOglas;
import panel.oglas.TFLicitacijskiKorak;
import panel.oglas.TFMaxPovZakupa;
import panel.oglas.TFNazivOpstine;
import panel.oglas.TFOglasId;
import panel.ucesnik.CBoxMesto;

/**
 *
 * @author Mladen
 */
public class NadmetanjeZaOglasForm extends UnosForm{ //ConcreateComponent

    private NadmetanjeZaOglasPanelForm nadmetanjeZaOglasPanelForm;

    public NadmetanjeZaOglasForm(NadmetanjeZaOglasPanelForm nadmetanjeZaOglasPanelForm) {
        super(nadmetanjeZaOglasPanelForm);        
        this.nadmetanjeZaOglasPanelForm = nadmetanjeZaOglasPanelForm;
    }
    
    @Override
    public void setPanel() {
        nadmetanjeZaOglasPanelForm.setCboxOglas(new CBoxOglas());
        nadmetanjeZaOglasPanelForm.setTfOglasId(new TFOglasId());
        nadmetanjeZaOglasPanelForm.setTfNazivOpstine(new TFNazivOpstine());
        nadmetanjeZaOglasPanelForm.setTfLicitacijskiKorak(new TFLicitacijskiKorak());
        nadmetanjeZaOglasPanelForm.setTfMaxPovZakupa(new TFMaxPovZakupa());        
        nadmetanjeZaOglasPanelForm.setTblNdmetanje(new JTable());
        nadmetanjeZaOglasPanelForm.setTableModel(new NadmetanjeTableModel());
        nadmetanjeZaOglasPanelForm.setjScrollPane(new JScrollPane());
    }

    @Override
    public void setControler() {
        new KontrolerCBoxOglas(nadmetanjeZaOglasPanelForm.getCboxOglas());
        new KontrolerTableNadmetanje(nadmetanjeZaOglasPanelForm);
    }
    
}
