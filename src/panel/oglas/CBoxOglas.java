/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.oglas;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mladen
 */
public class CBoxOglas extends JPanel{
    public JLabel lblOglas;
    public JComboBox cboxOglas;
    
    public CBoxOglas() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();
        postaviLabelMesto();
        postaviCBoxMesto();        
    }
    
    private void kreirajKomponente(){
        lblOglas = new JLabel("Oglas za godinu ");
        cboxOglas =  new JComboBox();        
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    
    private void postaviLabelMesto(){ 
        lblOglas.setMinimumSize(new Dimension(120, 15));
        lblOglas.setPreferredSize(new Dimension(120, 15));
        lblOglas.setMaximumSize(new Dimension(120, 15));
        add(lblOglas);        
    }
    private void postaviCBoxMesto(){  
        cboxOglas.setMinimumSize(new Dimension(100, 15));
        add(cboxOglas);        
    }        
    
}
