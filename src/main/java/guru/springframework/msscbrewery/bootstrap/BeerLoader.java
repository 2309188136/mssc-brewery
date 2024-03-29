package guru.springframework.msscbrewery.bootstrap;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.repositories.BeerRepository;
import guru.springframework.msscbrewery.web.model.BeerStyleEnum;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;

//class marked by CommandLineRunner runs when spring context starts
//@Component //replaced with embedded data sql bootstrap
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";
    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {

        if(beerRepository.count()>0) return;

        beerRepository.save(Beer.builder().beerName("Mango Bobs").beerStyle(BeerStyleEnum.IPA)
                    .quantityToBrew(200).upc(BEER_1_UPC).price(new BigDecimal("12.95")).build());
        beerRepository.save(Beer.builder().beerName("Galaxy Cat").beerStyle(BeerStyleEnum.PALE_ALE)
                    .quantityToBrew(200).upc(BEER_2_UPC).price(new BigDecimal("11.95")).build());

        beerRepository.save(Beer.builder().beerName("Corona").beerStyle(BeerStyleEnum.WHEAT)
                .quantityToBrew(200).upc(BEER_3_UPC).price(new BigDecimal("9.95")).build());
    }
}
