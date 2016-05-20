/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.ucesnik;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import validator.ComponentValidator;
import validator.ucensik.ValidatorNaziv;

/**
 *
 * @author Mladen
 */
public class TFNaziv extends JPanel{
                    
    private JLabel lblNaziv;
    public JTextField txtNaziv;
    private ComponentValidator validator;
    
    public TFNaziv() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelNaziv();
        postaviTextNaziv();
        postaviDogadjaZaValidaciju();
    }
    
    private void kreirajKomponente(){
        lblNaziv = new JLabel("Naziv :");
        txtNaziv = new JTextField();
        validator = new ValidatorNaziv();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    private void postaviTextNaziv(){
        txtNaziv.setColumns(20);
        add(txtNaziv);        
    }
    
    private void postaviLabelNaziv(){
        lblNaziv.setMinimumSize(new Dimension(80, 10));
        lblNaziv.setPreferredSize(new Dimension(80, 10));
        lblNaziv.setMaximumSize(new Dimension(80, 10));                
        add(lblNaziv);        
    }
    
    private void postaviDogadjaZaValidaciju(){
        
        txtNaziv.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                try {
                    validator.validate(txtNaziv.getText());
                    txtNaziv.setBackground(Color.white);
                } catch (Exception ex) {
                    
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    validator.validate(txtNaziv.getText());
                    txtNaziv.setBackground(Color.white);
                } catch (Exception ex) {
                    txtNaziv.setBackground(Color.red);
                    txtNaziv.setToolTipText(ex.getMessage());
                }
            }
        });
    }
}
