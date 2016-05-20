/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator.form;

import panel.form.oef.OpstaEkranskaForma;

/**
 *
 * @author Mladen
 */
public abstract class UnosForm { //Component
    
    public OpstaEkranskaForma oef;

    public UnosForm(OpstaEkranskaForma oef) {
        this.oef = oef;
    }
    
    public abstract void setPanel();
    
    public abstract void setControler(); 
    
}
