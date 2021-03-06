/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator.form.ucesnik;

import decorator.form.DecoratorForm;
import decorator.form.UnosForm;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import kontroler.ucesnik.KontrolerBtnUcesnikDodaj;
import panel.form.ucesnik.UcesnikFizickoPanelForm;
import panel.form.ucesnik.UcesnikFizickoPanelForm;
import panel.form.ucesnik.UcesnikPravnoPanelForm;
import panel.form.ucesnik.UcesnikPravnoPanelForm;
import panel.generic.BtnPanel;

/**
 *
 * @author Mladen
 */
public class BtnUcesnikDodajPanelForm extends DecoratorForm{ //
    
    public BtnPanel btnPanel;
    
    public BtnUcesnikDodajPanelForm(UnosForm unosForm) {
        super(unosForm);
        this.btnPanel = new BtnPanel("Dodaj");
    }
    
    @Override
    public void setPanel() {
        super.setPanel();
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 6;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        unosForm.oef.add(btnPanel,c);  
    }

    @Override
    public void setControler() {
        super.setControler();   
        if(unosForm.oef instanceof UcesnikFizickoPanelForm){
         new KontrolerBtnUcesnikDodaj(this);
        }        
        if(unosForm.oef instanceof UcesnikPravnoPanelForm){
         new KontrolerBtnUcesnikDodaj(this);
        }
        
    }
}
