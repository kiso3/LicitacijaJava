/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder.prijava;

import builder.BuilderForm;
import form.prijava.OglasForm;
import decorator.form.UnosForm;
import panel.form.ucesnik.OglasPanelForm;
import panel.form.oef.OpstaEkranskaForma;

/**
 *
 * @author Mladen
 */
public class OglasBuidlerForm implements BuilderForm{

    OglasPanelForm oglasPanelForm;

    public OglasBuidlerForm() {
        
        oglasPanelForm = new OglasPanelForm();
    }
    
    
    
    @Override
    public void KreirajFormu() {
        UnosForm oglasForm = new OglasForm(oglasPanelForm);
        oglasForm.setPanel();
        oglasForm.setControler();
    }

    @Override
    public OpstaEkranskaForma vratiRezultat() {
        return oglasPanelForm;
    }
    
}
