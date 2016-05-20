/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.prijava;

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
public class TFPrijavaId extends JPanel {
    public JLabel lblPrijavaId;
    public JTextField txtPrijavaId;
    
    
    public TFPrijavaId() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelUcesnikId();
        postaviTextUcesnikId();
    }
    
    private void kreirajKomponente(){
        lblPrijavaId = new JLabel("Prijava ID");
        txtPrijavaId = new JTextField();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    private void postaviTextUcesnikId(){ 
        txtPrijavaId.setColumns(4);        
        txtPrijavaId.setEditable(false);
        add(txtPrijavaId);        
    }
    
    private void postaviLabelUcesnikId(){    
        lblPrijavaId.setMinimumSize(new Dimension(80, 10));
        lblPrijavaId.setPreferredSize(new Dimension(80, 10));
        lblPrijavaId.setMaximumSize(new Dimension(80, 10));  
        add(lblPrijavaId);        
    }
}
