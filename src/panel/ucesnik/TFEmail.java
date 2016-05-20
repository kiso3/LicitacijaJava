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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import validator.ComponentValidator;
import validator.ucensik.ValidatorEmail;

/**
 *
 * @author Mladen
 */
public class TFEmail extends JPanel{
    
    private JLabel lblEmail;
    public JTextField txtEmail;
    private ComponentValidator validator;
    
    public TFEmail() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelEmail();
        postaviTextEmail();
        postaviDogadjaZaValidaciju();
    }
    
    private void kreirajKomponente(){
        lblEmail = new JLabel("Email :");
        txtEmail = new JTextField();
        validator = new ValidatorEmail();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    private void postaviTextEmail(){
        txtEmail.setColumns(15);
        add(txtEmail);        
    }
    
    private void postaviLabelEmail(){  
        lblEmail.setMinimumSize(new Dimension(80, 10));
        lblEmail.setPreferredSize(new Dimension(80, 10));
        lblEmail.setMaximumSize(new Dimension(80, 10));
        add(lblEmail);        
    }
    
     private void postaviDogadjaZaValidaciju(){
        
        txtEmail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                try {
                    validator.validate(txtEmail.getText());
                    txtEmail.setBackground(Color.white);
                } catch (Exception ex) {
                    
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    validator.validate(txtEmail.getText());
                    txtEmail.setBackground(Color.white);
                } catch (Exception ex) {
                    txtEmail.setBackground(Color.red);
                    txtEmail.setToolTipText(ex.getMessage());
                }
            }
        });
    }
}
