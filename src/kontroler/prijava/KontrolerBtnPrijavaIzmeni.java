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
import decorator.form.prijava.BtnPrijavaIzmeni;
import decorator.form.ucesnik.BtnUcesnikIzmeniPanelForm;
import util.Konstante;
import util.TransferObjekat;

/**
 *
 * @author Mladen
 */
public class KontrolerBtnPrijavaIzmeni {
    private Object panel;
    private Komunikacija komunikacija;
    
    public KontrolerBtnPrijavaIzmeni(Object panel){
        this.panel = panel;
        try {
            komunikacija = Komunikacija.getInstance();
        } catch (Exception e) {
            System.out.println("Neuspelo uspostavljanje veze sa serverom");
        }
        
        setControler(panel);
    }

    
    private void setControler(Object panel) {        
        
        BtnPrijavaIzmeni btnPrijavaIzmeni = (BtnPrijavaIzmeni) panel;
        
        btnPrijavaIzmeni.btnPanel.btnPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPrijavaIzmeni.oef.KonvertujGrafickiObjekatUDomenskiObjekat();
                TransferObjekat DTO = new TransferObjekat();
                DTO.setOperacija(Konstante.EDIT_PRIJAVA);
                DTO.setParametar(btnPrijavaIzmeni.oef.getOdo());
                DTO = komunikacija.izvrsiSo(DTO);
                btnPrijavaIzmeni.oef.setOdo((OpstiDomenskiObjekat)DTO.getOdgovor());
                btnPrijavaIzmeni.oef.KonvertujDomenskiObjekatUGrafickiObjekat();
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
