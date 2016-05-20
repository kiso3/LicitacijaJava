/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainForm;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mladen
 */
public class DijalogBoksPrikazPoruke extends JDialog
{ 
   private static DijalogBoksPrikazPoruke instance;
   private DijalogBoksPrikazPoruke()
   { 
      // super(roditelj,"Poruka:", true);
   } // true definise modalni dijalog

   public static DijalogBoksPrikazPoruke getInstance()
   {
       if(instance == null){
           instance = new DijalogBoksPrikazPoruke();
       }
       return instance;
   }
  public int PrikazPoruke(String signal)
    {      
      getContentPane().removeAll();
      Box b = Box.createVerticalBox();
      b.add(Box.createGlue());

      System.out.println("Signal (klijent):" + signal);

      b.add(new JLabel(signal));
      getContentPane().add(b,"Center");
      setSize(750,75);
      return 1;
    }
}
