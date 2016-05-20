/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.ucesnik;

import MainForm.DijalogBoksPrikazPoruke;
import domen.OpstiDomenskiObjekat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import komunikacija.Komunikacija;
import decorator.form.ucesnik.BtnUcesnikTabeObrisi;
import model.table.UcesnikTableModel;
import decorator.form.ucesnik.BtnUcesnikDodajPanelForm;
import panel.form.ucesnik.UcesnikTablePanelForm;
import util.Konstante;
import util.TransferObjekat;


/**
 *
 * @author Mladen
 */
public class KontrolerBtnTableObrisi {
    private Object panel;
    private Komunikacija komunikacija;
    
    public KontrolerBtnTableObrisi(Object panel){
        this.panel = panel;
        try {
            komunikacija = Komunikacija.getInstance();
        } catch (Exception e) {
            System.out.println("Neuspelo uspostavljanje veze sa serverom");
        }
        
        setControler(panel);
    }

    private void setControler(Object panel) {
        BtnUcesnikTabeObrisi btnUcesnikTabeObrisi = (BtnUcesnikTabeObrisi) panel;
        
        btnUcesnikTabeObrisi.btnPanel.btnPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UcesnikTablePanelForm ucesnikTablePanelForm = (UcesnikTablePanelForm)btnUcesnikTabeObrisi.oef;                
                int selectedRow = ucesnikTablePanelForm.getTblUcesnik().getSelectedRow();
                if(selectedRow == -1) return;
                UcesnikTableModel ucesnikTableModel = (UcesnikTableModel) ucesnikTablePanelForm.getUcesnikTableModel();
                OpstiDomenskiObjekat odo = ucesnikTableModel.getListaUcesnika().get(selectedRow);
                TransferObjekat DTO = new TransferObjekat();
                DTO.setOperacija(Konstante.DELETE_UCESNIK);
                DTO.setParametar(odo);
                DTO = komunikacija.izvrsiSo(DTO);
                if(DTO.getSignal().compareTo(Konstante.DELETE_UCESNIK_OK)==0){                    
                    ucesnikTableModel.removeRow(selectedRow);                    
                }
                PrikazPoruku(DTO.getSignal());
            }
        });      
    }
    void PrikazPoruku(String signal)
    { Boolean prikazi = new Boolean(true);
      DijalogBoksPrikazPoruke DBPP = DijalogBoksPrikazPoruke.getInstance();
      int signal1 = DBPP.PrikazPoruke(signal);
      if (signal1 == 1)
        { DBPP.show();
          DBPP.pack();
        }
    }
}
