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
import validator.ucensik.ValidatorImeRoditelja;

/**
 *
 * @author Mladen
 */
public class TFImeRoditelja extends JPanel{
                
    private JLabel lblImeRoditelja;
    public JTextField txtImeRoditelja;
    private ComponentValidator validator;
    
    public TFImeRoditelja() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelImeRoditelja();
        postaviTextImeRoditelja();
        postaviDogadjaZaValidaciju();
    }
    
    private void kreirajKomponente(){
        lblImeRoditelja = new JLabel("Ime roditelja :");
        txtImeRoditelja = new JTextField();
        validator = new ValidatorImeRoditelja();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    private void postaviTextImeRoditelja(){  
        txtImeRoditelja.setColumns(10);
        add(txtImeRoditelja);        
    }
    
    private void postaviLabelImeRoditelja(){
        lblImeRoditelja.setMinimumSize(new Dimension(80, 10));
        lblImeRoditelja.setPreferredSize(new Dimension(80, 10));
        lblImeRoditelja.setMaximumSize(new Dimension(80, 10));        
        add(lblImeRoditelja);        
    }
    
    private void postaviDogadjaZaValidaciju(){
        
        txtImeRoditelja.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                try {
                    validator.validate(txtImeRoditelja.getText());
                    txtImeRoditelja.setBackground(Color.white);
                } catch (Exception ex) {
                    
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    validator.validate(txtImeRoditelja.getText());
                    txtImeRoditelja.setBackground(Color.white);
                } catch (Exception ex) {
                    txtImeRoditelja.setBackground(Color.red);
                    txtImeRoditelja.setToolTipText(ex.getMessage());
                }
            }
        });
    }
}
