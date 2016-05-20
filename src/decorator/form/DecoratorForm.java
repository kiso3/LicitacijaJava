/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator.form;

/**
 *
 * @author Mladen
 */
public class DecoratorForm extends UnosForm{ //Decoratore

    protected UnosForm unosForm;
    
    public DecoratorForm(UnosForm unosForm) {
        super(unosForm.oef);
        
        this.unosForm = unosForm;
    }

    @Override
    public void setPanel() {
        this.unosForm.setPanel();
    }

    @Override
    public void setControler() {
        this.unosForm.setControler();
    }
    
}
