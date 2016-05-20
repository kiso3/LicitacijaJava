/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator.form.prijava;

import decorator.form.DecoratorForm;
import decorator.form.UnosForm;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import kontroler.prijava.KontrolerBtnOdaberiUcesnikaZaPrijavu;
import panel.generic.BtnPanel;

/**
 *
 * @author Mladen
 */
public class BtnOdaberiUcesnikaZaPrijavu extends DecoratorForm  {
    public BtnPanel btnPanel;
    
    public BtnOdaberiUcesnikaZaPrijavu(UnosForm unosForm) {
        super(unosForm);
        this.btnPanel = new BtnPanel("Odaberi");
    }

    @Override
    public void setControler() {
        super.setControler();        
        new KontrolerBtnOdaberiUcesnikaZaPrijavu(this);
    }

    @Override
    public void setPanel() {
        super.setPanel(); 
            GridBagConstraints c =new GridBagConstraints();
            c.fill = GridBagConstraints.BASELINE_LEADING;
            c.gridx = 0;
            c.gridy = 3;
            c.anchor = GridBagConstraints.WEST;
            c.insets = new Insets(2,2,2,2);
            unosForm.oef.add(btnPanel,c);    
    
    } 
}
