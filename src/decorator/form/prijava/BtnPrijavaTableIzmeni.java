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
import kontroler.prijava.KontrolerBtnPrijavaTableIzmeni;
import panel.generic.BtnPanel;

/**
 *
 * @author Mladen
 */
public class BtnPrijavaTableIzmeni extends DecoratorForm {
    public BtnPanel btnPanel;
    
    public BtnPrijavaTableIzmeni(UnosForm unosForm) {
        super(unosForm);
        this.btnPanel = new BtnPanel("Izmeni");
    }

    @Override
    public void setControler() {
        super.setControler();        
        new KontrolerBtnPrijavaTableIzmeni(this);
    }

    @Override
    public void setPanel() {
        super.setPanel(); 
            GridBagConstraints c =new GridBagConstraints();
            c.fill = GridBagConstraints.NONE;
            c.gridx = 1;
            c.gridy = 6;
            c.anchor = GridBagConstraints.WEST;
            c.insets = new Insets(2,2,2,2);
            unosForm.oef.add(btnPanel,c);    
    
    } 
}
