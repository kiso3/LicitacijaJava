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
import domen.Prijava;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import koordinator.form.KoordinatorForm;
import decorator.form.prijava.BtnNazadNadmetanjeZaOglasPanelForm;
import decorator.form.prijava.BtnNazadPrijavaZaNadmetanjeSaPrijavPanelForm;
import panel.form.oef.OpstaEkranskaForma;

/**
 *
 * @author Mladen
 */
public class KontrolerBtnNazadPrijavaZaNadmetanjeSaPrijavPanelForm {
    private BtnNazadPrijavaZaNadmetanjeSaPrijavPanelForm panel;
    
    public KontrolerBtnNazadPrijavaZaNadmetanjeSaPrijavPanelForm(Object panel){
         this.panel = (BtnNazadPrijavaZaNadmetanjeSaPrijavPanelForm) panel;
          setControler();
    }
    
      private void setControler() {
      
          panel.btnPanel.btnPanel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            builder.DirectorForm director = new DirectorForm(new PrijaveZaNadmetanjeBuilder(((Prijava)panel.oef.getOdo()).getNadmetanje()));
            OpstaEkranskaForma oef = director.Konstruisi();
            oef.KonvertujDomenskiObjekatUGrafickiObjekat();
            KoordinatorForm.instance().postaviFormu(oef);
            }
          });
                  
      }
}