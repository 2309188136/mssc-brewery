package guru.springframework.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private String beerName;
    @NotBlank
    private String beerStyle;
    private OffsetDateTime createDate; //based on UTC date
    private OffsetDateTime lastModifiedDate;
    private BeerStyleEnum beerStyleEnum;
    @Positive
    private Long upc; //universal product code
    private BigDecimal price;
    private Integer quantityAtHand;
}
