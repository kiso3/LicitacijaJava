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
import kontroler.ucesnik.KontrolerBtnTableObrisi;
import panel.form.ucesnik.UcesnikTablePanelForm;
import panel.generic.BtnPanel;

/**
 *
 * @author Mladen
 */
public class BtnUcesnikTabeObrisi extends DecoratorForm {
    public BtnPanel btnPanel;

    public BtnUcesnikTabeObrisi(UnosForm unosForm) {
        super(unosForm);
        this.btnPanel = new BtnPanel("Obrisi");
    }

    @Override
    public void setControler() {
        super.setControler();         
            GridBagConstraints c =new GridBagConstraints();
            c.fill = GridBagConstraints.NONE;
            c.gridx = 2;
            c.gridy = 3;
            //c.anchor = GridBagConstraints.EAST;
            c.insets = new Insets(2,2,2,2);
            unosForm.oef.add(btnPanel, c);        
    }

    @Override
    public void setPanel() {
        super.setPanel(); 
        new KontrolerBtnTableObrisi(this);
    }
    
    
}
