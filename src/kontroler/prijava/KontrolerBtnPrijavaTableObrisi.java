/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.prijava;

import MainForm.DijalogBoksPrikazPoruke;
import domen.OpstiDomenskiObjekat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import komunikacija.Komunikacija;
import model.table.OdoTableModel;
import model.table.UcesnikTableModel;
import decorator.form.prijava.BtnPrijavaTableObrisi;
import panel.form.prijava.PrijaveZaNadmetanjePanelForm;
import decorator.form.ucesnik.BtnUcesnikTabeObrisi;
import panel.form.ucesnik.UcesnikTablePanelForm;
import util.Konstante;
import util.TransferObjekat;

/**
 *
 * @author Mladen
 */
public class KontrolerBtnPrijavaTableObrisi {
    private Object panel;
    private Komunikacija komunikacija;
    
    public KontrolerBtnPrijavaTableObrisi(Object panel){
        this.panel = panel;
        try {
            komunikacija = Komunikacija.getInstance();
        } catch (Exception e) {
            System.out.println("Neuspelo uspostavljanje veze sa serverom");
        }
        
        setControler(panel);
    }
    
      private void setControler(Object panel) {
        BtnPrijavaTableObrisi btnPrijavaTableObrisi = (BtnPrijavaTableObrisi) panel;
        
        btnPrijavaTableObrisi.btnPanel.btnPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrijaveZaNadmetanjePanelForm prijaveZaNadmetanjePanelForm = (PrijaveZaNadmetanjePanelForm)btnPrijavaTableObrisi.oef;                
                int selectedRow = prijaveZaNadmetanjePanelForm.getTblNdmetanje().getSelectedRow();
                if(selectedRow == -1) return;
                OdoTableModel odoTableModel = (OdoTableModel) prijaveZaNadmetanjePanelForm.getTableModel();
                OpstiDomenskiObjekat odo = odoTableModel.getListaUcesnika().get(selectedRow);
                TransferObjekat DTO = new TransferObjekat();
                DTO.setOperacija(Konstante.DELETE_PRIJAVA);
                DTO.setParametar(odo);
                DTO = komunikacija.izvrsiSo(DTO);
                if(DTO.getSignal().compareTo(Konstante.DELETE_PRIJAVA_OK)==0){                    
                    odoTableModel.removeRow(selectedRow);                    
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
