/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.ucesnik;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import validator.ComponentValidator;
import validator.ucensik.ValidatorJmbg;

/**
 *
 * @author Mladen
 */
public class TFJmbg extends JPanel{
    private JLabel lblJmbg;
    public JTextField txtJmbg;
    private ComponentValidator validator;
    
    public TFJmbg() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelJmbg();
        postaviTextJmbg();
        postaviDogadjaZaValidaciju();
    }
    
    private void kreirajKomponente(){
        lblJmbg = new JLabel("JMBG:");
        txtJmbg = new JTextField();
        validator = new ValidatorJmbg();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
   
    private void postaviTextJmbg(){
        txtJmbg.setColumns(13);
        add(txtJmbg);        
    }
    
    private void postaviLabelJmbg(){   
        lblJmbg.setMinimumSize(new Dimension(80, 10));
        lblJmbg.setPreferredSize(new Dimension(80, 10));
        lblJmbg.setMaximumSize(new Dimension(80, 10));
        add(lblJmbg);    
        
    }
    
    public void isValidInput() throws Exception {        
        try {
            validator.validate(txtJmbg.getText());   
            txtJmbg.setBackground(Color.white);
        } catch (Exception e) {
            
            txtJmbg.setBackground(Color.red);
            txtJmbg.setToolTipText(e.toString());
          
            throw new Exception(e);
        }                
        
    }    
    
    private void postaviDogadjaZaValidaciju(){
        
        txtJmbg.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                try {
                    validator.validate(txtJmbg.getText());
                    txtJmbg.setBackground(Color.white);
                } catch (Exception ex) {
                    
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    validator.validate(txtJmbg.getText());
                    txtJmbg.setBackground(Color.white);
                } catch (Exception ex) {
                    txtJmbg.setBackground(Color.red);
                    txtJmbg.setToolTipText(ex.getMessage());
                }
            }
        });
    }
}


