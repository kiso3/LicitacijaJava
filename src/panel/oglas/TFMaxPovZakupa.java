/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.oglas;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mladen
 */
public class TFMaxPovZakupa extends JPanel{
    private JLabel lblMaxPovZakupa;
    public JTextField txtMaxPovZakupa;

    public TFMaxPovZakupa() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelOglasId();        
        postaviTextOglasId();
    }
    
    private void kreirajKomponente(){
        lblMaxPovZakupa = new JLabel("Max površina zakupa :");
        txtMaxPovZakupa = new JTextField();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
    }
    private void postaviTextOglasId(){        
        txtMaxPovZakupa.setEditable(false);
        txtMaxPovZakupa.setColumns(15);
        add(txtMaxPovZakupa);        
    }
    
    private void postaviLabelOglasId(){ 
        lblMaxPovZakupa.setMinimumSize(new Dimension(140, 15));
        lblMaxPovZakupa.setPreferredSize(new Dimension(140, 15));
        lblMaxPovZakupa.setMaximumSize(new Dimension(140, 15));
        add(lblMaxPovZakupa);        
    }    

}
