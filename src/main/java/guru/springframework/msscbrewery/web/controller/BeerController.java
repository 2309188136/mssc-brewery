package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;




@Validated //annotation marked to validate method input parameters
@RequestMapping("/api/v1/beer")
@RestController
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService; //@requiredArgsConstructor automatically wire in the dependency marked by final modifier thus no need for constructor

    //if you validation for controller method input parameters you need annotate class with @Validated annotation
    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@NotNull @PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping //POST - create new beer
    public ResponseEntity handlePost(@Valid @NotNull @RequestBody BeerDto beerDto){
        return  new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping(value = {"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto){
        return new ResponseEntity<>(beerService.updateBeer(beerId,beerDto),HttpStatus.OK);
    }

    @DeleteMapping(value = {"/{beerId}"})
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteById(beerId);
    }

    @GetMapping(path = {"beerUpc/{upc}"}, produces = { "application/json" })
    public ResponseEntity<BeerDto>  getBeerByUpc(@PathVariable("upc") String upc){
        return new ResponseEntity<>(beerService.findBeerByUpc(upc), HttpStatus.OK);
    }

}
