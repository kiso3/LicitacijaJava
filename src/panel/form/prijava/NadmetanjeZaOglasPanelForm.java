/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.form.prijava;

import domen.Oglas;
import domen.OpstiDomenskiObjekat;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import konvertortipova.KonverterTipova;
import model.table.NadmetanjeTableModel;
import model.table.OdoTableModel;
import panel.form.oef.OpstaEkranskaForma;
import panel.oglas.CBoxOglas;
import panel.oglas.TFLicitacijskiKorak;
import panel.oglas.TFMaxPovZakupa;
import panel.oglas.TFNazivOpstine;
import panel.oglas.TFOglasId;

/**
 *
 * @author Mladen
 */
public class NadmetanjeZaOglasPanelForm extends OpstaEkranskaForma {

    private CBoxOglas cboxOglas;
    private TFOglasId tfOglasId;
    private TFNazivOpstine tfNazivOpstine;
    private TFLicitacijskiKorak tfLicitacijskiKorak;
    private TFMaxPovZakupa tfMaxPovZakupa;
    protected JTable tblNdmetanje;
    protected OdoTableModel tableModel;
    protected JScrollPane jScrollPane;
    
    
    public NadmetanjeZaOglasPanelForm(){
        pokreniMenadzeraRasporedaKomponeti();        
    }
        
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);        
    }

    public CBoxOglas getCboxOglas() {
        return cboxOglas;
    }

    public void setCboxOglas(CBoxOglas cboxOglas) {
        this.cboxOglas = cboxOglas;
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0,0,0,0);
        add(this.cboxOglas,c);
    }

    public TFOglasId getTfOglasId() {
        return tfOglasId;
    }

    public void setTfOglasId(TFOglasId tfOglasId) {
        this.tfOglasId = tfOglasId;
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 1;        
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfOglasId, c);
    }

    public TFNazivOpstine getTfNazivOpstine() {
        return tfNazivOpstine;
    }

    public void setTfNazivOpstine(TFNazivOpstine tfNazivOpstine) {
        this.tfNazivOpstine = tfNazivOpstine;
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 1;        
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfNazivOpstine, c);
    }        
    
    public TFLicitacijskiKorak getTfLicitacijskiKorak() {
        return tfLicitacijskiKorak;
    }

    public void setTfLicitacijskiKorak(TFLicitacijskiKorak tfLicitacijskiKorak) {
        this.tfLicitacijskiKorak = tfLicitacijskiKorak;
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 2;        
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfLicitacijskiKorak, c);
    }

    public TFMaxPovZakupa getTfMaxPovZakupa() {
        return tfMaxPovZakupa;
    }

    public void setTfMaxPovZakupa(TFMaxPovZakupa tfMaxPovZakupa) {
        this.tfMaxPovZakupa = tfMaxPovZakupa;
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 1;
        c.gridy = 2;        
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2,2,2,2);
        add(this.tfMaxPovZakupa, c);
    }           

    public JTable getTblNdmetanje() {
        return tblNdmetanje;
    }
     
    public void setTblNdmetanje(JTable tblNdmetanje) {
        this.tblNdmetanje = tblNdmetanje;
        tblNdmetanje.setFont(new Font("Serif", Font.BOLD, 17));
        tblNdmetanje.setRowHeight(30);
        tblNdmetanje.setRowMargin(3);
        
        //add(this.tblNdmetanje, c);   
    }

    public OdoTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(OdoTableModel odoTableModel) {        
        this.tableModel = odoTableModel;             
        this.tblNdmetanje.setModel(this.tableModel);
        tblNdmetanje.getColumnModel()
                    .getColumn(0)
                    .setPreferredWidth(100);
    }
     
    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    public void setjScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
        this.jScrollPane.setPreferredSize(new Dimension(400, 200));
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 6;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(2,2,2,2);
        this.jScrollPane.setViewportView(this.tblNdmetanje);
        add(this.jScrollPane, c);
    }

    
   
    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        Oglas oglas = (Oglas) odo;
        
        if(cboxOglas != null) oglas = (Oglas) KonverterTipova.Konvertuj(cboxOglas.cboxOglas);
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {               
        Oglas oglas = (Oglas) odo;                        
        if(tfOglasId != null) KonverterTipova.Konvertuj(oglas.getOglasId(), tfOglasId.txtOglasId);
        if(tfNazivOpstine != null) KonverterTipova.Konvertuj(oglas.getNazivOpstine(), tfNazivOpstine.txtNazivOpstine);
        if(tfLicitacijskiKorak != null) KonverterTipova.Konvertuj(oglas.getLicitacijskiKorak(), tfLicitacijskiKorak.txtLicitacijskiKorak);
        if(tfMaxPovZakupa != null) KonverterTipova.Konvertuj(oglas.getMaxPovrsinaZakupa() + "Ha", tfMaxPovZakupa.txtMaxPovZakupa);
        if (cboxOglas != null) KonverterTipova.Konvertuj(oglas, cboxOglas.cboxOglas);
    }

    @Override
    public boolean isValidInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
