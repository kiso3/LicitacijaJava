/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.form.ucesnik;

import panel.ucesnik.TFJmbg;
import panel.ucesnik.TFPrezime;
import panel.ucesnik.TFIme;
import panel.ucesnik.TFImeRoditelja;
import domen.OpstiDomenskiObjekat;
import domen.UcesnikFizicko;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.table.TableModel;
import konvertortipova.KonverterTipova;

/**
 *
 * @author Mladen
 */
public class UcesnikFizickoPanelForm extends UcesnikPanelForm{
        
    private TFJmbg tfJmbg;
    private TFIme tfIme;
    private TFImeRoditelja tfImeRoditelja;
    private TFPrezime tfPrezime;

    public UcesnikFizickoPanelForm(){
        super(new UcesnikFizicko());
        pokreniMenadzeraRasporedaKomponeti();
    }

    public TFJmbg getTfKmbg() {
        return tfJmbg;
    }

    public void setTfJmbg(TFJmbg tfJmbg) {
        this.tfJmbg = tfJmbg;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfJmbg,c);
    }
    
    public TFIme getTfIme() {
        return tfIme;
    }

    public void setTfIme(TFIme tfIme) {
        this.tfIme = tfIme;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfIme,c);
    }

    public TFImeRoditelja getTfImeRoditelja() {
        return tfImeRoditelja;
    }

    public void setTfImeRoditelja(TFImeRoditelja tfImeRoditelja) {
        this.tfImeRoditelja = tfImeRoditelja;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 4;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfImeRoditelja,c);
    }

    public TFPrezime getTfPrezime() {
        return tfPrezime;
    }

    public void setTfPrezime(TFPrezime tfPrezime) {
        this.tfPrezime = tfPrezime;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 5;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfPrezime,c);
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    
  
    
    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat(){
        super.KonvertujGrafickiObjekatUDomenskiObjekat();
        UcesnikFizicko uf = (UcesnikFizicko) odo;
        if (tfJmbg != null) uf.setJmbg(KonverterTipova.Konvertuj(tfJmbg.txtJmbg, uf.getJmbg()));
        if (tfIme != null) uf.setIme(KonverterTipova.Konvertuj(tfIme.txtIme, uf.getIme()));
        if (tfImeRoditelja != null) uf.setImeRoditelja(KonverterTipova.Konvertuj(tfImeRoditelja.txtImeRoditelja, uf.getImeRoditelja()));
        if (tfPrezime != null) uf.setPrezime(KonverterTipova.Konvertuj(tfPrezime.txtPrezime, uf.getPrezime()));
        
        
    }
    
    public void KonvertujDomenskiObjekatUGrafickiObjekat(){
        super.KonvertujDomenskiObjekatUGrafickiObjekat();
        UcesnikFizicko uf = (UcesnikFizicko) odo;
        if(tfJmbg != null) KonverterTipova.Konvertuj(uf.getJmbg(), tfJmbg.txtJmbg);
        if(tfIme != null) KonverterTipova.Konvertuj(uf.getIme(), tfIme.txtIme);
        if(tfImeRoditelja != null) KonverterTipova.Konvertuj(uf.getImeRoditelja(), tfImeRoditelja.txtImeRoditelja);
        if(tfPrezime != null) KonverterTipova.Konvertuj(uf.getPrezime(), tfPrezime.txtPrezime);
    
    }  
    
    public boolean isValidInput(){
        try {
            if(tfJmbg != null) tfJmbg.isValidInput();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
