/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.prijava;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.Properties;
import javafx.scene.control.DatePicker;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jdatepicker.DateModel;


import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Mladen
 */
public class DateDatumPodnosenja extends JPanel{
    public JLabel lblDatumPodnosenja;
    public UtilDateModel model = new UtilDateModel(); 
    public JDatePanelImpl  dateDatimPodnosenja;   
    private JDatePickerImpl datePicker;
    
    
    public DateDatumPodnosenja() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelUcesnikId();
        postaviTextUcesnikId();
        

    }
    
    private void kreirajKomponente(){
        lblDatumPodnosenja = new JLabel("Datum podnosenja");
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        dateDatimPodnosenja = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(dateDatimPodnosenja, new DateLabelFormatter());
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    private void postaviTextUcesnikId(){ 
        //dateDatimPodnosenja.setColumns(4);        
        //dateDatimPodnosenja.setEditable(false);
        add(datePicker);        
    }
    
    private void postaviLabelUcesnikId(){    
        lblDatumPodnosenja.setMinimumSize(new Dimension(120, 10));
        lblDatumPodnosenja.setPreferredSize(new Dimension(120, 10));
        lblDatumPodnosenja.setMaximumSize(new Dimension(120, 10));  
        add(lblDatumPodnosenja);        
    }
}

