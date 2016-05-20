/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.ucesnik;

import panel.form.ucesnik.UcesnikPravnoPanelForm;
import panel.ucesnik.TFMb;
import panel.ucesnik.TFNaziv;
import panel.ucesnik.TFPib;

/**
 *
 * @author Mladen
 */
public class UcesnikPravnoForm extends UcesnikForma{
    
    private UcesnikPravnoPanelForm  ucesnikPravnoPanelForm;
    
    public UcesnikPravnoForm(UcesnikPravnoPanelForm ucesnikPravnoPanelForm) {
        super(ucesnikPravnoPanelForm);
        this.ucesnikPravnoPanelForm = ucesnikPravnoPanelForm;
    }
    
    @Override
     public void setPanel() {
        super.setPanel();
        ucesnikPravnoPanelForm.setTfMb(new TFMb());
        ucesnikPravnoPanelForm.setTfNaziv(new TFNaziv());
        ucesnikPravnoPanelForm.setTfPib(new TFPib());        
    }

    @Override
    public void setControler() {
        super.setControler();
    }
    
}
