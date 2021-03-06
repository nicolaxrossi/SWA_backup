
package org.univaq.swa.sdv.sdvrest.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.time.*;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;
import org.univaq.swa.sdv.sdvrest.model.Messaggio;

/**
 *
 * @author didattica
 */
@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper;

    public ObjectMapperContextResolver() {
        this.mapper = createObjectMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }

    private ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        //abilitiamo una feature nuova...
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleModule customSerializer = new SimpleModule("CustomSerializersModule");

        //configuriamo i nostri serializzatori custom
        //customSerializer.addSerializer(Calendar.class, new JavaCalendarSerializer());
        //customSerializer.addDeserializer(Calendar.class, new JavaCalendarDeserializer());
        customSerializer.addSerializer(LocalDateTime.class, new JavaLocalDateTimeSerializer());
        customSerializer.addDeserializer(LocalDateTime.class, new JavaLocalDateTimeDeserializer());
        
        mapper.registerModule(customSerializer);

        return mapper;
    }
}
