/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.nadmetanje;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mladen
 */
public class TFNadmetanjeOznaka extends JPanel{
    private JLabel lblNadmetanjeOznaka;
    public JTextField txtNadmetanjeOznaka;

    public TFNadmetanjeOznaka() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelOglasId();        
        postaviTextOglasId();
    }
    
    private void kreirajKomponente(){
        lblNadmetanjeOznaka = new JLabel("Nadmetanje oznaka ");
        txtNadmetanjeOznaka = new JTextField();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
    }
    private void postaviTextOglasId(){        
        txtNadmetanjeOznaka.setEditable(false);
        txtNadmetanjeOznaka.setColumns(15);
        add(txtNadmetanjeOznaka);        
    }
    
    private void postaviLabelOglasId(){  
        lblNadmetanjeOznaka.setMinimumSize(new Dimension(120, 15));
        lblNadmetanjeOznaka.setPreferredSize(new Dimension(120, 15));
        lblNadmetanjeOznaka.setMaximumSize(new Dimension(120, 15));
        add(lblNadmetanjeOznaka);        
    }
}
