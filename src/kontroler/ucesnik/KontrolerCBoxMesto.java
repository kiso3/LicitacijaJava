/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.ucesnik;

import domen.Mesto;
import java.util.List;
import javax.swing.JPanel;
import komunikacija.Komunikacija;
import panel.form.oef.OpstaEkranskaForma;
import panel.ucesnik.CBoxMesto;
import util.Konstante;
import util.TransferObjekat;

/**
 *
 * @author Mladen
 */
public class KontrolerCBoxMesto {
    
    private JPanel panel;
    private Komunikacija komunikacija;
    
    public KontrolerCBoxMesto(JPanel panel){
            this.panel = panel;
            try {
            komunikacija = Komunikacija.getInstance();
            } catch (Exception e) {
                System.out.println("Neuspelo uspostavljanje veze sa serverom");
            }
                
            
            setControler(panel);
    }
    
    private void setControler(JPanel panel){
        CBoxMesto cboxMesto = (CBoxMesto) panel;
        TransferObjekat DTO = new TransferObjekat();
        DTO.setOperacija(Konstante.GET_LIST_MESTA);
        DTO.setParametar(new Mesto());
        DTO = komunikacija.izvrsiSo(DTO);        
        if(DTO.getSignal().compareTo(Konstante.GET_LIST_MESTA_OK)==0){
            List<Mesto> listMesto = (List<Mesto>) DTO.getOdgovor();
            cboxMesto.cboxMesto.removeAllItems();                
            listMesto.forEach(x -> cboxMesto.cboxMesto.addItem(x));           
        }               
    }

    
}
