/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.prijava;

import domen.Mesto;
import domen.Oglas;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JPanel;
import komunikacija.Komunikacija;
import panel.oglas.CBoxOglas;
import panel.ucesnik.CBoxMesto;
import util.Konstante;
import util.TransferObjekat;

/**
 *
 * @author Mladen
 */
public class KontrolerCBoxOglas {
    private JPanel panel;
    private Komunikacija komunikacija;
    
    public KontrolerCBoxOglas(JPanel panel){
            this.panel = panel;
            try {
            komunikacija = Komunikacija.getInstance();
            } catch (Exception e) {
                System.out.println("Neuspelo uspostavljanje veze sa serverom");
            }
                
            
            setControler(panel);
    }
    
    private void setControler(JPanel panel){
        CBoxOglas cboxOglas = (CBoxOglas) panel;
        TransferObjekat DTO = new TransferObjekat();
        DTO.setOperacija(Konstante.GET_LIST_OGLAS);
        DTO.setParametar(new Oglas());
        DTO = komunikacija.izvrsiSo(DTO);        
        if(DTO.getSignal().compareTo(Konstante.GET_LIST_OGLAS_OK)==0){
            List<Oglas> listOglas = (List<Oglas>) DTO.getOdgovor();
            cboxOglas.cboxOglas.removeAllItems();                
            listOglas.forEach(x -> cboxOglas.cboxOglas.addItem(x));           
        }
        
        
    }
}
