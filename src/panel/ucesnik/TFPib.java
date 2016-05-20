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
import validator.ComponentValidator;
import validator.ucensik.ValidatorPib;


/**
 *
 * @author Mladen
 */
public class TFPib extends JPanel{
                    
    private JLabel lblPib;
    public JTextField txtPib;
    private ComponentValidator validator;
    
    public TFPib() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelPib();
        postaviPib();
        postaviDogadjaZaValidaciju();
    }
    
    private void kreirajKomponente(){
        lblPib = new JLabel("PIB :");
        txtPib = new JTextField();
        validator = new ValidatorPib();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    private void postaviPib(){
        txtPib.setColumns(10);
        add(txtPib);        
    }
    
    private void postaviLabelPib(){
        lblPib.setMinimumSize(new Dimension(80, 10));
        lblPib.setPreferredSize(new Dimension(80, 10));
        lblPib.setMaximumSize(new Dimension(80, 10));  
        add(lblPib);        
    }
    
    private void postaviDogadjaZaValidaciju(){
        
        txtPib.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                try {
                    validator.validate(txtPib.getText());
                    txtPib.setBackground(Color.white);
                } catch (Exception ex) {
                    
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    validator.validate(txtPib.getText());
                    txtPib.setBackground(Color.white);
                } catch (Exception ex) {
                    txtPib.setBackground(Color.red);
                    txtPib.setToolTipText(ex.getMessage());
                }
            }
        });
    }
}
