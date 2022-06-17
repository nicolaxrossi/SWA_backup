/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.univaq.swa.sdv.sdvrest.data;
import java.util.ArrayList;
import java.util.List;
import org.univaq.swa.sdv.sdvrest.model.Messaggio;

/**
 *
 * @author nicola
 */
public class MessaggioManager {
    
    private static MessaggioManager INSTANCE; 
    private List<Messaggio> messaggi = new ArrayList<Messaggio>();
    
    private MessaggioManager(){
    }
    
    public static MessaggioManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new MessaggioManager();
        }
        
        return INSTANCE;
    }
    
    public List<Messaggio> getMessaggi() {
        return messaggi;
    }
}
