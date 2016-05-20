/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.generic;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Mladen
 */
public class BtnPanel extends JPanel{
    public  JButton btnPanel;

    public BtnPanel(String naziv) {
        kreirajKomponente(naziv);
        postaviMenadzeraRasporedaKomponenti();
        postaviBtnPanel();
    }

    public BtnPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void kreirajKomponente(String naziv) {
        btnPanel = new JButton(naziv);
    }
    
    private void postaviMenadzeraRasporedaKomponenti() {
        setLayout(new GridBagLayout());
    }    

    private void postaviBtnPanel() {
        add(btnPanel);
    }

}
