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
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.core.UriBuilder;
import java.net.URI;
import org.univaq.swa.sdv.sdvrest.model.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import org.glassfish.jersey.server.Uri;
import org.univaq.swa.sdv.sdvrest.data.MessaggioManager;
import org.univaq.swa.sdv.sdvrest.data.UtenteManager;

public class MessaggiResource {
    
    private final Progetto p;
    
    public MessaggiResource(Progetto p){
        this.p = p;
        
       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       // if (dI != null) dataInizio = LocalDate.parse(dI, formatter);
       // if (dF != null) dataFine = LocalDate.parse(dF, formatter);
    }
    
    /***
     * OP 13 - [BASE]/progetti/id/messaggi
     * @param idProgetto
     * @return
     * @throws RESTWebApplicationException 
     */
    @GET
    @Produces("application/json")
    public Response getAll(@QueryParam("from") int from,
                           @QueryParam("to") int to,
                           @QueryParam("dataInizio") String dI,
                           @QueryParam("dataFine") String dF) throws RESTWebApplicationException {
        
        Messaggio m1 = new Messaggio();
        m1.setPubblico(false);
        m1.setTesto("messaggio 1");
        m1.setDataOra(LocalDateTime.of(2021, Month.MAY, 24, 22, 10));
        UtenteMinimale u1 = new UtenteMinimale();
        u1.setNome("Hanna");
        u1.setCognome("Garcia");
        u1.setEmail("hgar@mail.com");
        m1.setMittente(u1);
        
        Messaggio m2 = new Messaggio();
        m2.setPubblico(true);
        m2.setTesto("messaggio 2");
        m2.setDataOra(LocalDateTime.of(2021, Month.JULY, 23, 10, 05));
        UtenteMinimale u2 = new UtenteMinimale();
        u2.setNome("James");
        u2.setCognome("Benway");
        u2.setEmail("jem_ben@mail.com");
        m2.setMittente(u2);
        
        ArrayList<Messaggio> messaggi = new ArrayList<>();
        messaggi.add(m1);
        messaggi.add(m2);
        
        return Response.ok(messaggi).build();
    }
    
    /***
     * OP 14 - [BASE]/progetti/ID/messaggi
     * @param uriinfo
     * @param m
     * @param idProgetto
     * @return
     * @throws RESTWebApplicationException 
     */
    @Logged
    @POST
    @Consumes("application/json")
    public Response addMessage(
            @Context UriInfo uriinfo,
            Messaggio m,
            @Context ContainerRequestContext req) throws RESTWebApplicationException {

        /*
        Inserimento nuovo messaggio nel sistema
        */
        //MessaggioManager.getInstance().getMessaggi().add(m);
        
        //int id = (int) req.getProperty("IDutente");
        
        //UtenteMinimale u = new UtenteMinimale();
        //UtenteManager.utenti.
        //u.setId(req.getProperty("userID"));
        //int idUtente = (Integer) req.getProperty("IDutente");
        
        //UtenteMinimale u = UtenteManager.getUtenteByID(idUtente);
      
        //m.setMittente(u);
        m.setId(10);
        p.getMessaggi().add(m);
        
        //System.out.println(u.getId());
        
        URI uri = uriinfo.getBaseUriBuilder()                       // [BASE]/rest
                .path(ProgettiResource.class)                       // /progetti
                .path(ProgettiResource.class, "getProject")         // /idProg
                .path(ProgettoResource.class, "getMessages")        // /messaggi
                .path(Integer.toString(m.getId()))
                .build(p.getId()); 
        
        return Response.created(uri).build();
    }
}