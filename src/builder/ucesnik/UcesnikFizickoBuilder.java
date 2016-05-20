/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder.ucesnik;

import builder.BuilderForm;
import form.ucesnik.UcesnikFizickoForm;
import decorator.form.UnosForm;
import panel.form.oef.OpstaEkranskaForma;
import panel.form.ucesnik.UcesnikFizickoPanelForm;
import decorator.form.ucesnik.BtnUcesnikDodajPanelForm;

/**
 *
 * @author Mladen
 */
public class UcesnikFizickoBuilder implements BuilderForm{

    UcesnikFizickoPanelForm ucesnikFizickoPanelForm;

    public UcesnikFizickoBuilder() {
        
        ucesnikFizickoPanelForm = new UcesnikFizickoPanelForm();
    }
    
    @Override
    public void KreirajFormu() {
        UnosForm ucesnikFizickoForm = 
                new BtnUcesnikDodajPanelForm(
                new UcesnikFizickoForm(
                        ucesnikFizickoPanelForm
                )
        );
        ucesnikFizickoForm.setPanel();
        ucesnikFizickoForm.setControler();
    }

    @Override
    public OpstaEkranskaForma vratiRezultat() {
        return ucesnikFizickoPanelForm;
    }
    
}
