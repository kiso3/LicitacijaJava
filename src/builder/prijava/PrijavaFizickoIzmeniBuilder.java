/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder.prijava;

import builder.BuilderForm;
import form.prijava.PrijavaFizickoForm;
import decorator.form.UnosForm;
import decorator.form.prijava.BtnNazadPrijavaZaNadmetanjeSaPrijavPanelForm;
import decorator.form.prijava.BtnPrijavaIzmeni;
import panel.form.prijava.PrijavaFizickoPanelForm;
import panel.form.oef.OpstaEkranskaForma;

/**
 *
 * @author Mladen
 */
public class PrijavaFizickoIzmeniBuilder implements BuilderForm{
    PrijavaFizickoPanelForm prijavaFizickoPanelForm;

    public PrijavaFizickoIzmeniBuilder() {
        prijavaFizickoPanelForm = new PrijavaFizickoPanelForm();        
    }
    
    @Override
    public void KreirajFormu() {
        UnosForm prijavaFizickoForm = 
                new BtnNazadPrijavaZaNadmetanjeSaPrijavPanelForm(
                new BtnPrijavaIzmeni (new PrijavaFizickoForm(
                    prijavaFizickoPanelForm
                )));
        prijavaFizickoForm.setPanel();
        prijavaFizickoForm.setControler();               
    }

    @Override
    public OpstaEkranskaForma vratiRezultat() {
        return prijavaFizickoPanelForm;
    }
    
}
