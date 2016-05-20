/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder.prijava;

import builder.BuilderForm;
import form.prijava.PrijavaFizickoForm;
import form.prijava.PrijavaPravnoForm;
import decorator.form.UnosForm;
import decorator.form.prijava.BtnNazadPrijavaZaNadmetanjeSaPrijavPanelForm;
import decorator.form.prijava.BtnPrijavaIzmeni;
import panel.form.prijava.PrijavaFizickoPanelForm;
import panel.form.prijava.PrijavaPravnoPanelForm;
import panel.form.oef.OpstaEkranskaForma;

/**
 *
 * @author Mladen
 */
public class PrijavaPravnoBuilder implements BuilderForm{
    PrijavaPravnoPanelForm prijavaPravnoPanelForm;

    public PrijavaPravnoBuilder() {
        prijavaPravnoPanelForm = new PrijavaPravnoPanelForm();
    }
    
    @Override
    public void KreirajFormu() {
        UnosForm prijavaPravnoForm =
                new BtnNazadPrijavaZaNadmetanjeSaPrijavPanelForm(
                new BtnPrijavaIzmeni (new PrijavaPravnoForm(
                    prijavaPravnoPanelForm
                )));
        prijavaPravnoForm.setPanel();
        prijavaPravnoForm.setControler();       
    }

    @Override
    public OpstaEkranskaForma vratiRezultat() {
        return prijavaPravnoPanelForm;
    }
}
