/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.ucesnik;

import builder.DirectorForm;
import builder.ucesnik.UcesnikFizickoBuilder;
import builder.ucesnik.UcesnikPravnoBuilder;
import domen.UcesnikFizicko;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JPanel;
import panel.form.ucesnik.UcesnikPanelForm;
import panel.ucesnik.RBtnUcesnik;

/**
 *
 * @author Mladen
 */
public class KontrolerRBtnUcesnik {
    private JPanel panel;

    public KontrolerRBtnUcesnik(JPanel panel) {
        this.panel = panel;
         setControler(panel);
    }

    private void setControler(JPanel panel) {
        UcesnikPanelForm ucesnikPanelForm = (UcesnikPanelForm) panel;
        if(ucesnikPanelForm.getOdo() instanceof  UcesnikFizicko)
        {
            ucesnikPanelForm.getRbtnUcenik().rbtnUcenikFizicko.setSelected(true);
        }else {
            ucesnikPanelForm.getRbtnUcenik().rbtnUcenikPravn.setSelected(true);
        }
        
        ucesnikPanelForm.getRbtnUcenik().rbtnUcenikFizicko.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {               
                if(e.getStateChange()==1){builder.DirectorForm director = new DirectorForm(new UcesnikFizickoBuilder());
                koordinator.form.KoordinatorForm.instance().postaviFormu(director.Konstruisi());                
                }
            }
        });
        
        ucesnikPanelForm.getRbtnUcenik().rbtnUcenikPravn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {               
                if(e.getStateChange()==1){builder.DirectorForm director = new DirectorForm(new UcesnikPravnoBuilder());
                koordinator.form.KoordinatorForm.instance().postaviFormu(director.Konstruisi());                
                }
            }
        });

    }
}
