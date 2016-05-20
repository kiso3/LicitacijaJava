/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.form.prijava;

import domen.PrijavaFizicko;
import domen.UcesnikFizicko;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import konvertortipova.KonverterTipova;
import panel.prijava.CBoxDikazOVlasnistvu;
import panel.prijava.CBoxDokazOGranicnomZemljistu;
import panel.prijava.CBoxLicnaKarta;

/**
 *
 * @author Mladen
 */
public class PrijavaFizickoPanelForm extends PrijavaPanelForm {

    private CBoxLicnaKarta cBoxLicnaKarta;
    private CBoxDokazOGranicnomZemljistu cBoxDokazOGranicnomZemljistu;

    public CBoxLicnaKarta getcBoxLicnaKarta() {
        return cBoxLicnaKarta;
    }

    public void setcBoxLicnaKarta(CBoxLicnaKarta cBoxLicnaKarta) {
        this.cBoxLicnaKarta = cBoxLicnaKarta;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 9;        
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.cBoxLicnaKarta,c);
    }

    public CBoxDokazOGranicnomZemljistu getcBoxDokazOGranicnomZemljistu() {
        return cBoxDokazOGranicnomZemljistu;
    }

    public void setcBoxDokazOGranicnomZemljistu(CBoxDokazOGranicnomZemljistu cBoxDokazOGranicnomZemljistu) {
        this.cBoxDokazOGranicnomZemljistu = cBoxDokazOGranicnomZemljistu;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 10;        
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.cBoxDokazOGranicnomZemljistu,c);
    }
    
    
    
    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        super.KonvertujGrafickiObjekatUDomenskiObjekat();
        PrijavaFizicko pf = (PrijavaFizicko) getOdo();
                 
        if(getUcesnikPanelForm() != null) {            
            getUcesnikPanelForm().KonvertujGrafickiObjekatUDomenskiObjekat();
            pf.setPonudjacFizicko((UcesnikFizicko) getUcesnikPanelForm().getOdo());
        }    
        
        if(cBoxLicnaKarta != null)  pf.setLicnaKarta(KonverterTipova.Konvertuj(cBoxLicnaKarta.jCheckBox, pf.isLicnaKarta()));
        if(cBoxDokazOGranicnomZemljistu != null) pf.setDokazoGranicnomZemljistu(KonverterTipova.Konvertuj( cBoxDokazOGranicnomZemljistu.jCheckBox, pf.isDokazoGranicnomZemljistu()));
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
        super.KonvertujDomenskiObjekatUGrafickiObjekat();
    
        PrijavaFizicko pf = (PrijavaFizicko) getOdo();
        if(getUcesnikPanelForm() != null) {
            getUcesnikPanelForm().setOdo(pf.getPonudjacFizicko()); 
            getUcesnikPanelForm().KonvertujDomenskiObjekatUGrafickiObjekat();
        }    
        if(cBoxLicnaKarta != null) KonverterTipova.Konvertuj( 
                pf.isLicnaKarta(), cBoxLicnaKarta.jCheckBox
        );
        if(cBoxDokazOGranicnomZemljistu != null) KonverterTipova.Konvertuj( 
                pf.isDokazoGranicnomZemljistu()
                ,cBoxDokazOGranicnomZemljistu.jCheckBox
        );
    }

    @Override
    public boolean isValidInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
