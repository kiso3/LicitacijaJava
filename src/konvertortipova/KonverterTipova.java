/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konvertortipova;

import domen.OpstiDomenskiObjekat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Mladen
 */
public class KonverterTipova {

    public static String Konvertuj(JTextField txtField, String string) {
        return txtField.getText();
    }

    public static int Konvertuj(JTextField txtField, int integer) {
        String i = txtField.getText();
        return i.length() == 0 ? 0 : Integer.parseInt(i);
    }
    
    public static double Konvertuj(JTextField txtField, double doubleVal) {
        String i = txtField.getText();
        return i.length() == 0 ? 0.0 : Double.parseDouble(i);
    }

    public static OpstiDomenskiObjekat Konvertuj(JComboBox cbox) {
        return (OpstiDomenskiObjekat) cbox.getSelectedItem();
    }
    
    public static Calendar Konvertuj(UtilDateModel model, Calendar datumPodnosenja) {
        Calendar cal = Calendar.getInstance();        
        
        cal.setTime(model.getValue());
        return cal;
    }
    
    public static boolean Konvertuj(JCheckBox jCheckBox, boolean booleanVal) {
        return jCheckBox.isSelected();
    }
    
    

    public static void Konvertuj(int integer, JTextField txtField) {
        txtField.setText(Integer.toString(integer));
    }

    public static void Konvertuj(String txt, JTextField txtField) {
        txtField.setText(txt);
    }

    public static void Konvertuj(OpstiDomenskiObjekat odo, JComboBox cbox) {        
        OpstiDomenskiObjekat item;
        for (int i = 0; i < cbox.getItemCount(); i++)
        {
            item = (OpstiDomenskiObjekat)cbox.getItemAt(i);
            if (item.vratiUslovZaNadjiSlog().equals(odo.vratiUslovZaNadjiSlog()))
            {
                cbox.setSelectedIndex(i);                
                break;
            }
        }
    }
    
    public static void Konvertuj(double doubleVal, JTextField txtField) {
        txtField.setText(Double.toString(doubleVal));
    }

    public static void Konvertuj(Calendar calendar, UtilDateModel model) {
        model.setValue(calendar.getTime());
    }

    public static void Konvertuj( boolean booleanVal, JCheckBox jCheckBox) {
        jCheckBox.setSelected(booleanVal);
    }




    
}
