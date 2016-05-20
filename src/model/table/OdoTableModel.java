/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import domen.OpstiDomenskiObjekat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mladen
 */
public abstract  class OdoTableModel extends AbstractTableModel{
    protected List<OpstiDomenskiObjekat> listaOdo;
    protected boolean promena;
    protected String[] kolone;

    public OdoTableModel() {
        setKolone();
    }
                   
    @Override
    public int getRowCount() {
        if(listaOdo == null){
            return 0;
        }
        return listaOdo.size();
    }
    
    @Override
    public int getColumnCount() {
        return kolone.length;
    }
    
        @Override
    public String getColumnName(int column) {
        return kolone[column].toString();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return promena;
    }
        
    public void removeRow(int row) {
        listaOdo.remove(row);
        fireTableRowsDeleted(row, row);
    }
            
    public OpstiDomenskiObjekat vratiUcesnika(int red){
        return listaOdo.get(red);
    }

    public List<OpstiDomenskiObjekat> getListaUcesnika() {
        return listaOdo;
    }        

    public void setListaOdo(List<OpstiDomenskiObjekat> listaOdo) {
        this.listaOdo = listaOdo;
    }
    
    public boolean isPromena() {
        return promena;
    }

    public void setPromena(boolean promena) {
        this.promena = promena;
    }
    
    public abstract Object getValueAt(int rowIndex, int columnIndex);
    
    protected abstract void setKolone();
}
