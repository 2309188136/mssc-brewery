package guru.springframework.msscbrewery.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    //@JsonProperty("beerId") //annotation takes precedence over naming strategy used in config file
    @Null //disallow user set id
    private UUID id;

    @Null
    private Integer version;
    @NotBlank
    private String beerName;

    @JsonFormat(pattern = "yyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING) //serialize
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class) //deserialize
    @Null
    private OffsetDateTime createdDate; //based on UTC date
    @Null
    private OffsetDateTime lastModifiedDate;
    @NotNull
    private BeerStyleEnum beerStyleEnum;
    @Positive
    @NotNull
    private Long upc; //universal product code

    @Positive
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;
    private Integer quantityAtHand;

    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate localDate;
}
