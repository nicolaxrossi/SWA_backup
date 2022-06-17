package org.univaq.swa.sdv.sdvrest.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;
import org.univaq.swa.sdv.sdvrest.RESTWebApplicationException;
import org.univaq.swa.sdv.sdvrest.security.Logged;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PUT;
import org.univaq.swa.sdv.sdvrest.data.UtenteManager;
import org.univaq.swa.sdv.sdvrest.model.*;


public class UtenteResource {
    
    // OPPURE UTENTE MINIMALE? NON POSSO TORNARE LA SUA PASSWORD
    private final Utente u;
    
    UtenteResource(Utente u) {
        this.u = u;
    }
    
    /***
     * OP 4 - GET [BASE]/utenti/id/dettaglio
     * @return 
     */
    @Path("dettaglio")
    @GET
    @Produces("application/json")
    public Response getUserDetail() {
        
        /*
        estrae l'utente dal DB (ma non capisco come prendere l'ID)
        */
        
        /*try {
            return Response.ok(f)
                    //possiamo aggiungere alla Response vari elementi, ad esempio header...
                    .header("X-fattura-app-version", "1.0")
                    .build();
        } catch (Exception e) {
            //gestione delle eccezioni (business):
            //Modalità 1: creazione response di errore
//            return Response.serverError()
//                    .entity(e.getMessage()) //mai in produzione
//                    .build();
            //Modalità 2: incapsulamento in eccezione JAXRS compatibile
            throw new RESTWebApplicationException(e);
        }*/
        return Response.ok().build();
    }
    
    /***
     * OP 5 - PUT [BASE]/utenti/id
     * @param utente_nuovo
     * @return 
     */
    @Logged
    @PUT
    @Consumes("application/json")
    public Response updateUser(Utente utente_nuovo) {
        
        UtenteManager.utenti.remove(u);
        UtenteManager.utenti.add(utente_nuovo);
        
        return Response.noContent().build();
    }
    
    /***
     * OP 6 - DELETE [BASE]/utenti/id
     * @return 
     */
    @Logged
    @DELETE
    public Response deleteUser() {
        
        // rimuovo dalla lista di utenti del sistema l'utente u se l'ID esiste (?)
        if(u.getId() > 0) {
            System.out.println(u);
            UtenteManager.utenti.remove(u);  
        }
        
        return Response.noContent().build();
    }
    
    /***
     * OP 12 - GET [BASE]/utenti/id/progetti
     * @return 
     */
    @Path("progetti")
    @GET
    @Produces("application/json")
    public Response getProjects() {
        
        if (u.getId() == 4) throw new RESTWebApplicationException(404, "utente non trovato");
        
        Progetto p1 = new Progetto();
        p1.setNome("progetto 1 utente " + u.getId());
        p1.setDescrizione("descrizione progetto 1 utente " + u.getId());
        //p1.setValutazione(7);
        Progetto p2 = new Progetto();
        p2.setNome("progetto 2 utente " + u.getId());
        p2.setDescrizione("descrizione progetto 2 utente " + u.getId());
        //p2.setValutazione(5);
        Progetto p3 = new Progetto();
        p3.setNome("progetto 3 utente " + u.getId());
        p3.setDescrizione("descrizione progetto 3 utente " + u.getId());
        //p3.setValutazione(3);
        
        ArrayList<Progetto> res = new ArrayList<>();
        res.add(p1);
        res.add(p2);
        res.add(p3);
        
        return Response.ok(res).build();
    }
}
