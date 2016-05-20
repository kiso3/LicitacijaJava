/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainForm;

import builder.DirectorForm;
import builder.prijava.NadmetanjeZaOglasBuilder;
import builder.prijava.OglasBuidlerForm;
import builder.ucesnik.UcesnikFizickoBuilder;
import builder.ucesnik.UcesnikTabelaBuilder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.GridPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import koordinator.form.KoordinatorForm;
import panel.form.oef.OpstaEkranskaForma;

/**
 *
 * @author Mladen
 */
public class MainForm extends JFrame{
    
     JPanel mainPanel;
     JMenuBar menuBar;
     
     JMenu menuUcesnik;
     JMenuItem menuItemNoviUcesnik;     
     JMenuItem menuItemSviUcesnik;
     
     JMenu menuOglas;
     JMenuItem menuItemSviOglas;
     
     OpstaEkranskaForma oef;

    
    public MainForm(){

        kreirajKomponenteEkranskeForme();   
        pokreniMenadzeraRasporedaKomponeti();  
        postaviImeForme();  
        postaviMainPanel();
        postaviMeni();
        postaviMenuUcesni();
        postaviMenuItemNoviUcesnik();
        postaviMenuItemSviUcesnik();
        postaviMenuOglas();
        postaviMenuItemSviOglas();
        
        //setMinimumSize(new Dimension(450, 450));        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);        
        setSize(450,450);
    }
    
    public OpstaEkranskaForma vratiAktivnuFormu(){        
           return this.oef;
    }
    
    public void posaviAktivanPanel(OpstaEkranskaForma oef){
        mainPanel.removeAll();
        /*
        GridBagConstraints c =new GridBagConstraints();
        c.fill = GridBagConstraints.NORTHWEST;  
        c.insets = new Insets(2,2,2,2);
        */
        this.oef=oef;
        mainPanel.add(oef);
    }


    private void kreirajKomponenteEkranskeForme() {
        mainPanel = new JPanel();
        menuBar = new JMenuBar();
        menuUcesnik = new JMenu("Učesnik");
        menuItemNoviUcesnik = new JMenuItem("Novi učesnik");
        menuItemSviUcesnik = new JMenuItem("Svi učesnici");
        menuOglas = new JMenu("Oglas");
        menuItemSviOglas = new JMenuItem("Svi oglasi");
    }

    private void pokreniMenadzeraRasporedaKomponeti() {
        
    }

    private void postaviImeForme() {
        
    }

    private void postaviMainPanel() {
        mainPanel.setMaximumSize(new Dimension(300, 500));
        mainPanel.setLayout(new GridBagLayout());        
        //add(mainPanel, BorderLayout.PAGE_START);
        add(mainPanel);   
    }
    
    private void postaviMeni(){
        setJMenuBar(menuBar);
    } 
    
    private void postaviMenuUcesni(){
        menuBar.add(menuUcesnik);
    }
    
    private void postaviMenuItemNoviUcesnik(){
        menuItemNoviUcesnik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                builder.DirectorForm director = new DirectorForm(new UcesnikFizickoBuilder());
                KoordinatorForm.instance().postaviFormu(director.Konstruisi());
                //pack();
            }
        });
        menuUcesnik.add(menuItemNoviUcesnik);       
    }
    
    private void postaviMenuItemSviUcesnik(){
        menuItemSviUcesnik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DirectorForm director = new DirectorForm(new UcesnikTabelaBuilder());
                KoordinatorForm.instance().postaviFormu(director.Konstruisi());
            }
        });
        menuUcesnik.add(menuItemSviUcesnik);
    }
    
    private void postaviMenuOglas(){
        menuBar.add(menuOglas);
    }
    
    private void postaviMenuItemSviOglas(){
        menuItemSviOglas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                builder.DirectorForm director = new DirectorForm(new NadmetanjeZaOglasBuilder());
                KoordinatorForm.instance().postaviFormu(director.Konstruisi());
                //pack();
            }
        });
        menuOglas.add(menuItemSviOglas);
    }
}
