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
import jakarta.ws.rs.WebApplicationException;
import java.net.URI;
import javassist.NotFoundException;
import org.univaq.swa.sdv.sdvrest.model.*;

public class TasksResource {
    
    private Progetto p;
    
    public TasksResource(Progetto p) {
        this.p = p;
    }
    
    /**
     * OP 10 - GET[BASE]/progetti/id/tasks
     * @return 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() throws RESTWebApplicationException {
        
       if (p.getId() == 2) throw new RESTWebApplicationException(404, "task non trovato");
        
       Task t1 = new Task();
       t1.setNome("task 1");
       t1.setDescrizione("descrizione del task 1");
       t1.setAttivo(true);
       //t1.setCollaboratori(collaboratori);
       
       Task t2 = new Task();
       t2.setNome("task 2");
       t2.setDescrizione("descrizione del task 2");
       t2.setAttivo(false);
       
       ArrayList<Task> tasks = new ArrayList<>();
       tasks.add(t1);
       tasks.add(t2);
       
       return Response.ok(tasks).build();
   }
    
    /**
     * OP 11 - GET [BASE]/progetti/id/tasks/id/collaboratori
     * @param riga
     * @return 
     */
    @GET
    @Path("{id: [1-9]+}/collaboratori")
    @Produces("application/json")
    public Response getCollabs(@PathParam("id") int idTask) throws WebApplicationException {
        
        UtenteMinimale u1 = new UtenteMinimale();
        u1.setNome("Oliver");
        u1.setCognome("Bone");
        u1.setEmail("oliver_bone_55412@mail.com");
        
        UtenteMinimale u2 = new UtenteMinimale();
        u2.setNome("Nancy");
        u2.setCognome("Crowford");
        u2.setEmail("nanCro@mail.com");
        
        UtenteMinimale u3 = new UtenteMinimale();
        u3.setNome("Thomsa");
        u3.setCognome("Bell");
        u3.setEmail("tb1234@mail.com");
        
        ArrayList<UtenteMinimale> res = new ArrayList<>();
        res.add(u1);
        res.add(u2);
        res.add(u3);
        
        return Response.ok(res).build();
    }
    
}
