/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.ucesnik;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import model.table.UcesnikTableModel;
import panel.form.ucesnik.UcesnikTablePanelForm;
import panel.ucesnik.TFPretraga;

/**
 *
 * @author Mladen
 */
public class KontrolerTFPretraga {
    private Object panel;
    private TableRowSorter<UcesnikTableModel> rowSorter;
    public KontrolerTFPretraga(Object panel){
        this.panel = panel;          
        setControler(panel);
    }
    
    private void setControler(Object panel) {
        UcesnikTablePanelForm ucesnikTablePanelForm = (UcesnikTablePanelForm) panel;
        TFPretraga tfPretraga = (TFPretraga) ucesnikTablePanelForm.getTfPretraga();
        
        this.rowSorter = new TableRowSorter<>(ucesnikTablePanelForm.getUcesnikTableModel());
        ucesnikTablePanelForm.getTblUcesnik().setRowSorter(rowSorter); 
        
        tfPretraga.txtPretraga.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                  String text = tfPretraga.txtPretraga.getText();
                    if (text.trim().length() == 0) {
                       rowSorter.setRowFilter(null);
                    } else {
                       rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    }
            }
            
        });
    }
    
}
