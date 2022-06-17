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
import org.univaq.swa.sdv.sdvrest.model.*;

@Path("utenti")
public class UtentiResource {
    
    /**
     * OP 2 - GET [BASE]/utenti
     * Metodo per l'estrazione della lista di utenti noti al sistema,
     * con filtro opzionale sulle skills (2 skill al massimo).
     * @param s1    skill 1
     * @param s2    skill 2
     * @param from  from (paginazione)
     * @param to    to (paginazione)
     * @return
     * @throws RESTWebApplicationException
     */
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(
            @QueryParam("skill1") String s1,
            @QueryParam("skill2") String s2,
            @QueryParam("from") String from,
            @QueryParam("to") String to) throws RESTWebApplicationException {

        List<String> l = new ArrayList();
        
        /**
         * riempire lista con oggetti 'utente' e ritornarla
         */

        return Response.ok(l).build();
    }
    
    /**
     * OP 3 - POST [BASE]/utenti
     * Metodo per l'inserimento di un nuovo utente nel sistema
     * @param uriinfo
     * @param u
     * @return
     * @throws RESTWebApplicationException 
     */
    @Logged
    @POST
    @Consumes("application/json")
    public Response addUser(
            @Context UriInfo uriinfo,
            Utente u) throws RESTWebApplicationException {

        /*
        Inserimento nuovo utente nel sistema
        */
        
        /*
        Costruzione della URL di risposta per l'utente appena inserito
        */
        
        // TODO: da sistemare la costruzione della URL!!
        /*URI uri = uriinfo.getBaseUriBuilder()
                .path(getClass())
                .path(getClass(), "getItem")
                .build(f.getData().get(Calendar.YEAR), f.getNumero());
        
        return Response.created(uri).build();*/
        return Response.ok().build();
    }
    
    /**
     * Estensione del path per gestire le operazioni su singolo utente
     * @param id
     * @return 
     */
    @Path("{id: [1-9]+}")
    public UtenteResource getUser(
            @PathParam("id") int id
    ) {
        
        /**
         * estrazione dell'utente con ID=id dal DB
         */
        
        // TODO: sistemare!!
        //Utente u = ...;
        //return new UtenteResource(u);
        
        /*if (anno >= 2020) {
            //...prelevare la fattura f dal sistema...
            Fattura f = Fattura.dummyFattura(numero, anno);
            return new UtenteResource(f);
        } else {
            //throw new RESTWebApplicationException(404, "Fattura non trovata");
            return null; //ritornare null da un metodo che restituisce una sotto-risorsa equivale a un 404
        }*/
        Utente u = new Utente();
        u.setId(id);
        return new UtenteResource(u);
    }
    
    //--------------------------------------------------------------------------

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(
            @Context UriInfo uriinfo,
            @QueryParam("p") String parametro) throws RESTWebApplicationException {

        List<String> l = new ArrayList();
        l.add("ciao1");
        l.add("ciao2");

        return Response.ok(l).build();
    }
*/
    
    /*@GET
    @Path("{item: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItem(@PathParam("item") int itemID) {
        if (itemID < 1000) {
            // non presente
            return Response.status(404).entity("item not found").build();
        } else {
            return Response.ok(itemID).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMe(
            @Context UriInfo uriinfo, String payload) {
        return Response.created(
                uriinfo.getAbsolutePathBuilder()
                        .path(this.getClass(), "getItem").build(1000))
                .build();
    } */

}
