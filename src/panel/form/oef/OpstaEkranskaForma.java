/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.form.oef;

import domen.OpstiDomenskiObjekat;
import javax.swing.JPanel;
import javax.swing.table.TableModel;

/**
 *
 * @author Mladen
 */
public abstract class OpstaEkranskaForma extends JPanel{
    
    protected OpstiDomenskiObjekat odo;

    public OpstiDomenskiObjekat getOdo() {
        return odo;
    }

    public void setOdo(OpstiDomenskiObjekat odo) {
        this.odo = odo;
    }
    /*
    public abstract TableModel vratiModel();
    public abstract Object[] vratiPocetneVrednosti();
    public abstract int vratiSelektovaniRed();
    public abstract OpstiDomenskiObjekat kreirajObjekat();
   */
    public abstract void KonvertujGrafickiObjekatUDomenskiObjekat();
    public abstract void KonvertujDomenskiObjekatUGrafickiObjekat();
    public abstract boolean isValidInput();
    
}
