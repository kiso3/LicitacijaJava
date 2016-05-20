/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.nadmetanje;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mladen
 */
public class TFDepozit extends JPanel{
    private JLabel lblDepozit;
    public JTextField txtDepozit;

    public TFDepozit() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelOglasId();        
        postaviTextOglasId();
    }
    
    private void kreirajKomponente(){
        lblDepozit = new JLabel("Depozit ");
        txtDepozit = new JTextField();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
    }
    private void postaviTextOglasId(){        
        txtDepozit.setEditable(false);
        txtDepozit.setColumns(15);
        add(txtDepozit);        
    }
    
    private void postaviLabelOglasId(){  
        lblDepozit.setMinimumSize(new Dimension(140, 15));
        lblDepozit.setPreferredSize(new Dimension(140, 15));
        lblDepozit.setMaximumSize(new Dimension(140, 15));
        add(lblDepozit);        
    }   
}
