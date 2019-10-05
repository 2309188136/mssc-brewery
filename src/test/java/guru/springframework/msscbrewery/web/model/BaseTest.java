package guru.springframework.msscbrewery.web.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbrewery.bootstrap.BeerLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    BeerDto getDto(){
        return  BeerDto.builder()
                .beerName("BeerName")
                .beerStyle(BeerStyleEnum.IPA)
                .id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .price(new BigDecimal("12.99"))
                .upc(BeerLoader.BEER_1_UPC).localDate(LocalDate.now())
                .build();
    }
}
