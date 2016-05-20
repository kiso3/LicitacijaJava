/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.prijava;

import builder.DirectorForm;
import builder.prijava.NadmetanjeZaOglasBuilder;
import domen.Nadmetanje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import koordinator.form.KoordinatorForm;
import decorator.form.prijava.BtnNazadNadmetanjeZaOglasPanelForm;
import decorator.form.prijava.BtnPrijaveZaNadmetanje;

/**
 *
 * @author Mladen
 */
public class KontrolerBtnNazadNadmeajaZaOglas {
    private BtnNazadNadmetanjeZaOglasPanelForm panel;
    
    public KontrolerBtnNazadNadmeajaZaOglas(Object panel){
         this.panel = (BtnNazadNadmetanjeZaOglasPanelForm) panel;
          setControler();
    }
    
      private void setControler() {
      
          panel.btnPanel.btnPanel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            builder.DirectorForm director = new DirectorForm(new NadmetanjeZaOglasBuilder(((Nadmetanje)panel.oef.getOdo()).getOglas()));
            KoordinatorForm.instance().postaviFormu(director.Konstruisi());
            }
          });
                  
      }
}
