/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.form.ucesnik;

import panel.ucesnik.TFAdresa;
import panel.ucesnik.RBtnUcesnik;
import panel.ucesnik.CBoxMesto;
import panel.ucesnik.TFUcesnikId;
import panel.ucesnik.TFEmail;
import panel.ucesnik.TFTelefon;
import panel.form.oef.OpstaEkranskaForma;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Ucesnik;
import domen.UcesnikFizicko;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.table.TableModel;
import konvertortipova.KonverterTipova;


/**
 *
 * @author Mladen
 */
public abstract class UcesnikPanelForm extends OpstaEkranskaForma{

    private TFUcesnikId tfUcesnikId;
    private TFEmail tfEmail;
    private TFAdresa tfAdresa;
    private TFTelefon tfTelefon;
    private CBoxMesto cboxMesto;
    private RBtnUcesnik rbtnUcenik;


    
    public UcesnikPanelForm(Ucesnik ucesnik){
        pokreniMenadzeraRasporedaKomponeti();
        this.odo = ucesnik;
    }
    
    public RBtnUcesnik getRbtnUcenik() {
        return rbtnUcenik;
    }

    public void setRbtnUcenik(RBtnUcesnik rbtnUcenik) {
        this.rbtnUcenik = rbtnUcenik;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.rbtnUcenik,c);
        
    }
    
    public TFUcesnikId getTfUcesnikId() {
        return tfUcesnikId;
    }

    public void setTfUcesnikId(TFUcesnikId tfUcesnikId) {
        this.tfUcesnikId = tfUcesnikId;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfUcesnikId,c);
    } 
    
    public CBoxMesto getCboxMesto() {
        return cboxMesto;        
    }

    public void setCboxMesto(CBoxMesto cboxMesto) {
        this.cboxMesto = cboxMesto;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.cboxMesto,c);
    }
    
    public TFEmail getTfEmail() {
        return tfEmail;
    }

    public void setTfEmail(TFEmail tfEmail) {
        this.tfEmail = tfEmail;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfEmail,c);
    }

    public TFAdresa getTfAdresa() {
        return tfAdresa;
    }

    public void setTfAdresa(TFAdresa tfAdresa) {
        this.tfAdresa = tfAdresa;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 3;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfAdresa,c);
    }

    public TFTelefon getTfTelefon() {
        return tfTelefon;
    }

    public void setTfTelefon(TFTelefon tfTelefon) {
        this.tfTelefon = tfTelefon;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 4;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfTelefon,c);
    }




    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
 
    }
   

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        Ucesnik ucesnik = (Ucesnik) odo;
        if (tfUcesnikId != null) ucesnik.setUcesnikId(KonverterTipova.Konvertuj(tfUcesnikId.txtUcesnikId, ucesnik.getUcesnikId()));
        if (tfAdresa != null) ucesnik.setAdresa(KonverterTipova.Konvertuj(tfAdresa.txtAdresa, ucesnik.getAdresa()));
        if (tfEmail != null) ucesnik.setEmail(KonverterTipova.Konvertuj(tfEmail.txtEmail, ucesnik.getEmail()));
        if (tfTelefon != null) ucesnik.setTelefon(KonverterTipova.Konvertuj(tfTelefon.txtTelefon, ucesnik.getTelefon()));
        if (cboxMesto != null) ucesnik.setMesto((Mesto) KonverterTipova.Konvertuj(cboxMesto.cboxMesto));
    }
    
        
    
    public void KonvertujDomenskiObjekatUGrafickiObjekat(){
        Ucesnik ucesnik = (Ucesnik) odo;
        if (tfUcesnikId != null) KonverterTipova.Konvertuj(ucesnik.getUcesnikId(),tfUcesnikId.txtUcesnikId);
        if (tfAdresa != null) KonverterTipova.Konvertuj(ucesnik.getAdresa(), tfAdresa.txtAdresa);
        if (tfEmail != null) KonverterTipova.Konvertuj(ucesnik.getEmail(),tfEmail.txtEmail);
        if (tfTelefon != null) KonverterTipova.Konvertuj(ucesnik.getTelefon(), tfTelefon.txtTelefon);
        if (cboxMesto != null) KonverterTipova.Konvertuj(ucesnik.getMesto(), cboxMesto.cboxMesto);
    }

    @Override
    public abstract boolean isValidInput();
    
    
}
