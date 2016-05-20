/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.ucesnik;

import decorator.form.UnosForm;
import kontroler.ucesnik.KontrolerCBoxMesto;
import kontroler.ucesnik.KontrolerRBtnUcesnik;
import panel.form.oef.OpstaEkranskaForma;
import panel.form.ucesnik.UcesnikPanelForm;
import panel.ucesnik.CBoxMesto;
import panel.ucesnik.RBtnUcesnik;
import panel.ucesnik.TFAdresa;
import panel.ucesnik.TFEmail;
import panel.ucesnik.TFTelefon;
import panel.ucesnik.TFUcesnikId;

/**
 *
 * @author Mladen
 */
public abstract class UcesnikForma extends UnosForm{  //ConcreateComponent

    private UcesnikPanelForm ucesnikPanelForm;

    public UcesnikForma(UcesnikPanelForm ucesnikPanelForm) {
        super(ucesnikPanelForm);
        
        this.ucesnikPanelForm = ucesnikPanelForm;
    }
    
    @Override
     public void setPanel() {
        ucesnikPanelForm.setRbtnUcenik(new RBtnUcesnik());
        ucesnikPanelForm.setCboxMesto(new CBoxMesto());
        ucesnikPanelForm.setTfUcesnikId(new TFUcesnikId());        
        ucesnikPanelForm.setTfEmail(new TFEmail());
        ucesnikPanelForm.setTfAdresa(new TFAdresa());
        ucesnikPanelForm.setTfTelefon(new TFTelefon());
        
    }

    @Override
    public void setControler() {
        new KontrolerCBoxMesto(ucesnikPanelForm.getCboxMesto());
        new KontrolerRBtnUcesnik(ucesnikPanelForm);
        
    }
    
}
