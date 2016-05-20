/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.prijava;

import domen.Nadmetanje;
import domen.Oglas;
import domen.OpstiDomenskiObjekat;
import domen.Ucesnik;
import domen.UcesnikFizicko;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import komunikacija.Komunikacija;
import konvertortipova.KonverterTipova;
import koordinator.form.KoordinatorForm;
import panel.form.prijava.NadmetanjeZaOglasPanelForm;
import panel.form.ucesnik.UcesnikTablePanelForm;
import panel.oglas.CBoxOglas;
import util.Konstante;
import util.TransferObjekat;

/**
 *
 * @author Mladen
 */
public class KontrolerTableNadmetanje {
     Object panel;
    private Komunikacija komunikacija;

    public KontrolerTableNadmetanje(Object panel) {
        this.panel = panel;
        try {
            komunikacija = Komunikacija.getInstance();
        } catch (Exception e) {
            System.out.println("Neuspelo uspostavljanje veze sa serverom");
        }
        setControler(panel);
    }

    private void setControler(Object panel) {
        NadmetanjeZaOglasPanelForm nadmetanjeZaOglasPanelForm = (NadmetanjeZaOglasPanelForm) panel;
        JComboBox cboxOglas = nadmetanjeZaOglasPanelForm.getCboxOglas().cboxOglas;
        
        cboxOglas.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                    getData();
              }
            }
        });
        
                        
        if(nadmetanjeZaOglasPanelForm.getOdo() != null){             
           Oglas o = (Oglas)nadmetanjeZaOglasPanelForm.getOdo();                         
           OpstiDomenskiObjekat item;
            for (int i = 0; i < cboxOglas.getItemCount(); i++)
            {
                item = (OpstiDomenskiObjekat)cboxOglas.getItemAt(i);
                if (item.vratiUslovZaNadjiSlog().equals(o.vratiUslovZaNadjiSlog()))
                {
                    if(i == 0){
                        cboxOglas.setSelectedIndex(i);
                        getData();
                        break;
                    }else{
                        cboxOglas.setSelectedIndex(i);                        
                        break;
                    }
                }
            }                                                   
        }else{
            getData();
        }

    }
    
    private void getData(){
        NadmetanjeZaOglasPanelForm nadmetanjeZaOglasPanelForm = (NadmetanjeZaOglasPanelForm) panel;
        JComboBox cboxOglas = nadmetanjeZaOglasPanelForm.getCboxOglas().cboxOglas;
        Oglas o = (Oglas)cboxOglas.getSelectedItem();
        nadmetanjeZaOglasPanelForm.setOdo(o);
        nadmetanjeZaOglasPanelForm.KonvertujDomenskiObjekatUGrafickiObjekat();
        if(o.getNadnetanjeList().size() == 0){

              TransferObjekat DTO = new TransferObjekat();
              DTO.setOperacija(Konstante.GET_LIST_NADMETANJA);
              DTO.setParametar(o);
              DTO = komunikacija.izvrsiSo(DTO);
              if(DTO.getSignal().compareTo(Konstante.GET_LIST_NADMETANJA_OK)==0){
                  o = (Oglas) DTO.getOdgovor();

                  nadmetanjeZaOglasPanelForm
                          .getTableModel()
                          .setListaOdo((List<OpstiDomenskiObjekat>)(List<?>) o.getNadnetanjeList());

                  nadmetanjeZaOglasPanelForm
                          .getTableModel()
                          .fireTableDataChanged();
              }  

          }else{

                 nadmetanjeZaOglasPanelForm
                         .getTableModel()
                         .setListaOdo((List<OpstiDomenskiObjekat>)(List<?>)o.getNadnetanjeList());
                 nadmetanjeZaOglasPanelForm
                          .getTableModel()
                          .fireTableDataChanged();
        }
        KoordinatorForm.instance().pack();
    }  

}
