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
public class TFPocetanCena extends JPanel{
    private JLabel lblPocetnaCena;
    public JTextField txtPocetnaCena;

    public TFPocetanCena() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelOglasId();        
        postaviTextOglasId();
    }
    
    private void kreirajKomponente(){
        lblPocetnaCena = new JLabel("Pocetna cena ");
        txtPocetnaCena = new JTextField();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
    }
    private void postaviTextOglasId(){        
        txtPocetnaCena.setEditable(false);
        txtPocetnaCena.setColumns(15);
        add(txtPocetnaCena);        
    }
    
    private void postaviLabelOglasId(){  
        lblPocetnaCena.setMinimumSize(new Dimension(120, 15));
        lblPocetnaCena.setPreferredSize(new Dimension(120, 15));
        lblPocetnaCena.setMaximumSize(new Dimension(120, 15));
        add(lblPocetnaCena);        
    }  
}
