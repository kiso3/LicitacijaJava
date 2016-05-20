/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.prijava;

import builder.DirectorForm;
import builder.prijava.OdabirUcesnikaZaPrijavuBuilder;
import builder.ucesnik.UcesnikFizickoIzmeniBuilder;
import domen.UcesnikFizicko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import komunikacija.Komunikacija;
import koordinator.form.KoordinatorForm;
import decorator.form.prijava.BtnPrijavaTableDodaj;
import panel.form.oef.OpstaEkranskaForma;

/**
 *
 * @author Mladen
 */
public class KontrolerBtnPrijavaTableDodaj {
    private Object panel;
    private Komunikacija komunikacija;
    public KontrolerBtnPrijavaTableDodaj(Object panel){
        this.panel = panel;
        try {
            komunikacija = Komunikacija.getInstance();
        } catch (Exception e) {
            System.out.println("Neuspelo uspostavljanje veze sa serverom");
        }
        
        setControler(panel);
    }
    
     private void setControler(Object panel) {
        BtnPrijavaTableDodaj btnDodajPrijavu = (BtnPrijavaTableDodaj) panel;
        
        btnDodajPrijavu.btnPanel.btnPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    builder.DirectorForm director = new DirectorForm(
                        new OdabirUcesnikaZaPrijavuBuilder(btnDodajPrijavu.oef.getOdo())
                    );
                    OpstaEkranskaForma oef = director.Konstruisi();                                        
                    KoordinatorForm.instance().postaviFormu(oef);
            }            
        });
     }

}
