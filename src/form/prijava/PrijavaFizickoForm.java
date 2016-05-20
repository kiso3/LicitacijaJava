/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.prijava;

import form.ucesnik.UcesnikFizickoForm;
import panel.form.prijava.PrijavaFizickoPanelForm;
import panel.form.prijava.PrijavaPanelForm;
import panel.form.ucesnik.UcesnikFizickoPanelForm;
import panel.prijava.CBoxDikazOVlasnistvu;
import panel.prijava.CBoxDokazOGranicnomZemljistu;
import panel.prijava.CBoxLicnaKarta;

/**
 *
 * @author Mladen
 */
public class PrijavaFizickoForm extends PrijavaForm{
    PrijavaFizickoPanelForm prijavaFizickoPanelForm;        
    
    public PrijavaFizickoForm(PrijavaFizickoPanelForm prijavaFizickoPanelForm){
        super(prijavaFizickoPanelForm);
        this.prijavaFizickoPanelForm = prijavaFizickoPanelForm;
    }
    
     @Override
     public void setPanel() {
        super.setPanel();
        UcesnikFizickoPanelForm ufpf = new UcesnikFizickoPanelForm();
        UcesnikFizickoForm uff = new UcesnikFizickoForm(ufpf);
        uff.setPanel();
        uff.setControler();
        
        ufpf.getCboxMesto().cboxMesto.setEditable(false);
        ufpf.getTfAdresa().txtAdresa.setEditable(false);
        ufpf.getTfEmail().txtEmail.setEditable(false);
        ufpf.getTfTelefon().txtTelefon.setEditable(false);        
        ufpf.getTfIme().txtIme.setEditable(false);
        ufpf.getTfImeRoditelja().txtImeRoditelja.setEditable(false);
        ufpf.getTfPrezime().txtPrezime.setEditable(false);
        ufpf.getTfKmbg().txtJmbg.setEditable(false);
        ufpf.getRbtnUcenik().rbtnUcenikFizicko.setEnabled(false);
        ufpf.getRbtnUcenik().rbtnUcenikPravn.setEnabled(false);
        
        
        prijavaFizickoPanelForm.setUcesnikPanelForm(ufpf);
        prijavaFizickoPanelForm.setcBoxDokazOGranicnomZemljistu(new CBoxDokazOGranicnomZemljistu());
        prijavaFizickoPanelForm.setcBoxLicnaKarta(new CBoxLicnaKarta());

     }
}
