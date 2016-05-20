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
import validator.ucensik.ValidatorAdresa;
import validator.ucensik.ValidatorJmbg;

/**
 *
 * @author Mladen
 */
public class TFAdresa extends JPanel{
            
    private JLabel lblAdresa;
    public JTextField txtAdresa;
    private ComponentValidator validator;
    
    public TFAdresa() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelAdresa();
        postaviTextAdresa();
        postaviDogadjaZaValidaciju();
    }
    
    private void kreirajKomponente(){
        lblAdresa = new JLabel("Adresa :");
        txtAdresa = new JTextField();
        validator = new ValidatorAdresa();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    private void postaviTextAdresa(){ 
        txtAdresa.setColumns(20);
        add(txtAdresa);        
    }
    
    private void postaviLabelAdresa(){                
        lblAdresa.setMinimumSize(new Dimension(80, 10));
        lblAdresa.setPreferredSize(new Dimension(80, 10));
        lblAdresa.setMaximumSize(new Dimension(80, 10));
        add(lblAdresa);        
    }
    
    private void postaviDogadjaZaValidaciju(){
        
        txtAdresa.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                try {
                    validator.validate(txtAdresa.getText());
                    txtAdresa.setBackground(Color.white);
                } catch (Exception ex) {
                    
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    validator.validate(txtAdresa.getText());
                    txtAdresa.setBackground(Color.white);
                } catch (Exception ex) {
                    txtAdresa.setBackground(Color.red);
                    txtAdresa.setToolTipText(ex.getMessage());
                }
            }
        });
    }
}
