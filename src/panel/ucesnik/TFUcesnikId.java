/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.ucesnik;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mladen
 */
public class TFUcesnikId extends JPanel{
    public JLabel lblUcesnikId;
    public JTextField txtUcesnikId;
    
    
    public TFUcesnikId() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelUcesnikId();
        postaviTextUcesnikId();
    }
    
    private void kreirajKomponente(){
        lblUcesnikId = new JLabel("Ucesnik ID:");
        txtUcesnikId = new JTextField();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    private void postaviTextUcesnikId(){ 
        txtUcesnikId.setColumns(4);        
        txtUcesnikId.setEditable(false);
        add(txtUcesnikId);        
    }
    
    private void postaviLabelUcesnikId(){    
        lblUcesnikId.setMinimumSize(new Dimension(80, 10));
        lblUcesnikId.setPreferredSize(new Dimension(80, 10));
        lblUcesnikId.setMaximumSize(new Dimension(80, 10));  
        add(lblUcesnikId);        
    }
}
