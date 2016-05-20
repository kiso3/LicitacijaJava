/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder.prijava;

import builder.BuilderForm;
import domen.OpstiDomenskiObjekat;
import form.prijava.NadmetanjeZaOglasForm;
import form.ucesnik.UcesnikFizickoForm;
import decorator.form.UnosForm;
import decorator.form.prijava.BtnPrijaveZaNadmetanje;
import panel.form.prijava.NadmetanjeZaOglasPanelForm;
import decorator.form.ucesnik.BtnUcesnikDodajPanelForm;
import panel.form.oef.OpstaEkranskaForma;

/**
 *
 * @author Mladen
 */
public class NadmetanjeZaOglasBuilder implements BuilderForm{
    NadmetanjeZaOglasPanelForm nadmetanjeZaOglasPanelForm;

    public NadmetanjeZaOglasBuilder() {
        nadmetanjeZaOglasPanelForm = new NadmetanjeZaOglasPanelForm();
    }
    
    public NadmetanjeZaOglasBuilder(OpstiDomenskiObjekat odo) {
        nadmetanjeZaOglasPanelForm = new NadmetanjeZaOglasPanelForm();
        nadmetanjeZaOglasPanelForm.setOdo(odo);
    }

    
    @Override
    public void KreirajFormu() {
        UnosForm nadmetanjeZaOglasForm = new BtnPrijaveZaNadmetanje(new NadmetanjeZaOglasForm(nadmetanjeZaOglasPanelForm));
        //UnosForm nadmetanjeZaOglasForm = new NadmetanjeZaOglasForm(nadmetanjeZaOglasPanelForm);
        nadmetanjeZaOglasForm.setPanel();
        nadmetanjeZaOglasForm.setControler();
    }

    @Override
    public OpstaEkranskaForma vratiRezultat() {
        return nadmetanjeZaOglasPanelForm;
    }
}
