/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.ucesnik;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.TextField;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Mladen
 */
public class RBtnUcesnik extends JPanel{
                    
    public JRadioButton rbtnUcenikFizicko;
    public JLabel lblUcesnikFizicko;
    public JRadioButton rbtnUcenikPravn;
    public JLabel lblUcesnikPravno;
    public ButtonGroup group = new ButtonGroup();
      
    
    public RBtnUcesnik() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviRbtnUcesnikFizicko();
        postaviLabelUcesnikFizicko();
        postaviRbtnUcesnikPravno();
        postaviLabelUcesnikPravno();
    }
    
    private void kreirajKomponente(){
        rbtnUcenikFizicko = new JRadioButton();
        lblUcesnikFizicko = new JLabel("Fizičko ");
        rbtnUcenikPravn = new JRadioButton();
        lblUcesnikPravno = new JLabel("Pravno ");
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    private void postaviRbtnUcesnikPravno(){                        
        add(rbtnUcenikPravn); 
        group.add(rbtnUcenikPravn);
    }
    
    private void postaviRbtnUcesnikFizicko(){                        
        add(rbtnUcenikFizicko); 
        group.add(rbtnUcenikFizicko);
    }
    
    private void postaviLabelUcesnikFizicko(){                        
        add(lblUcesnikFizicko);        
    }
        
    private void postaviLabelUcesnikPravno(){                        
        add(lblUcesnikPravno);        
    }
}
