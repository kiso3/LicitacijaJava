/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.ucesnik;

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
public class CBoxMesto extends JPanel{
    public JLabel lblMesto;
    public JComboBox cboxMesto;
                     
    public CBoxMesto() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();
        postaviLabelMesto();
        postaviCBoxMesto();        
    }
    
    private void kreirajKomponente(){
        lblMesto = new JLabel("Mesto ");
        cboxMesto =  new JComboBox();        
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    
    private void postaviLabelMesto(){ 
        lblMesto.setMinimumSize(new Dimension(80, 10));
        lblMesto.setPreferredSize(new Dimension(80, 10));
        lblMesto.setMaximumSize(new Dimension(80, 10));
        add(lblMesto);        
    }
    private void postaviCBoxMesto(){                      
        add(cboxMesto);        
    }
    

    
}
