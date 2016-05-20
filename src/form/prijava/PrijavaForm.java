/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.prijava;

import decorator.form.UnosForm;
import panel.form.prijava.PrijavaPanelForm;
import panel.prijava.CBoxDikazOVlasnistvu;
import panel.prijava.CBoxDokazOUplatiDepozita;
import panel.prijava.CBoxRegPoljGazd;
import panel.prijava.CBoxUpoznatSaPonudm;
import panel.prijava.DateDatumObilaska;
import panel.prijava.DateDatumPodnosenja;
import panel.prijava.TFPrijavaId;

/**
 *
 * @author Mladen
 */
public abstract class PrijavaForm  extends UnosForm{ //ConcreateComponent
      
    private PrijavaPanelForm prijavaPanelForm;

    public PrijavaForm(PrijavaPanelForm prijavaPanelForm) {
        super(prijavaPanelForm);
        
        this.prijavaPanelForm = prijavaPanelForm;
    }
    
    @Override
     public void setPanel() {
         
         
        prijavaPanelForm.setTfPrijavaId(new TFPrijavaId());
        prijavaPanelForm.setDateDatumPodnosenja(new DateDatumPodnosenja());
        prijavaPanelForm.setcBoxUpoznatSaPonudm(new CBoxUpoznatSaPonudm());
        prijavaPanelForm.setDateDatumObilaska(new DateDatumObilaska());
        prijavaPanelForm.setcBoxDikazOVlasnistvu(new CBoxDikazOVlasnistvu());
        prijavaPanelForm.setcBoxDokazOUplatiDepozita(new CBoxDokazOUplatiDepozita());
        prijavaPanelForm.setcBoxRegPoljGazd(new CBoxRegPoljGazd());
    }

    @Override
    public void setControler() {
       
        
    }
}
