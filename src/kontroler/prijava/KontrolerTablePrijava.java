/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.prijava;

import domen.Nadmetanje;
import domen.Oglas;
import domen.OpstiDomenskiObjekat;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JComboBox;
import komunikacija.Komunikacija;
import panel.form.prijava.NadmetanjeZaOglasPanelForm;
import panel.form.prijava.PrijaveZaNadmetanjePanelForm;
import util.Konstante;
import util.TransferObjekat;

/**
 *
 * @author Mladen
 */
public class KontrolerTablePrijava {
    Object panel;
    private Komunikacija komunikacija;

    public KontrolerTablePrijava(Object panel) {
        this.panel = panel;
        try {
            komunikacija = Komunikacija.getInstance();
        } catch (Exception e) {
            System.out.println("Neuspelo uspostavljanje veze sa serverom");
        }
        setControler(panel);
    }

    private void setControler(Object panel) {
        PrijaveZaNadmetanjePanelForm prijaveZaNadmetanjePanelForm = (PrijaveZaNadmetanjePanelForm) panel;

        if(prijaveZaNadmetanjePanelForm.getOdo() != null) {
            Nadmetanje nadmetanje = (Nadmetanje) prijaveZaNadmetanjePanelForm.getOdo();          
            TransferObjekat DTO = new TransferObjekat();
            DTO.setOperacija(Konstante.GET_LIST_PRIJAVA);
            DTO.setParametar(nadmetanje);
            DTO = komunikacija.izvrsiSo(DTO);
            if(DTO.getSignal().compareTo(Konstante.GET_LIST_PRIJAVA_OK)==0){        
                prijaveZaNadmetanjePanelForm
                        .getTableModel()
                        .setListaOdo((List<OpstiDomenskiObjekat>)DTO.getOdgovor());        
            }
        }
    }
}
