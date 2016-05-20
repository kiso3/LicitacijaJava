/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.oglas;

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
public class TFLicitacijskiKorak extends JPanel{
    private JLabel lblLicitacijskiKorak;
    public JTextField txtLicitacijskiKorak;

    public TFLicitacijskiKorak() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelOglasId();        
        postaviTextOglasId();
    }
    
    private void kreirajKomponente(){
        lblLicitacijskiKorak = new JLabel("Licitacijski korak  ");
        txtLicitacijskiKorak = new JTextField();
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
    }
    private void postaviTextOglasId(){        
        txtLicitacijskiKorak.setEditable(false);
        txtLicitacijskiKorak.setColumns(15);        
        add(txtLicitacijskiKorak);        
    }
    
    private void postaviLabelOglasId(){  
        lblLicitacijskiKorak.setMinimumSize(new Dimension(120, 15));
        lblLicitacijskiKorak.setPreferredSize(new Dimension(120, 15));
        lblLicitacijskiKorak.setMaximumSize(new Dimension(120, 15));
        add(lblLicitacijskiKorak);        
    }
}
