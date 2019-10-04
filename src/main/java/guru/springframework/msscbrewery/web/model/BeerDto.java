package guru.springframework.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @Null //disallow user set id
    private UUID id;

    @Null
    private Integer version;
    @NotBlank
    private String beerName;

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
    private BigDecimal price;
    private Integer quantityAtHand;
}
