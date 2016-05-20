/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import panel.form.oef.OpstaEkranskaForma;
import util.TransferObjekat;

/**
 *
 * @author Mladen
 */
public class Komunikacija {
    private Socket soketK;
    private static Komunikacija instance;
    
    ObjectOutputStream out;
    ObjectInputStream in;
    String signal;
    OpstiDomenskiObjekat odo;
    OpstaEkranskaForma oef;
    
    public Komunikacija () throws IOException{
        soketK = new Socket("127.0.0.1" , 1500);
        out = new ObjectOutputStream(soketK.getOutputStream());
        in = new ObjectInputStream(soketK.getInputStream());
    }
    
    public static Komunikacija getInstance() throws IOException
    {
        if(instance == null){
            instance = new Komunikacija();
        }        
        return instance;
    }
    
    public TransferObjekat izvrsiSo(TransferObjekat dto) {
    
        try {
            out.writeObject(dto);            
        } catch (Exception e) {
            System.out.println("Neuspelo slanje DTO objekta na server");
        }
        
        try {
             dto = (TransferObjekat) in.readObject();
        } catch (Exception e) {
            System.out.println("Neuspelo citanje DTO objekta sa server");
        }
        
        return dto;
        
    }

}
