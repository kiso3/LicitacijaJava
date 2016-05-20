/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder.ucesnik;

import builder.BuilderForm;
import form.ucesnik.UcesnikFizickoForm;
import decorator.form.UnosForm;
import decorator.form.ucesnik.BtnUcesnikDodajPanelForm;
import decorator.form.ucesnik.BtnUcesnikIzmeniPanelForm;
import panel.form.oef.OpstaEkranskaForma;
import panel.form.ucesnik.UcesnikFizickoPanelForm;

/**
 *
 * @author Mladen
 */
public class UcesnikFizickoIzmeniBuilder implements BuilderForm {
    UcesnikFizickoPanelForm ucesnikFizickoPanelForm;

    public UcesnikFizickoIzmeniBuilder() {
        
        ucesnikFizickoPanelForm = new UcesnikFizickoPanelForm();
    }
    
    @Override
    public void KreirajFormu() {
        UnosForm ucesnikFizickoForm = new BtnUcesnikIzmeniPanelForm(new UcesnikFizickoForm(ucesnikFizickoPanelForm));
        ucesnikFizickoForm.setPanel();
        ucesnikFizickoForm.setControler();
        ucesnikFizickoPanelForm.getRbtnUcenik().rbtnUcenikFizicko.setEnabled(false);
        ucesnikFizickoPanelForm.getRbtnUcenik().rbtnUcenikPravn.setEnabled(false);
    }

    @Override
    public OpstaEkranskaForma vratiRezultat() {
        return ucesnikFizickoPanelForm;
    }
}
