/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.ucesnik;

import panel.form.ucesnik.UcesnikFizickoPanelForm;
import panel.ucesnik.TFIme;
import panel.ucesnik.TFImeRoditelja;
import panel.ucesnik.TFJmbg;
import panel.ucesnik.TFPrezime;

/**
 *
 * @author Mladen
 */
public class UcesnikFizickoForm extends UcesnikForma{
    
    private UcesnikFizickoPanelForm ucesnikFizickoPanelForm;
    
    public UcesnikFizickoForm(UcesnikFizickoPanelForm ucesnikFizickoPanelForm) {
        super(ucesnikFizickoPanelForm);
        
        this.ucesnikFizickoPanelForm = ucesnikFizickoPanelForm;
    }
    
    @Override
     public void setPanel() {
        super.setPanel();
        ucesnikFizickoPanelForm.setTfJmbg(new TFJmbg());
        ucesnikFizickoPanelForm.setTfIme(new TFIme());
        ucesnikFizickoPanelForm.setTfImeRoditelja(new TFImeRoditelja());
        ucesnikFizickoPanelForm.setTfPrezime(new TFPrezime());
    }

    @Override
    public void setControler() {
        super.setControler();
    }
    
}
