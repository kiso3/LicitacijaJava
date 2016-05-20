/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.generic;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mladen
 */
public class LblTxtFeald extends JPanel{
    public JLabel label;
    public JTextField textField;

    public JLabel getLbl() {
        return label;
    }

    public LblTxtFeald(String labelTitle, int txtColumn, boolean txtIsEditable) {
        kreirajKomponente(labelTitle);
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabel();
        postaviText(txtColumn, txtIsEditable);
    }
    
    private void kreirajKomponente(String labelTitle){
        label = new JLabel(labelTitle);
        textField = new JTextField();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
    }
    private void postaviText(int txtColumn, boolean txtIsEditable){ 
        if(txtColumn >= 0) textField.setColumns(txtColumn);        
        //txtUcesnikId.setSize(50, 30);
        textField.setEditable(txtIsEditable);
        add(textField);        
    }
    
    private void postaviLabel(){        
        add(label);        
    }
       
}