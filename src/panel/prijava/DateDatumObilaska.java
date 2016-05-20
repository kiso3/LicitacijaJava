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
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Mladen
 */
public class DateDatumObilaska extends JPanel{
    public JLabel lblDatumObilaska;
    public UtilDateModel model = new UtilDateModel(); 
    public JDatePanelImpl  dateDatumObliaska;   
    public JDatePickerImpl datePicker;
    
    
    public DateDatumObilaska() {
        kreirajKomponente();
        pokreniMenadzeraRasporedaKomponeti();        
        postaviLabelUcesnikId();
        postaviTextUcesnikId();
        

    }
    
    private void kreirajKomponente(){
        lblDatumObilaska = new JLabel("Datum obilaska");
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        dateDatumObliaska = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(dateDatumObliaska, new DateLabelFormatter());
    }
    
    private void pokreniMenadzeraRasporedaKomponeti(){
        setLayout(new GridBagLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    private void postaviTextUcesnikId(){ 
        //dateDatumObliaska.setColumns(4);        
        //dateDatumObliaska.setEditable(false);
        add(datePicker);        
    }
    
    private void postaviLabelUcesnikId(){    
        lblDatumObilaska.setMinimumSize(new Dimension(120, 10));
        lblDatumObilaska.setPreferredSize(new Dimension(120, 10));
        lblDatumObilaska.setMaximumSize(new Dimension(120, 10));  
        add(lblDatumObilaska);        
    } 
    
}
