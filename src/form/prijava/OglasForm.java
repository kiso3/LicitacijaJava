/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.prijava;

import decorator.form.UnosForm;
import panel.form.ucesnik.OglasPanelForm;
import panel.form.oef.OpstaEkranskaForma;
import panel.oglas.TFOglasId;

/**
 *
 * @author Mladen
 */
public class OglasForm extends UnosForm{ //ConcreateComponent

    private OglasPanelForm oglasPanelForm;

    public OglasForm(OglasPanelForm oglasPanelForm) {
        super(oglasPanelForm);
        
        this.oglasPanelForm = oglasPanelForm;
    }
    
    @Override
    public void setPanel() {
        oglasPanelForm.setTfOglasId(new TFOglasId());
    }

    @Override
    public void setControler() {
        
    }
    
}
