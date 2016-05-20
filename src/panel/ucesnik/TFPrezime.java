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
import validator.ucensik.ValidatorPrezime;

/**
 *
 * @author Mladen
 */
public class TFPrezime  extends JPanel{
                
    private JLabel lblPrezime;
    public JTextField txtPrezime;
    private ComponentValidator validator;
    
    public TFPrezime() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelPrezime();
        postaviTextPerzime();
        postaviDogadjaZaValidaciju();
    }
    
    private void kreirajKomponente(){
        lblPrezime = new JLabel("Prezime :");
        txtPrezime = new JTextField();
        validator = new ValidatorPrezime();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    private void postaviTextPerzime(){   
        txtPrezime.setColumns(10);
        add(txtPrezime);        
    }
    
    private void postaviLabelPrezime(){ 
        lblPrezime.setMinimumSize(new Dimension(80, 10));
        lblPrezime.setPreferredSize(new Dimension(80, 10));
        lblPrezime.setMaximumSize(new Dimension(80, 10));  
        add(lblPrezime);        
    }
    
            
    private void postaviDogadjaZaValidaciju(){
        
        txtPrezime.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                try {
                    validator.validate(txtPrezime.getText());
                    txtPrezime.setBackground(Color.white);
                } catch (Exception ex) {
                    
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    validator.validate(txtPrezime.getText());
                    txtPrezime.setBackground(Color.white);
                } catch (Exception ex) {
                    txtPrezime.setBackground(Color.red);
                    txtPrezime.setToolTipText(ex.getMessage());
                }
            }
        });
    }
}
