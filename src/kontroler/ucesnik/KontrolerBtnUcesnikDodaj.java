/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.ucesnik;

import MainForm.DijalogBoksPrikazPoruke;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import komunikacija.Komunikacija;
import decorator.form.ucesnik.BtnUcesnikDodajPanelForm;
import util.Konstante;
import util.TransferObjekat;

/**
 *
 * @author Mladen
 */
public class KontrolerBtnUcesnikDodaj {
    private Object panel;
    private Komunikacija komunikacija;
    
    public KontrolerBtnUcesnikDodaj(Object panel){
        this.panel = panel;
        try {
            komunikacija = Komunikacija.getInstance();
        } catch (Exception e) {
            System.out.println("Neuspelo uspostavljanje veze sa serverom");
        }
        
        setControler(panel);
    }

    
    private void setControler(Object panel) {        
        
        BtnUcesnikDodajPanelForm btnFizickoDodaj = (BtnUcesnikDodajPanelForm) panel;
        
        btnFizickoDodaj.btnPanel.btnPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!btnFizickoDodaj.oef.isValidInput()) return;
                btnFizickoDodaj.oef.KonvertujGrafickiObjekatUDomenskiObjekat();
                TransferObjekat DTO = new TransferObjekat();
                DTO.setOperacija(Konstante.ADD_UCESNIK);
                DTO.setParametar(btnFizickoDodaj.oef.getOdo());
                DTO = komunikacija.izvrsiSo(DTO);
                btnFizickoDodaj.oef.setOdo((OpstiDomenskiObjekat)DTO.getOdgovor());
                btnFizickoDodaj.oef.KonvertujDomenskiObjekatUGrafickiObjekat();
                PrikazPoruku(DTO.getSignal());
            }
        });
        

    }
    void PrikazPoruku(String signal)
    { Boolean prikazi = new Boolean(true);;
      DijalogBoksPrikazPoruke DBPP = DijalogBoksPrikazPoruke.getInstance();
      int signal1 = DBPP.PrikazPoruke(signal);
      if (signal1 == 1)
        { DBPP.show();
          DBPP.pack();
        }
    }
    
}
