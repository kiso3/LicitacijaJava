/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler.prijava;

import domen.OpstiDomenskiObjekat;
import domen.UcesnikFizicko;
import domen.UcesnikPravno;
import java.util.ArrayList;
import komunikacija.Komunikacija;
import panel.form.ucesnik.UcesnikTablePanelForm;
import util.Konstante;
import util.TransferObjekat;

/**
 *
 * @author Mladen
 */
public class KontrolerTableOdabirUcesnikaZaPrijavu {
    Object panel;
    private Komunikacija komunikacija;

    public KontrolerTableOdabirUcesnikaZaPrijavu(Object panel) {
        this.panel = panel;
        try {
            komunikacija = Komunikacija.getInstance();
        } catch (Exception e) {
            System.out.println("Neuspelo uspostavljanje veze sa serverom");
        }
        setControler(panel);
    }

    private void setControler(Object panel) {
        UcesnikTablePanelForm ucesnikTablePanelForm = (UcesnikTablePanelForm) panel;
        ArrayList<OpstiDomenskiObjekat> listaUcenika = new ArrayList<>();
        TransferObjekat DTO = new TransferObjekat();
        DTO.setOperacija(Konstante.GET_LISTA_UCESNIKA_ZA_PRIJAVU);
        DTO.setParametar(ucesnikTablePanelForm.getOdo());
        DTO = komunikacija.izvrsiSo(DTO);
        if(DTO.getSignal().compareTo(Konstante.GET_LISTA_UCESNIKA_ZA_PRIJAVU_OK)==0){
            //listaUcenika = (ArrayList<OpstiDomenskiObjekat>)DTO.getOdgovor();
            listaUcenika.addAll((ArrayList<OpstiDomenskiObjekat>)DTO.getOdgovor());
            ucesnikTablePanelForm.getUcesnikTableModel().setListaOdo(listaUcenika);
        }        
    }
}
