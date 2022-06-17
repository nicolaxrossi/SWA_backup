package org.univaq.swa.sdv.sdvrest;

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.univaq.swa.sdv.sdvrest.jackson.ObjectMapperContextResolver;
import org.univaq.swa.sdv.sdvrest.resources.MessaggiResource;
import org.univaq.swa.sdv.sdvrest.resources.ProgettiResource;
import org.univaq.swa.sdv.sdvrest.resources.ProgettoResource;
import org.univaq.swa.sdv.sdvrest.resources.TasksResource;
import org.univaq.swa.sdv.sdvrest.resources.UtenteResource;
import org.univaq.swa.sdv.sdvrest.security.AppExceptionMapper;
import org.univaq.swa.sdv.sdvrest.security.CORSFilter;
import org.univaq.swa.sdv.sdvrest.resources.UtentiResource;
import org.univaq.swa.sdv.sdvrest.security.AutenticazioneResource;

/**
 *
 * @author didattica
 */
@ApplicationPath("rest")
public class RESTApp extends Application {

    private final Set<Class<?>> classes;

    public RESTApp() {
        HashSet<Class<?>> c = new HashSet<Class<?>>();
        //aggiungiamo tutte le *root resurces* (cioè quelle
        //con l'annotazione Path) che vogliamo pubblicare
        c.add(UtentiResource.class);
        //c.add(UtenteResource.class);
        c.add(ProgettiResource.class);
        //c.add(ProgettoResource.class);
        //c.add(MessaggiResource.class);
        //c.add(TasksResource.class);
        c.add(AutenticazioneResource.class);

        //aggiungiamo il provider Jackson per poter
        //usare i suoi servizi di serializzazione e 
        //deserializzazione JSON
        c.add(JacksonJsonProvider.class);

        //necessario se vogliamo una (de)serializzazione custom di qualche classe    
        c.add(ObjectMapperContextResolver.class);

        //esempio di autenticazione
        //c.add(AuthLevel1Filter.class);
        //aggiungiamo il filtro che gestisce gli header CORS
        c.add(CORSFilter.class);

        //esempio di exception mapper, che mappa in Response eccezioni non già derivanti da WebApplicationException
        c.add(AppExceptionMapper.class);

        classes = Collections.unmodifiableSet(c);
    }

    //l'override di questo metodo deve restituire il set
    //di classi che Jersey utilizzerà per pubblicare il
    //servizio. Tutte le altre, anche se annotate, verranno
    //IGNORATE
    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
