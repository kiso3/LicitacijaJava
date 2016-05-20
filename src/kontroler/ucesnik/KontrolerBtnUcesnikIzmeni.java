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
import komunikacija.Komunikacija;
import decorator.form.ucesnik.BtnUcesnikDodajPanelForm;
import decorator.form.ucesnik.BtnUcesnikIzmeniPanelForm;
import util.Konstante;
import util.TransferObjekat;

/**
 *
 * @author Mladen
 */
public class KontrolerBtnUcesnikIzmeni {
    private Object panel;
    private Komunikacija komunikacija;
    
    public KontrolerBtnUcesnikIzmeni(Object panel){
        this.panel = panel;
        try {
            komunikacija = Komunikacija.getInstance();
        } catch (Exception e) {
            System.out.println("Neuspelo uspostavljanje veze sa serverom");
        }
        
        setControler(panel);
    }

    
    private void setControler(Object panel) {        
        
        BtnUcesnikIzmeniPanelForm btnUcesnikIzmeni = (BtnUcesnikIzmeniPanelForm) panel;
        
        btnUcesnikIzmeni.btnPanel.btnPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpstiDomenskiObjekat odo = (OpstiDomenskiObjekat) btnUcesnikIzmeni.oef.getOdo();
                btnUcesnikIzmeni.oef.KonvertujGrafickiObjekatUDomenskiObjekat();
                TransferObjekat DTO = new TransferObjekat();
                DTO.setOperacija(Konstante.EDIT_UCESNIK);
                DTO.setParametar(odo);
                DTO = komunikacija.izvrsiSo(DTO);
                OpstiDomenskiObjekat odo2 = (OpstiDomenskiObjekat) DTO.getOdgovor();
                btnUcesnikIzmeni.oef.setOdo((OpstiDomenskiObjekat)DTO.getOdgovor());
                btnUcesnikIzmeni.oef.KonvertujDomenskiObjekatUGrafickiObjekat();
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
