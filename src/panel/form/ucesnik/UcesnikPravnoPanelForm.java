/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.form.ucesnik;

import domen.OpstiDomenskiObjekat;
import domen.UcesnikFizicko;
import domen.UcesnikPravno;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.table.TableModel;
import konvertortipova.KonverterTipova;
import panel.ucesnik.TFMb;
import panel.ucesnik.TFNaziv;
import panel.ucesnik.TFPib;

/**
 *
 * @author Mladen
 */
public class UcesnikPravnoPanelForm extends UcesnikPanelForm{
    
    private TFMb tfMb;
    private TFNaziv tfNaziv;
    private TFPib tfPib;

    public UcesnikPravnoPanelForm(){
        super(new UcesnikPravno());
        pokreniMenadzeraRasporedaKomponeti();
    }
    
    public TFMb getTfMb() {
        return tfMb;
    }

    public void setTfMb(TFMb tfMb) {
        this.tfMb = tfMb;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfMb, c);
    }

    public TFNaziv getTfNaziv() {
        return tfNaziv;
    }

    public void setTfNaziv(TFNaziv tfNaziv) {
        this.tfNaziv = tfNaziv;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfNaziv, c);
    }

    public TFPib getTfPib() {
        return tfPib;
    }

    public void setTfPib(TFPib tfPib) {
        this.tfPib = tfPib;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 4;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfPib, c);
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
    }
  
    
    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat(){
        super.KonvertujGrafickiObjekatUDomenskiObjekat();
        UcesnikPravno up = (UcesnikPravno) odo;
        if (tfMb != null) up.setMb(KonverterTipova.Konvertuj(tfMb.txtMb, up.getMb()));
        if (tfNaziv != null) up.setNaziv(KonverterTipova.Konvertuj(tfNaziv.txtNaziv, up.getNaziv()));
        if (tfPib != null) up.setPib(KonverterTipova.Konvertuj(tfPib.txtPib, up.getPib()));
        
        
        
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
        super.KonvertujDomenskiObjekatUGrafickiObjekat();
        UcesnikPravno up = (UcesnikPravno) odo;
        if(tfMb != null) KonverterTipova.Konvertuj(up.getMb(), tfMb.txtMb);
        if(tfNaziv != null) KonverterTipova.Konvertuj(up.getNaziv(), tfNaziv.txtNaziv);
        if(tfPib != null) KonverterTipova.Konvertuj(up.getPib(), tfPib.txtPib);
    }

    @Override
    public boolean isValidInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
