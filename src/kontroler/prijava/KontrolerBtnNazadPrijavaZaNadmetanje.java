/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.prijava;

import builder.DirectorForm;
import builder.prijava.NadmetanjeZaOglasBuilder;
import builder.prijava.PrijaveZaNadmetanjeBuilder;
import domen.Nadmetanje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import koordinator.form.KoordinatorForm;
import decorator.form.prijava.BtnNazadNadmetanjeZaOglasPanelForm;
import decorator.form.prijava.BtnNazadPrijaveZaNadmetanjePanelForm;
import panel.form.oef.OpstaEkranskaForma;

/**
 *
 * @author Mladen
 */
public class KontrolerBtnNazadPrijavaZaNadmetanje {
    private BtnNazadPrijaveZaNadmetanjePanelForm panel;
    
    public KontrolerBtnNazadPrijavaZaNadmetanje(Object panel){
         this.panel = (BtnNazadPrijaveZaNadmetanjePanelForm) panel;
          setControler();
    }
    
      private void setControler() {
      
          panel.btnPanel.btnPanel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            builder.DirectorForm director = new DirectorForm(new PrijaveZaNadmetanjeBuilder(((Nadmetanje)panel.oef.getOdo())));
            OpstaEkranskaForma oef = director.Konstruisi();
            oef.KonvertujDomenskiObjekatUGrafickiObjekat();
            KoordinatorForm.instance().postaviFormu(oef);
            }
          });
                  
      }
}
