/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.oglas;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mladen
 */
public class TFOglasId extends JPanel{
    
    private JLabel lblOglasId;
    public JTextField txtOglasId;

    public TFOglasId() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelOglasId();        
        postaviTextOglasId();
    }
    
    private void kreirajKomponente(){
        lblOglasId = new JLabel("Oglas ID:");
        txtOglasId = new JTextField();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
    }
    private void postaviTextOglasId(){        
        txtOglasId.setEditable(false);
        txtOglasId.setColumns(15);
        add(txtOglasId);        
    }
    
    private void postaviLabelOglasId(){
        lblOglasId.setMinimumSize(new Dimension(120, 15));
        lblOglasId.setPreferredSize(new Dimension(120, 15));
        lblOglasId.setMaximumSize(new Dimension(120, 15));        
        add(lblOglasId);        
    }
}
