/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import panel.form.oef.OpstaEkranskaForma;

/**
 *
 * @author Mladen
 */
public interface BuilderForm {//Builder
    
    void KreirajFormu();
    
    OpstaEkranskaForma vratiRezultat();
    
}
