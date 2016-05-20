/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import panel.form.oef.OpstaEkranskaForma;

/**
 *
 * @author Mladen
 */
public class DirectorForm { //Director
    
    BuilderForm builderForm;

    public DirectorForm(BuilderForm builderForm) {
        this.builderForm = builderForm;
    }
    
    public OpstaEkranskaForma Konstruisi(){
        builderForm.KreirajFormu();
        return builderForm.vratiRezultat();
    }
}
