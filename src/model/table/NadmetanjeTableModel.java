/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import domen.Nadmetanje;

/**
 *
 * @author Mladen
 */
public class NadmetanjeTableModel extends OdoTableModel{
   
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {        
        Nadmetanje n = (Nadmetanje) listaOdo.get(rowIndex);
            switch (columnIndex){
                case 0: return n.getOznaka();
                case 1: return n.getPocetnaCena();
                case 2: return n.getDepozit();
                case 3: return n.getPovrsina();                
                default: return "Greska";
            }        
    }
                 
    @Override
    protected void setKolone() {
        kolone = new String[]{"Oznaka", "Pocetna cena", "Depozit", "Površina (ha)"};
    } 
}
