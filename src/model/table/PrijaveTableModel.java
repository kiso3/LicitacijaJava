/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import domen.PrijavaFizicko;
import domen.PrijavaPravno;
import java.text.SimpleDateFormat;

/**
 *
 * @author Mladen
 */
public class PrijaveTableModel extends OdoTableModel{
SimpleDateFormat format1  = new SimpleDateFormat("dd-MM-yyyy");
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
         if(listaOdo.get(rowIndex) instanceof PrijavaFizicko){
            PrijavaFizicko pf = (PrijavaFizicko) listaOdo.get(rowIndex);
            switch (columnIndex){
                case 0: return pf.getPrijavaId();
                case 1: return pf.getPonudjacFizicko().getJmbg();
                case 2: return pf.getPonudjacFizicko().getIme() + " " + pf.getPonudjacFizicko().getPrezime();
                case 3: if (pf.isDokazoUplatiDepozita())return "Da";
                        return "Ne";                    
                case 4: if (pf.isDokazoVlasnistvu())return "Da"; return "Ne"; 
                case 5: return format1.format(pf.getDatumPodnosenja().getTime());
                case 6: String datumObilaska = format1.format(pf.getDatumObilaska().getTime());
                        if(datumObilaska != null)return datumObilaska;
                        return "";                                                                    
                default: return "Greska";
            }
        }
        if(listaOdo.get(rowIndex) instanceof PrijavaPravno){
            PrijavaPravno pp = (PrijavaPravno) listaOdo.get(rowIndex);
            switch (columnIndex){
                case 0: return pp.getPrijavaId();
                case 1: return pp.getUcesnikPravno().getMb();
                case 2: return pp.getUcesnikPravno().getNaziv();                
                case 3: if (pp.isDokazoUplatiDepozita())return "Da";
                        return "Ne";                      
                case 4: if(pp.isDokazoVlasnistvu()) return "Da";
                        return "Ne";
                case 5: return format1.format(pp.getDatumPodnosenja().getTime());
                case 6: String datumObilaska = format1.format(pp.getDatumObilaska().getTime());
                        if(datumObilaska != null)return datumObilaska;
                        return "";   
                default: return "Grska";
            }
        }
        return "Greska";
    }

    @Override
    protected void setKolone() {
        kolone = new String[]{"Prijava ID", "JMBG/MB", "Naziv", "Email", "Depozit", "Datum podnošeja", "Datum obilaska"};
    }
    
}
