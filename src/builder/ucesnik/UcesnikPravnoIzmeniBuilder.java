/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder.ucesnik;

import builder.BuilderForm;
import form.ucesnik.UcesnikPravnoForm;
import decorator.form.UnosForm;
import decorator.form.ucesnik.BtnUcesnikIzmeniPanelForm;
import panel.form.ucesnik.UcesnikPravnoPanelForm;
import panel.form.oef.OpstaEkranskaForma;

/**
 *
 * @author Mladen
 */
public class UcesnikPravnoIzmeniBuilder implements BuilderForm {
    UcesnikPravnoPanelForm ucesnikPravnoPanelForm;

    public UcesnikPravnoIzmeniBuilder() {
        
        ucesnikPravnoPanelForm = new UcesnikPravnoPanelForm();
    }
    
    @Override
    public void KreirajFormu() {
        UnosForm ucesnikFizickoForm = new BtnUcesnikIzmeniPanelForm(new UcesnikPravnoForm(ucesnikPravnoPanelForm));
        ucesnikFizickoForm.setPanel();
        ucesnikFizickoForm.setControler();
        ucesnikPravnoPanelForm.getRbtnUcenik().rbtnUcenikFizicko.setEnabled(false);
        ucesnikPravnoPanelForm.getRbtnUcenik().rbtnUcenikPravn.setEnabled(false);
    }

    @Override
    public OpstaEkranskaForma vratiRezultat() {
        return ucesnikPravnoPanelForm;
    }
}
