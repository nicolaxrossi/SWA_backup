package org.univaq.swa.sdv.sdvrest.security;

import java.util.UUID;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.util.Iterator;
import java.util.List;
import org.univaq.swa.sdv.sdvrest.data.TokenManager;
import org.univaq.swa.sdv.sdvrest.data.UtenteManager;
import org.univaq.swa.sdv.sdvrest.model.Utente;

/**
 *
 * @author didattica /rest/auth
 *
 */
@Path("auth")
public class AutenticazioneResource {

    /*@POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response doLogin(@Context UriInfo uriinfo,
            //un altro modo per ricevere e iniettare i parametri con JAX-RS...
            @FormParam("username") String username,
            @FormParam("password") String password) {
        
        //UtenteManager.initilizeData();
        
        /*try {
            Integer userID = authenticate(username, password);
            
            // il metodo "authenticate" ritorna null se l'autenticazione non ha avuto successo, in caso contrario ritorna un intero
            // che indica l'ID del client che intende autenticarsi
            if (userID != null) {
                // caso in cui l'AUTENTICAZIONE ha avuto SUCCESSO
                String authToken = issueToken(userID);

                //return Response.ok(authToken).build();
                //return Response.ok().cookie(new NewCookie("token", authToken)).build();
                //return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + authToken).build();
                //Restituiamolo in tutte le modalità, giusto per fare un esempio..
                return Response.ok(authToken).header(HttpHeaders.AUTHORIZATION, "Bearer " + authToken).build();
                      //.cookie(new NewCookie("token", authToken))
            } else {
                // caso in cui l'AUTENTICAZIONE NON ha avuto SUCCESSO
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }*/
        
        /*try {
            if (authenticate(username, password)) {
                
                String authToken = issueToken(uriinfo, username);

                //return Response.ok(authToken).build();
                //return Response.ok().cookie(new NewCookie("token", authToken)).build();
                //return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + authToken).build();
                //Restituiamolo in tutte le modalità, giusto per fare un esempio..
                return Response.ok(authToken)
                        .cookie(new NewCookie("token", authToken))
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + authToken).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }*/
    
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response doLogin(@Context UriInfo uriinfo,
            //un altro modo per ricevere e iniettare i parametri con JAX-RS...
            @FormParam("username") String username,
            @FormParam("password") String password) {
        try {
            if (authenticate(username, password)) {
                /* per esempio */
                String authToken = issueToken(uriinfo, username);

                //return Response.ok(authToken).build();
                //return Response.ok().cookie(new NewCookie("token", authToken)).build();
                //return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + authToken).build();
                //Restituiamolo in tutte le modalità, giusto per fare un esempio..
                return Response.ok(authToken)
                        .cookie(new NewCookie("token", authToken))
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + authToken).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @Logged
    @DELETE
    @Path("/logout")
    public Response doLogout(@Context HttpServletRequest request) {
        try {
            //estraiamo i dati inseriti dal nostro LoggedFilter...
            // TO CHECK
            String token = (String) request.getAttribute("token");
            if (token != null) {
                revokeToken(token);
                return Response.status(Response.Status.OK).build();
            }
        } catch (Exception e) {
            return Response.serverError().build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    /*private Integer authenticate(String username, String password) {
        List<Utente> listaUtenti = UtenteManager.utenti;
        for(Utente utente : listaUtenti) {
            if(username.equals(utente.getUsername()) && password.equals(utente.getPassword())){
                return utente.getId();
            }
        }
        return null; // caso in cui l'AUTENTICAZIONE ha avuto SUCCESSO
    }*/
    
    private boolean authenticate(String username, String password) {
        if (username.equals("stefa") && password.equals("stefa")) return true;
        return false;
    }

    // metodo per generare il token
    private String issueToken(UriInfo context, String username) {
        String token = username + UUID.randomUUID().toString();
        //TokenManager.tokens.add(token);
        return token;
    }

    private void revokeToken(String token) {
        List<String> listaTokens = TokenManager.tokens; 
        Iterator<String> it = listaTokens.iterator();
        
        // rimuovo il token dalla lista di token presente in TokenManager
        while(it.hasNext()) {
            if(token.equals(it.next())) {
                it.remove();
            }
        }
    }
}
