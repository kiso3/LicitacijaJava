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
public class TFPovrsina extends JPanel{
    private JLabel lblPovrsina;
    public JTextField txtPovrsina;

    public TFPovrsina() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelOglasId();        
        postaviTextOglasId();
    }
    
    private void kreirajKomponente(){
        lblPovrsina = new JLabel("Površina  ");
        txtPovrsina = new JTextField();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
    }
    private void postaviTextOglasId(){        
        txtPovrsina.setEditable(false);
        txtPovrsina.setColumns(15);
        add(txtPovrsina);        
    }
    
    private void postaviLabelOglasId(){  
        lblPovrsina.setMinimumSize(new Dimension(140, 15));
        lblPovrsina.setPreferredSize(new Dimension(140, 15));
        lblPovrsina.setMaximumSize(new Dimension(140, 15));
        add(lblPovrsina);        
    } 
}
