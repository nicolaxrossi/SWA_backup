package org.univaq.swa.sdv.sdvrest.security;

import java.io.IOException;
import java.security.Principal;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.Provider;
import org.univaq.swa.sdv.sdvrest.data.TokenManager;

/**
 *
 * @author didattica
 */
@Provider
@Logged
@Priority(Priorities.AUTHENTICATION)
public class LoggedFilter implements ContainerRequestFilter {

    @Context
    UriInfo uriInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {        
        String token = null;
        final String path = requestContext.getUriInfo().getAbsolutePath().toString();
        
        // controllo se è presente il token all'intero dell'AUTORIZATION HEADER
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring("Bearer".length()).trim();
       
        if (token != null && !token.isEmpty()) {
            try {
                final Integer userID = validateToken(token);
                if (userID != null) {
                    //inseriamo nel contesto i risultati dell'autenticazione
                    //per farli usare dai nostri metodi restful
                    //iniettando @Context ContainerRequestContext
                    requestContext.setProperty("token", token);
                    requestContext.setProperty("IDutente", userID);
                    /*
                    //OPPURE
                    // https://dzone.com/articles/custom-security-context-injax-rs
                    //mettiamo i dati anche nel securitycontext standard di JAXRS...
                    //che può essere iniettato con @Context SecurityContext nei metodi
                    //final SecurityContext originalSecurityContext = requestContext.getSecurityContext();
                    requestContext.setSecurityContext(new SecurityContext() {
                        @Override
                        public Principal getUserPrincipal() {
                            return new Principal() {
                                @Override
                                public String getName() {
                                    return user;
                                }
                            };
                        }
                        @Override
                        public boolean isUserInRole(String role) {
                            //qui andrebbe verificato se l'utente ha il ruolo richiesto
                            return true;
                        }
                        @Override
                        public boolean isSecure() {                            
                            return path.startsWith("https");
                        }
                        @Override
                        public String getAuthenticationScheme() {
                            return "Token-Based-Auth-Scheme";
                        }
                    }); */

                } else {
                    //se non va bene... 
                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
                }
            } catch (Exception e) {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }
        } else {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
        }
    }

    private Integer validateToken(String token) {
        int userID;

        for(String t : TokenManager.tokens)
            if (t.equals(token)) {
                // il token è stato definito come concatenazione di un UUID (stringa fissa di 36 caratteri) e di un userID: per questo
                // motivo lo userID coincide con la sottostringa di token che inizia dal suo 35° carattere e che finisce con l'ultimo 
                // carattere del token
                userID = Integer.parseInt(token.substring(35, token.length() - 1));
                return userID; // caso in cui il token è valido e quindi è possibile estrarre lo userID dell'Utente 
            }
        return null; // caso in cui il token non è stato trovato all'interno del TokenManager
    }

}
