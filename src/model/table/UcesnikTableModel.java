/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import domen.Ucesnik;
import domen.UcesnikFizicko;
import domen.UcesnikPravno;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mladen
 */
public class UcesnikTableModel extends OdoTableModel{

  
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(listaOdo.get(rowIndex) instanceof UcesnikFizicko){
            UcesnikFizicko uf = (UcesnikFizicko) listaOdo.get(rowIndex);
            switch (columnIndex){
                case 0: return uf.getJmbg();
                case 1: return uf.getIme() + " " + uf.getPrezime();
                case 2: return uf.getEmail();
                case 3: return uf.getTelefon();
                case 4: return uf.getAdresa();
                case 5: return uf.getMesto().getNaziv();
                default: return "Greska";
            }
        }
        if(listaOdo.get(rowIndex) instanceof UcesnikPravno){
            UcesnikPravno up = (UcesnikPravno) listaOdo.get(rowIndex);
            switch (columnIndex){
                case 0: return up.getMb();
                case 1: return up.getNaziv();
                case 2: return up.getEmail();
                case 3: return up.getTelefon();
                case 4: return up.getAdresa();
                case 5: return up.getMesto().getNaziv();
                default: return "Grska";
            }
        }
        return "Greska";
    }
         
    @Override
    protected void setKolone() {
        kolone = new String[] {"JMBG/MB", "Naziv", "Email", "Telefon", "Adresa", "Mesto"};
    }
}
