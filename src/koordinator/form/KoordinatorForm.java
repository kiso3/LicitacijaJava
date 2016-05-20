/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koordinator.form;

import MainForm.MainForm;
import panel.form.oef.OpstaEkranskaForma;

/**
 *
 * @author Mladen
 */
public class KoordinatorForm {
    MainForm mainForm;   
    private static KoordinatorForm koordinatorForm;

    private KoordinatorForm() {
        mainForm = new MainForm();        
    }
    
    public static KoordinatorForm instance(){
        if(koordinatorForm == null){
            koordinatorForm = new KoordinatorForm();
        }
        return koordinatorForm;
    }
    
    
    public void postaviFormu(OpstaEkranskaForma oef){
        mainForm.posaviAktivanPanel(oef);
        pack();
    }
    
    public OpstaEkranskaForma vratiAktivnuFormu(){
        return mainForm.vratiAktivnuFormu();
    }   
    
    public void pack(){
        mainForm.pack();
    }
    
}
