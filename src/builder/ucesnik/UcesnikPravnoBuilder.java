/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder.ucesnik;

import builder.BuilderForm;
import form.ucesnik.UcesnikPravnoForm;
import decorator.form.UnosForm;
import decorator.form.ucesnik.BtnUcesnikDodajPanelForm;
import panel.form.oef.OpstaEkranskaForma;
import panel.form.ucesnik.UcesnikPravnoPanelForm;

/**
 *
 * @author Mladen
 */
public class UcesnikPravnoBuilder implements BuilderForm
{
    UcesnikPravnoPanelForm ucesnikPravnoPanelForm;

    public UcesnikPravnoBuilder() {
        ucesnikPravnoPanelForm = new UcesnikPravnoPanelForm();
    }
    
    @Override
    public void KreirajFormu() {
        UnosForm ucesnikFizickoForm = new BtnUcesnikDodajPanelForm(new UcesnikPravnoForm(ucesnikPravnoPanelForm));
        ucesnikFizickoForm.setPanel();
        ucesnikFizickoForm.setControler();       
    }

    @Override
    public OpstaEkranskaForma vratiRezultat() {
        return ucesnikPravnoPanelForm;
    }
    
}
