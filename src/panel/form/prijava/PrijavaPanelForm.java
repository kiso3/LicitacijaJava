/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.form.prijava;

import domen.Prijava;
import domen.Ucesnik;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import konvertortipova.KonverterTipova;
import panel.form.oef.OpstaEkranskaForma;
import panel.form.ucesnik.UcesnikPanelForm;
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
public abstract class PrijavaPanelForm extends OpstaEkranskaForma {
    
    private UcesnikPanelForm ucesnikPanelForm;
    private TFPrijavaId tfPrijavaId;
    private DateDatumPodnosenja dateDatumPodnosenja;
    private CBoxUpoznatSaPonudm cBoxUpoznatSaPonudm;
    private DateDatumObilaska dateDatumObilaska;
    private CBoxDokazOUplatiDepozita cBoxDokazOUplatiDepozita;
    private CBoxDikazOVlasnistvu cBoxDikazOVlasnistvu;
    private CBoxRegPoljGazd cBoxRegPoljGazd;
    
    public PrijavaPanelForm(){
        pokreniMenadzeraRasporedaKomponeti();        
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
 
    }

    public UcesnikPanelForm getUcesnikPanelForm() {
        return ucesnikPanelForm;
    }

    public void setUcesnikPanelForm(UcesnikPanelForm ucesnikPanelForm) {
        this.ucesnikPanelForm = ucesnikPanelForm;        
        this.ucesnikPanelForm.getCboxMesto().cboxMesto.setEditable(false);               
        this.ucesnikPanelForm.getCboxMesto().cboxMesto.setEditable(false);
        this.ucesnikPanelForm.getCboxMesto().cboxMesto.setEditable(false);
        
        
        
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;        
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.ucesnikPanelForm,c);
        
    }   
    
    public TFPrijavaId getTfPrijavaId() {
        return tfPrijavaId;
    }

    public void setTfPrijavaId(TFPrijavaId tfPrijavaId) {
        this.tfPrijavaId = tfPrijavaId;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 4;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfPrijavaId,c);
    }

    public DateDatumPodnosenja getDateDatumPodnosenja() {
        return dateDatumPodnosenja;
    }

    public void setDateDatumPodnosenja(DateDatumPodnosenja dateDatumPodnosenja) {
        this.dateDatumPodnosenja = dateDatumPodnosenja;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 4;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.dateDatumPodnosenja,c);
    }

    public CBoxUpoznatSaPonudm getcBoxUpoznatSaPonudm() {
        return cBoxUpoznatSaPonudm;
    }

    public void setcBoxUpoznatSaPonudm(CBoxUpoznatSaPonudm cBoxUpoznatSaPonudm) {
        this.cBoxUpoznatSaPonudm = cBoxUpoznatSaPonudm;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 5;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.cBoxUpoznatSaPonudm,c);
    }

    public DateDatumObilaska getDateDatumObilaska() {
        return dateDatumObilaska;
    }

    public void setDateDatumObilaska(DateDatumObilaska dateDatumObilaska) {
        this.dateDatumObilaska = dateDatumObilaska;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 5;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.dateDatumObilaska,c);
    }

    public CBoxDokazOUplatiDepozita getcBoxDokazOUplatiDepozita() {
        return cBoxDokazOUplatiDepozita;
    }

    public void setcBoxDokazOUplatiDepozita(CBoxDokazOUplatiDepozita cBoxDokazOUplatiDepozita) {
        this.cBoxDokazOUplatiDepozita = cBoxDokazOUplatiDepozita;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 6;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.cBoxDokazOUplatiDepozita,c);
    }

    public CBoxDikazOVlasnistvu getcBoxDikazOVlasnistvu() {
        return cBoxDikazOVlasnistvu;
    }

    public void setcBoxDikazOVlasnistvu(CBoxDikazOVlasnistvu cBoxDikazOVlasnistvu) {
        this.cBoxDikazOVlasnistvu = cBoxDikazOVlasnistvu;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 7;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.cBoxDikazOVlasnistvu,c);
    }

    public CBoxRegPoljGazd getcBoxRegPoljGazd() {
        return cBoxRegPoljGazd;
    }

    public void setcBoxRegPoljGazd(CBoxRegPoljGazd cBoxRegPoljGazd) {
        this.cBoxRegPoljGazd = cBoxRegPoljGazd;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 8;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.cBoxRegPoljGazd,c);
        
    }
    
    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        Prijava p = (Prijava) getOdo();       
        if(tfPrijavaId != null) p.setPrijavaId(KonverterTipova.Konvertuj(tfPrijavaId.txtPrijavaId, p.getPrijavaId()));
        if(dateDatumPodnosenja != null) p.setDatumPodnosenja(KonverterTipova.Konvertuj(dateDatumPodnosenja.model, p.getDatumPodnosenja()));
        if(cBoxUpoznatSaPonudm != null) p.setUpoznatSaPonudom(KonverterTipova.Konvertuj(cBoxUpoznatSaPonudm.jCheckBox, p.isUpoznatSaPonudom())) ;
        if(dateDatumObilaska != null) p.setDatumObilaska(KonverterTipova.Konvertuj(dateDatumObilaska.model, p.getDatumObilaska()));
        if(cBoxDokazOUplatiDepozita != null) p.setDokazoUplatiDepozita(KonverterTipova.Konvertuj(cBoxDokazOUplatiDepozita.jCheckBox, p.isDokazoUplatiDepozita()));
        if(cBoxDikazOVlasnistvu != null) p.setDokazoVlasnistvu(KonverterTipova.Konvertuj(cBoxDikazOVlasnistvu.jCheckBox, p.isDokazoVlasnistvu()));
        if(cBoxRegPoljGazd != null) p.setRegPoljGazdinstva(KonverterTipova.Konvertuj(cBoxRegPoljGazd.jCheckBox, p.isRegPoljGazdinstva()));
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {    
        Prijava p = (Prijava) getOdo();       
        if(tfPrijavaId != null) KonverterTipova.Konvertuj( p.getPrijavaId(),tfPrijavaId.txtPrijavaId);
        if(dateDatumPodnosenja != null) KonverterTipova.Konvertuj( p.getDatumPodnosenja(), dateDatumPodnosenja.model);
        if(cBoxUpoznatSaPonudm != null) KonverterTipova.Konvertuj( p.isUpoznatSaPonudom(), cBoxUpoznatSaPonudm.jCheckBox) ;
        if(dateDatumObilaska != null) KonverterTipova.Konvertuj( p.getDatumObilaska(), dateDatumObilaska.model);
        if(cBoxDokazOUplatiDepozita != null) KonverterTipova.Konvertuj( p.isDokazoUplatiDepozita(),cBoxDokazOUplatiDepozita.jCheckBox);
        if(cBoxDikazOVlasnistvu != null) KonverterTipova.Konvertuj( p.isDokazoVlasnistvu(), cBoxDikazOVlasnistvu.jCheckBox);
        if(cBoxRegPoljGazd != null) KonverterTipova.Konvertuj( p.isRegPoljGazdinstva(), cBoxRegPoljGazd.jCheckBox);
    }
    
}
