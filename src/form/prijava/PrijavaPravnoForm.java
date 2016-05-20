/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.prijava;

import form.ucesnik.UcesnikFizickoForm;
import form.ucesnik.UcesnikPravnoForm;
import panel.form.prijava.PrijavaFizickoPanelForm;
import panel.form.prijava.PrijavaPravnoPanelForm;
import panel.form.ucesnik.UcesnikFizickoPanelForm;
import panel.form.ucesnik.UcesnikPravnoPanelForm;
import panel.prijava.CBoxDikazOVlasnistvu;
import panel.prijava.CBoxIzvodIzPrivrednogRegistra;
import panel.prijava.CBoxLicnaKarta;

/**
 *
 * @author Mladen
 */
public class PrijavaPravnoForm extends PrijavaForm{
    PrijavaPravnoPanelForm prijavaPravnoPanelForm;        
    
    public PrijavaPravnoForm(PrijavaPravnoPanelForm prijavaPravnoPanelForm){
        super(prijavaPravnoPanelForm);
        this.prijavaPravnoPanelForm = prijavaPravnoPanelForm;
    }
    
     @Override
     public void setPanel() {
        super.setPanel();
        UcesnikPravnoPanelForm uppf = new UcesnikPravnoPanelForm();
        UcesnikPravnoForm upf = new UcesnikPravnoForm(uppf);
        upf.setPanel();
        upf.setControler();
        
        uppf.getCboxMesto().cboxMesto.setEditable(false);
        uppf.getTfAdresa().txtAdresa.setEditable(false);
        uppf.getTfEmail().txtEmail.setEditable(false);
        uppf.getTfTelefon().txtTelefon.setEditable(false);        
        uppf.getTfMb().txtMb.setEditable(false);
        uppf.getTfNaziv().txtNaziv.setEditable(false);
        uppf.getTfPib().txtPib.setEditable(false);        
        uppf.getRbtnUcenik().rbtnUcenikFizicko.setEnabled(false);
        uppf.getRbtnUcenik().rbtnUcenikPravn.setEnabled(false);
        
        
        prijavaPravnoPanelForm.setUcesnikPanelForm(uppf);
        prijavaPravnoPanelForm.setcBoxIzvodIzPrivrednogRegistra(new CBoxIzvodIzPrivrednogRegistra());        
     }
}
