package org.univaq.swa.sdv.sdvrest.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.*;

/**
 *
 * @author nicola
 */
public class JavaLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        
       String localDateAsString = "";
       int year = localDateTime.getYear();
       int month = localDateTime.getMonthValue();
       int day = localDateTime.getDayOfMonth();
       
       int hour = localDateTime.getHour();
       int minute = localDateTime.getMinute();
       
       localDateAsString = year + "-" + month + "-" + day + " " + hour + ":" + minute;
       
       jsonGenerator.writeString(localDateAsString);
       
    }
}