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
import java.net.URI;
import java.time.LocalDate;
import org.univaq.swa.sdv.sdvrest.model.*;

public class ProgettoResource {
    
    private final Progetto p;
    
    public ProgettoResource(Progetto p){
        this.p = p;
    }
    
    /**
     * OP 9 - GET [BASE]/progetti/id/dettaglio
     * @return 
     */
    @Path("dettaglio")
    @GET
    @Produces("application/json")
    public Response getProject() {
        try {
            UtenteMinimale coordinatore = new UtenteMinimale();
            coordinatore.setNome("Marco");
            coordinatore.setCognome("Verdi");
            coordinatore.setEmail("gggg@mail.com");
            p.setCoordinatore(coordinatore);
            return Response.ok(p).build();
        } catch (Exception e) {
            throw new RESTWebApplicationException(e);
        }
    }
    
    /***
     * OP 10 - GET[BASE]/progetti/id/tasks
     * @param p
     * @return 
     * estensione del path e fattorizzazione con classe TasksResource
     */
    @Path("tasks")
    public TasksResource getTasks() {
        
        /*
        estrazione dei task associati al progetto dal DB
        */
        
        // TODO: costruzione risposta
        //return Response.ok(pIVA).build();
        return new TasksResource(this.p);
    }
    
    /***
     * OP 13 - GET [BASE]/progetti/id/messaggi
     * @param idProgetto
     * @return 
     */
    @Path("messaggi")
    public MessaggiResource getMessages() {
        return new MessaggiResource(p);
    }
    
}
