package guru.springframework.msscbrewery.web.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
    }

    @Test
    void testSerializedDto() throws JsonProcessingException {
        BeerDto beerDto = super.getDto();
        String jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println(jsonString);
    }

    @Test
    void testDeserializeJsonToDto() throws IOException {
        String strJosn="{\"id\":\"7770000d-0953-4430-aaf0-1456e26a354d\",\"version\":null,\"beerName\":\"BeerName\",\"createdDate\":\"2019-10-03T22:22:42.3104719-05:00\",\"lastModifiedDate\":\"2019-10-03T22:22:42.3114995-05:00\",\"beerStyleEnum\":\"IPA\",\"upc\":123123123123,\"price\":12.99,\"quantityAtHand\":null}";
        BeerDto dto = objectMapper.readValue(strJosn, BeerDto.class);
        System.out.println(dto);
    }


//    @Test
//    void getId() {
//    }
//
//    @Test
//    void getVersion() {
//    }
//
//    @Test
//    void getBeerName() {
//    }
//
//    @Test
//    void getCreateDate() {
//    }
//
//    @Test
//    void getLastModifiedDate() {
//    }
//
//    @Test
//    void getUpc() {
//    }
//
//    @Test
//    void getPrice() {
//    }
//
//    @Test
//    void getQuantityAtHand() {
//    }
}