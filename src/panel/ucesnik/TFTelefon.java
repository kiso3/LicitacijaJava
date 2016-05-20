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
import validator.ucensik.ValidatorTelefon;

/**
 *
 * @author Mladen
 */
public class TFTelefon extends JPanel{    
        
    private JLabel lblTelefon;
    public JTextField txtTelefon;
    private ComponentValidator validator;
    
    public TFTelefon() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelTelefon();
        postaviTextTelefon();
        postaviDogadjaZaValidaciju();
    }
    
    private void kreirajKomponente(){
        lblTelefon = new JLabel("Telefon :");
        txtTelefon = new JTextField();
        validator = new ValidatorTelefon();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    private void postaviTextTelefon(){  
        txtTelefon.setColumns(15);
        add(txtTelefon);        
    }
    
    private void postaviLabelTelefon(){        
        lblTelefon.setMinimumSize(new Dimension(80, 10));
        lblTelefon.setPreferredSize(new Dimension(80, 10));
        lblTelefon.setMaximumSize(new Dimension(80, 10));  
        add(lblTelefon);        
    }
    
    private void postaviDogadjaZaValidaciju(){
        
        txtTelefon.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                try {
                    validator.validate(txtTelefon.getText());
                    txtTelefon.setBackground(Color.white);
                } catch (Exception ex) {
                    
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    validator.validate(txtTelefon.getText());
                    txtTelefon.setBackground(Color.white);
                } catch (Exception ex) {
                    txtTelefon.setBackground(Color.red);
                    txtTelefon.setToolTipText(ex.getMessage());                    
                }
            }
        });
    }
}
