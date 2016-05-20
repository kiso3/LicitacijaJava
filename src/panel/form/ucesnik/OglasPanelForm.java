/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.form.ucesnik;

import panel.form.oef.OpstaEkranskaForma;
import domen.Oglas;
import domen.OpstiDomenskiObjekat;
import java.awt.GridBagLayout;
import javax.swing.table.TableModel;
import panel.oglas.TFOglasId;

/**
 *
 * @author Mladen
 */
public class OglasPanelForm extends OpstaEkranskaForma{

    private TFOglasId tfOglasId;
    
    public OglasPanelForm(){
        pokreniMenadzeraRasporedaKomponeti();
    };
    
    public TFOglasId getTfOglasId() {
        return tfOglasId;
    }

    public void setTfOglasId(TFOglasId tfOglasId) {
        this.tfOglasId = tfOglasId;
        add(tfOglasId);
    }
       
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
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
