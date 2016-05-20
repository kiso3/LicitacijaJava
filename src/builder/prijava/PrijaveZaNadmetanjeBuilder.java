/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder.prijava;

import builder.BuilderForm;
import domen.OpstiDomenskiObjekat;
import form.prijava.PrijavaZaNadmetanjeForm;
import decorator.form.UnosForm;
import decorator.form.prijava.BtnNazadNadmetanjeZaOglasPanelForm;
import decorator.form.prijava.BtnNazadPrijaveZaNadmetanjePanelForm;
import decorator.form.prijava.BtnPrijavaTableDodaj;
import decorator.form.prijava.BtnPrijavaTableIzmeni;
import decorator.form.prijava.BtnPrijavaTableObrisi;
import panel.form.prijava.PrijaveZaNadmetanjePanelForm;
import panel.form.oef.OpstaEkranskaForma;

/**
 *
 * @author Mladen
 */
public class PrijaveZaNadmetanjeBuilder implements BuilderForm{

    PrijaveZaNadmetanjePanelForm prijaveZaNadmetanjePanleForm;
    
    public PrijaveZaNadmetanjeBuilder(OpstiDomenskiObjekat odo){
        prijaveZaNadmetanjePanleForm = new PrijaveZaNadmetanjePanelForm();        
        prijaveZaNadmetanjePanleForm.setOdo(odo);
    }
    
    @Override
    public void KreirajFormu() {
        UnosForm prijaveZaNamdetanjeForm = new BtnNazadNadmetanjeZaOglasPanelForm(
                new BtnPrijavaTableIzmeni(
                new BtnPrijavaTableObrisi(
                new BtnPrijavaTableDodaj(
                new PrijavaZaNadmetanjeForm(
                prijaveZaNadmetanjePanleForm)))));
        prijaveZaNamdetanjeForm.setPanel();
        prijaveZaNamdetanjeForm.setControler();        
    }

    @Override
    public OpstaEkranskaForma vratiRezultat() {
        return prijaveZaNadmetanjePanleForm;
    }
    
}
