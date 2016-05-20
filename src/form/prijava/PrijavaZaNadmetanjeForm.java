/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.prijava;

import decorator.form.UnosForm;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import kontroler.prijava.KontrolerTablePrijava;
import model.table.NadmetanjeTableModel;
import model.table.PrijaveTableModel;
import panel.form.prijava.PrijaveZaNadmetanjePanelForm;
import panel.nadmetanje.TFDepozit;
import panel.nadmetanje.TFNadmetanjeOznaka;
import panel.nadmetanje.TFPocetanCena;
import panel.nadmetanje.TFPovrsina;
import panel.oglas.CBoxOglas;
import panel.oglas.TFLicitacijskiKorak;
import panel.oglas.TFMaxPovZakupa;
import panel.oglas.TFNazivOpstine;
import panel.oglas.TFOglasId;

/**
 *
 * @author Mladen
 */
public class PrijavaZaNadmetanjeForm extends UnosForm{ //ConcreateComponent
    
    private PrijaveZaNadmetanjePanelForm prijaveZaNadmetanjePanelForm;

    public PrijavaZaNadmetanjeForm(PrijaveZaNadmetanjePanelForm prijaveZaNadmetanjePanelForm) {
        super(prijaveZaNadmetanjePanelForm);        
        this.prijaveZaNadmetanjePanelForm = prijaveZaNadmetanjePanelForm;
    }
    
    @Override
    public void setPanel() {        
        prijaveZaNadmetanjePanelForm.setTfOglasId(new TFOglasId());
        prijaveZaNadmetanjePanelForm.setTfNazivOpstine(new TFNazivOpstine());
        prijaveZaNadmetanjePanelForm.setTfLicitacijskiKorak(new TFLicitacijskiKorak());
        prijaveZaNadmetanjePanelForm.setTfMaxPovZakupa(new TFMaxPovZakupa());        
        
        prijaveZaNadmetanjePanelForm.setTfNadmetanjeOznaka(new TFNadmetanjeOznaka());
        prijaveZaNadmetanjePanelForm.setTfDepozit(new TFDepozit());
        prijaveZaNadmetanjePanelForm.setTfPocetanCena(new TFPocetanCena());
        prijaveZaNadmetanjePanelForm.setTfPovrsina(new TFPovrsina());
        
        prijaveZaNadmetanjePanelForm.setTblNdmetanje(new JTable());
        prijaveZaNadmetanjePanelForm.setTableModel(new PrijaveTableModel());
        prijaveZaNadmetanjePanelForm.setjScrollPane(new JScrollPane());
    }

    @Override
    public void setControler() {
        new KontrolerTablePrijava(prijaveZaNadmetanjePanelForm);
    }
}
