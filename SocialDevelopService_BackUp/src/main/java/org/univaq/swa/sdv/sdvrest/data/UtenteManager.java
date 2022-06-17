/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.univaq.swa.sdv.sdvrest.data;

import java.util.ArrayList;
import java.util.List;
import org.univaq.swa.sdv.sdvrest.RESTWebApplicationException;
import org.univaq.swa.sdv.sdvrest.model.Utente;
import org.univaq.swa.sdv.sdvrest.model.UtenteMinimale;

/**
 *
 * @author stefa
 */
public class UtenteManager {
    public static List<Utente> utenti = new ArrayList<Utente>();
    
    public static void initilizeData(){
        Utente utente1 = new Utente();
        utente1.setNome("Stefano");
        utente1.setCognome("Pisciella");
        utente1.setId(1);
        utente1.setEmail("stefano@gmail.com");
        utente1.setTelefono("3880581680");
        utente1.setUsername("stefa");
        utente1.setPassword("stefa");
        utente1.setId(1);
        
        Utente utente2 = new Utente();
        utente2.setNome("Beatrice");
        utente2.setCognome("Tomassi");
        utente2.setEmail("beatrice@gmail.com");
        utente2.setTelefono("3880581680");
        utente2.setUsername("beatrice");
        utente2.setPassword("beatrice");
        utente2.setId(2);
        
        Utente utente3 = new Utente();
        utente3.setNome("Nicola");
        utente3.setCognome("Rossi");
        utente3.setEmail("nicola@gmail.com");
        utente3.setTelefono("3880581680");
        utente3.setUsername("nicola");
        utente3.setPassword("nicola");
        utente3.setId(3);
        
        utenti.add(utente1);
    }
    
    public static UtenteMinimale getUtenteByID(int idUtente) {
        for (Utente u : utenti) {
            if (u.getId() == idUtente) {
                UtenteMinimale res = new UtenteMinimale();
                res.setId(u.getId());
                res.setNome(u.getNome());
                res.setCognome(u.getCognome());
                res.setEmail(u.getEmail());
                
                return res;
            }
        }
        
        throw new RESTWebApplicationException(404, "utente non trovato");
    }
    
}


