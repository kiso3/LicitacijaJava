/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.oglas;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mladen
 */
public class TFNazivOpstine extends JPanel{
    private JLabel lblNazivOpstine;
    public JTextField txtNazivOpstine;

    public TFNazivOpstine() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelOglasId();        
        postaviTextOglasId();
    }
    
    private void kreirajKomponente(){
        lblNazivOpstine = new JLabel("Opština:");
        txtNazivOpstine = new JTextField();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
    }
    private void postaviTextOglasId(){        
        txtNazivOpstine.setEditable(false);
        txtNazivOpstine.setColumns(15);
        add(txtNazivOpstine);        
    }
    
    private void postaviLabelOglasId(){  
        lblNazivOpstine.setMinimumSize(new Dimension(140, 15));
        lblNazivOpstine.setPreferredSize(new Dimension(140, 15));
        lblNazivOpstine.setMaximumSize(new Dimension(140, 15));
        add(lblNazivOpstine);        
    }
}
