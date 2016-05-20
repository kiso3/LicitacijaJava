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
import validator.ucensik.ValidatorMb;

/**
 *
 * @author Mladen
 */
public class TFMb  extends JPanel{
            
    private JLabel lblMb;
    public JTextField txtMb;
    private ComponentValidator validator;
    
    public TFMb() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelMb();
        postaviTextMb();
        postaviDogadjaZaValidaciju();
    }
    
    private void kreirajKomponente(){
        lblMb = new JLabel("MB :");
        txtMb = new JTextField();
        validator = new ValidatorMb();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    private void postaviTextMb(){
        txtMb.setColumns(10);
        add(txtMb);        
    }
    
    private void postaviLabelMb(){     
        lblMb.setMinimumSize(new Dimension(80, 10));
        lblMb.setPreferredSize(new Dimension(80, 10));
        lblMb.setMaximumSize(new Dimension(80, 10));        
        add(lblMb);        
    }
    
    private void postaviDogadjaZaValidaciju(){
        
        txtMb.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                try {
                    validator.validate(txtMb.getText());
                    txtMb.setBackground(Color.white);
                } catch (Exception ex) {
                    
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    validator.validate(txtMb.getText());
                    txtMb.setBackground(Color.white);
                } catch (Exception ex) {
                    txtMb.setBackground(Color.red);
                    txtMb.setToolTipText(ex.getMessage());
                }
            }
        });
    }
}
