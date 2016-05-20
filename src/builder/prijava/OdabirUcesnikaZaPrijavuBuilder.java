/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder.prijava;

import builder.BuilderForm;
import domen.OpstiDomenskiObjekat;
import form.prijava.OdabirUcesnikaZaPrijavuForm;
import decorator.form.UnosForm;
import decorator.form.prijava.BtnNazadNadmetanjeZaOglasPanelForm;
import decorator.form.prijava.BtnNazadPrijaveZaNadmetanjePanelForm;
import decorator.form.prijava.BtnOdaberiUcesnikaZaPrijavu;
import panel.form.oef.OpstaEkranskaForma;
import panel.form.ucesnik.UcesnikTablePanelForm;

/**
 *
 * @author Mladen
 */
public class OdabirUcesnikaZaPrijavuBuilder implements BuilderForm {
 UcesnikTablePanelForm ucesnikTablePanelForm;

    public OdabirUcesnikaZaPrijavuBuilder() {
        
        ucesnikTablePanelForm = new UcesnikTablePanelForm();
    }
    
    public OdabirUcesnikaZaPrijavuBuilder(OpstiDomenskiObjekat odo) {        
        ucesnikTablePanelForm = new UcesnikTablePanelForm();
        ucesnikTablePanelForm.setOdo(odo);
    }
    
    
    @Override
    public void KreirajFormu() {
        UnosForm ucesnikTableForm =
                new BtnNazadPrijaveZaNadmetanjePanelForm(
                new BtnOdaberiUcesnikaZaPrijavu(
                new OdabirUcesnikaZaPrijavuForm(ucesnikTablePanelForm)));
        ucesnikTableForm.setPanel();
        ucesnikTableForm.setControler();
    }

    @Override
    public OpstaEkranskaForma vratiRezultat() {
        return ucesnikTablePanelForm;
    }
}
