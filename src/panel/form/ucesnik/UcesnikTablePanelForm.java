/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.form.ucesnik;

import panel.form.oef.OpstaEkranskaForma;
import domen.OpstiDomenskiObjekat;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.table.UcesnikTableModel;
import panel.ucesnik.TFIme;
import panel.ucesnik.TFPretraga;


/**
 *
 * @author Mladen
 */
public class UcesnikTablePanelForm extends OpstaEkranskaForma{

    private JTable tblUcesnik;
    private UcesnikTableModel ucesnikTableModel;
    private JScrollPane jScrollPane;
    private TFPretraga tfPretraga;
    private TableRowSorter<UcesnikTableModel> rowSorter;
    
    public UcesnikTablePanelForm() {
         pokreniMenadzeraRasporedaKomponeti(); 
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);        
    }
        
        
    public JTable getTblUcesnik() {
        return tblUcesnik;
    }
    

    public void setTblUcesnik(JTable tblUcesnik) {  
        this.tblUcesnik = tblUcesnik;
        //add(this.tblUcesnik, );                
    }

    public UcesnikTableModel getUcesnikTableModel() {
        return ucesnikTableModel;
    }

        
    public void setUcesnikTableModel(UcesnikTableModel ucesnikTableModel) {
        this.ucesnikTableModel = ucesnikTableModel;
        this.tblUcesnik.setModel(this.ucesnikTableModel);  
        //this.rowSorter = new TableRowSorter<>(this.ucesnikTableModel);
        //this.tblUcesnik.setRowSorter(rowSorter);
    }           
    
    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    public void setjScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 4;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(2,2,2,2);
        this.jScrollPane.setViewportView(this.tblUcesnik);
        add(this.jScrollPane, c);
    }

    public TFPretraga getTfPretraga() {
        return tfPretraga;
    }

    public void setTfPretraga(TFPretraga tfPretraga) {
        this.tfPretraga = tfPretraga;
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(2,2,2,2);
        this.jScrollPane.setViewportView(this.tblUcesnik);
        add(this.tfPretraga, c);
    }
    
    

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValidInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
