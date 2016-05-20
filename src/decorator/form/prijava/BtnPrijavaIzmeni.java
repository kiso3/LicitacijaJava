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
import kontroler.prijava.KontrolerBtnPrijavaIzmeni;
import panel.generic.BtnPanel;

/**
 *
 * @author Mladen
 */
public class BtnPrijavaIzmeni extends DecoratorForm {
    public BtnPanel btnPanel;
    
    public BtnPrijavaIzmeni(UnosForm unosForm) {
        super(unosForm);
        this.btnPanel = new BtnPanel("Izmeni");
    }

    @Override
    public void setControler() {
        super.setControler();        
        new KontrolerBtnPrijavaIzmeni(this);
    }

    @Override
    public void setPanel() {
        super.setPanel(); 
            GridBagConstraints c =new GridBagConstraints();
            c.fill = GridBagConstraints.NONE;
            c.gridx = 0;
            c.gridy = 12;
            c.anchor = GridBagConstraints.WEST;
            c.insets = new Insets(2,2,2,2);
            unosForm.oef.add(btnPanel,c);    
    
    } 
}
