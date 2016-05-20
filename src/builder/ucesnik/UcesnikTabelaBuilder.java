/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder.ucesnik;

import builder.BuilderForm;
import form.ucesnik.UcesnikTableForm;
import decorator.form.UnosForm;
import decorator.form.ucesnik.BtnUcesnikTabeObrisi;
import decorator.form.ucesnik.BtnUcesnikTableDodaj;
import decorator.form.ucesnik.BtnUcesnikTableIzmeni;
import panel.form.oef.OpstaEkranskaForma;
import panel.form.ucesnik.UcesnikTablePanelForm;

/**
 *
 * @author Mladen
 */
public class UcesnikTabelaBuilder implements BuilderForm{  //ConcreateBuilder

    UcesnikTablePanelForm ucesnikTablePanelForm;

    public UcesnikTabelaBuilder() {
        
        ucesnikTablePanelForm = new UcesnikTablePanelForm();
    }
    
    
    
    @Override
    public void KreirajFormu() {
        UnosForm ucesnikTableForm = new BtnUcesnikTableIzmeni(
                new BtnUcesnikTableDodaj(
                        new BtnUcesnikTabeObrisi(
                                new UcesnikTableForm(
                                        ucesnikTablePanelForm)
                        )
                )
        );
        ucesnikTableForm.setPanel();
        ucesnikTableForm.setControler();
    }

    @Override
    public OpstaEkranskaForma vratiRezultat() {
        return ucesnikTablePanelForm;
    }
    
}
