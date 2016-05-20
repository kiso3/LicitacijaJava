/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.form.prijava;

import domen.Nadmetanje;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import konvertortipova.KonverterTipova;
import model.table.NadmetanjeTableModel;
import model.table.OdoTableModel;
import model.table.PrijaveTableModel;
import panel.nadmetanje.TFDepozit;
import panel.nadmetanje.TFNadmetanjeOznaka;
import panel.nadmetanje.TFPocetanCena;
import panel.nadmetanje.TFPovrsina;

/**
 *
 * @author Mladen
 */
public class PrijaveZaNadmetanjePanelForm extends NadmetanjeZaOglasPanelForm {
    
    private TFNadmetanjeOznaka tfNadmetanjeOznaka;
    private TFDepozit tfDepozit;
    private TFPocetanCena tfPocetanCena;
    private TFPovrsina tfPovrsina;
    
    
    public PrijaveZaNadmetanjePanelForm(){
        super();
    }

    public TFNadmetanjeOznaka getTfNadmetanjeOznaka() {
        return tfNadmetanjeOznaka;
    }

    public void setTfNadmetanjeOznaka(TFNadmetanjeOznaka tfNadmetanjeOznaka) {
        this.tfNadmetanjeOznaka = tfNadmetanjeOznaka;        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 3;        
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfNadmetanjeOznaka, c);
    }

    public TFDepozit getTfDepozit() {
        return tfDepozit;
    }

    public void setTfDepozit(TFDepozit tfDepozit) {
        this.tfDepozit = tfDepozit;
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 3;        
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfDepozit, c);
    }

    public TFPocetanCena getTfPocetanCena() {
        return tfPocetanCena;
    }

    public void setTfPocetanCena(TFPocetanCena tfPocetanCena) {
        this.tfPocetanCena = tfPocetanCena;
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 4;        
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfPocetanCena, c);
    }

    public TFPovrsina getTFPovrsina() {
        return tfPovrsina;
    }

    public void setTfPovrsina(TFPovrsina TFPovrsina) {
        this.tfPovrsina = TFPovrsina;
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 4;        
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfPovrsina, c);
    }
    
    @Override
    public OdoTableModel getTableModel() {
        return tableModel;
    }
    
    @Override
    public void setTableModel(OdoTableModel odoTableModel) {        
        this.tableModel = odoTableModel;             
        this.tblNdmetanje.setModel(this.tableModel);
        tblNdmetanje.getColumnModel()
                    .getColumn(1)
                    .setPreferredWidth(100);
        
        tblNdmetanje.getColumnModel()
                    .getColumn(2)
                    .setPreferredWidth(150);
        
        tblNdmetanje.getColumnModel()
                    .getColumn(5)
                    .setPreferredWidth(100);
        
        tblNdmetanje.getColumnModel()
                    .getColumn(6)
                    .setPreferredWidth(100);
    }
     
    
    public void setTblNdmetanje(JTable tblOptiDomenskiObjekat) {
        this.tblNdmetanje = tblOptiDomenskiObjekat;
        tblNdmetanje.setFont(new Font("Serif", Font.BOLD, 14));
        tblNdmetanje.setRowHeight(30);
        tblNdmetanje.setRowMargin(3);       
        //add(this.tblNdmetanje, c);   
    }
       
     @Override
    public void setjScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
        this.jScrollPane.setPreferredSize(new Dimension(650, 400));
        
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 6;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(2,2,2,2);
        this.jScrollPane.setViewportView(this.tblNdmetanje);
        add(this.jScrollPane, c);
    }
    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        //super.KonvertujGrafickiObjekatUDomenskiObjekat();
        Nadmetanje nadmetanje = (Nadmetanje) odo;
        
        
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
        //super.KonvertujDomenskiObjekatUGrafickiObjekat();
        Nadmetanje nadmetanje = (Nadmetanje) odo;
        if(getTfOglasId() != null) KonverterTipova.Konvertuj(nadmetanje.getOglas().getOglasId(), getTfOglasId().txtOglasId);
        if(getTfNazivOpstine() != null) KonverterTipova.Konvertuj(nadmetanje.getOglas().getNazivOpstine(), getTfNazivOpstine().txtNazivOpstine);
        if(getTfLicitacijskiKorak() != null) KonverterTipova.Konvertuj(nadmetanje.getOglas().getLicitacijskiKorak(), getTfLicitacijskiKorak().txtLicitacijskiKorak);
        if(getTfMaxPovZakupa() != null) KonverterTipova.Konvertuj(nadmetanje.getOglas().getMaxPovrsinaZakupa() + "Ha", getTfMaxPovZakupa().txtMaxPovZakupa);
        
        if(tfNadmetanjeOznaka != null) KonverterTipova.Konvertuj(nadmetanje.getOznaka(), tfNadmetanjeOznaka.txtNadmetanjeOznaka);
        if(tfDepozit != null) KonverterTipova.Konvertuj(nadmetanje.getDepozit(), tfDepozit.txtDepozit);
        if(tfPocetanCena != null) KonverterTipova.Konvertuj(nadmetanje.getPocetnaCena(), tfPocetanCena.txtPocetnaCena);
        if(tfPovrsina != null) KonverterTipova.Konvertuj(nadmetanje.getPovrsina(), tfPovrsina.txtPovrsina);

    }
}
