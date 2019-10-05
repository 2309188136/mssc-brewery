package guru.springframework.msscbrewery.web.model;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class OffsetDateTimeDeserializer  extends StdDeserializer<OffsetDateTime> {

    public OffsetDateTimeDeserializer(){
        super(OffsetDateTime.class);

    }

    @Override
    public OffsetDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value =p.readValueAs(String.class);
//        LocalDateTime localDateTime= LocalDateTime.parse("yyy-MM-dd'T'HH:mm:ss");
        LocalDateTime localDateTime= LocalDateTime.parse(value, DateTimeFormatter.ofPattern("yyy-MM-dd'T'HH:mm:ss"));
        ZoneOffset offset = OffsetDateTime.now().getOffset();
        OffsetDateTime offsetDateTime = localDateTime.atOffset(offset);
        return offsetDateTime;
    }
}
