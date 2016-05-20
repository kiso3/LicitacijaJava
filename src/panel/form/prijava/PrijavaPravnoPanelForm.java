/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.form.prijava;

import domen.PrijavaPravno;
import domen.UcesnikPravno;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import konvertortipova.KonverterTipova;
import panel.prijava.CBoxIzvodIzPrivrednogRegistra;

/**
 *
 * @author Mladen
 */
public class PrijavaPravnoPanelForm extends PrijavaPanelForm  {

    private CBoxIzvodIzPrivrednogRegistra cBoxIzvodIzPrivrednogRegistra;

    public CBoxIzvodIzPrivrednogRegistra getcBoxIzvodIzPrivrednogRegistra() {
        return cBoxIzvodIzPrivrednogRegistra;
    }

    public void setcBoxIzvodIzPrivrednogRegistra(CBoxIzvodIzPrivrednogRegistra cBoxIzvodIzPrivrednogRegistra) {
        this.cBoxIzvodIzPrivrednogRegistra = cBoxIzvodIzPrivrednogRegistra;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 9;        
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.cBoxIzvodIzPrivrednogRegistra,c);
    }
    
    
    
    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        super.KonvertujGrafickiObjekatUDomenskiObjekat();
        PrijavaPravno pp = (PrijavaPravno) getOdo();
        
        if(getUcesnikPanelForm() != null){
        getUcesnikPanelForm().KonvertujGrafickiObjekatUDomenskiObjekat();
            pp.setUcesnikPravno((UcesnikPravno) getUcesnikPanelForm().getOdo());
        }
        
        if(cBoxIzvodIzPrivrednogRegistra != null) pp.setIzvodIzPrivrednogRegistra(
                KonverterTipova.Konvertuj(
                        cBoxIzvodIzPrivrednogRegistra.jCheckBox
                        ,pp.isIzvodIzPrivrednogRegistra())
                        );
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
         super.KonvertujDomenskiObjekatUGrafickiObjekat();
         
         PrijavaPravno pp = (PrijavaPravno) getOdo();
         if(getUcesnikPanelForm() != null){
             getUcesnikPanelForm().setOdo(pp.getUcesnikPravno());
             getUcesnikPanelForm().KonvertujDomenskiObjekatUGrafickiObjekat();
         }
         
         if(cBoxIzvodIzPrivrednogRegistra != null) KonverterTipova.Konvertuj(
                 pp.isIzvodIzPrivrednogRegistra()
                 ,cBoxIzvodIzPrivrednogRegistra.jCheckBox
         );
    }

    @Override
    public boolean isValidInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
