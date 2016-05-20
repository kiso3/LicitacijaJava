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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import validator.ComponentValidator;
import validator.ucensik.ValidatorIme;

/**
 *
 * @author Mladen
 */
public class TFIme extends JPanel{
                
    private JLabel lblIme;
    public JTextField txtIme;
    private ComponentValidator validator;
    
    public TFIme() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelIme();
        postaviTextIme();
        postaviDogadjaZaValidaciju();
    }
    
    private void kreirajKomponente(){
        lblIme = new JLabel("Ime :");
        txtIme = new JTextField();
        validator = new ValidatorIme();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    private void postaviTextIme(){
        txtIme.setColumns(10);
        add(txtIme);        
    }
    
    private void postaviLabelIme(){ 
        lblIme.setMinimumSize(new Dimension(80, 10));
        lblIme.setPreferredSize(new Dimension(80, 10));
        lblIme.setMaximumSize(new Dimension(80, 10));
        add(lblIme);        
    }
    
        
    private void postaviDogadjaZaValidaciju(){
        
        txtIme.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                try {
                    validator.validate(txtIme.getText());
                    txtIme.setBackground(Color.white);
                } catch (Exception ex) {
                    
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    validator.validate(txtIme.getText());
                    txtIme.setBackground(Color.white);
                } catch (Exception ex) {
                    txtIme.setBackground(Color.red);
                    txtIme.setToolTipText(ex.getMessage());
                }
            }
        });
    }
}
