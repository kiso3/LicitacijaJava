/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.ucesnik;

import builder.DirectorForm;
import builder.ucesnik.UcesnikFizickoBuilder;
import decorator.form.DecoratorForm;
import decorator.form.UnosForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import komunikacija.Komunikacija;
import koordinator.form.KoordinatorForm;
import decorator.form.ucesnik.BtnUcesnikTableDodaj;
import decorator.form.prijava.BtnPrijavaTableDodaj;
import panel.generic.BtnPanel;

/**
 *
 * @author Mladen
 */
public class KontrolerBtnTableDodaj{           
    private Object panel;
    private Komunikacija komunikacija;
    public KontrolerBtnTableDodaj(Object panel){
        this.panel = panel;
        try {
            komunikacija = Komunikacija.getInstance();
        } catch (Exception e) {
            System.out.println("Neuspelo uspostavljanje veze sa serverom");
        }
        
        setControler(panel);
    }

    private void setControler(Object panel) {
        BtnUcesnikTableDodaj btnUcesnikTableDodaj = (BtnUcesnikTableDodaj) panel;
        
        btnUcesnikTableDodaj.btnPanel.btnPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                builder.DirectorForm director = new DirectorForm(new UcesnikFizickoBuilder());
                KoordinatorForm.instance().postaviFormu(director.Konstruisi());
            }
        });
    }
}
