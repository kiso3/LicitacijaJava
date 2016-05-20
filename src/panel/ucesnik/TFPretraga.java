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
public class TFPretraga extends JPanel{
    private JLabel lblPretraga;
    public JTextField txtPretraga;
    
     
    public TFPretraga() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelIme();
        postaviTextIme();
        
    }
    
    private void kreirajKomponente(){
        lblPretraga = new JLabel("");
        txtPretraga = new JTextField();
        
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    private void postaviTextIme(){
        txtPretraga.setColumns(30);
        add(txtPretraga);        
    }
    
    private void postaviLabelIme(){ 
        lblPretraga.setMinimumSize(new Dimension(80, 10));
        lblPretraga.setPreferredSize(new Dimension(80, 10));
        lblPretraga.setMaximumSize(new Dimension(80, 10));
        //add(lblPretraga);        
    }
}