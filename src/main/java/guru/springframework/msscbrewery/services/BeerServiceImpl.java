package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.repositories.BeerRepository;
import guru.springframework.msscbrewery.web.controller.NotFoundException;
import guru.springframework.msscbrewery.web.mappers.BeerMapper;
import guru.springframework.msscbrewery.web.model.BeerDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;
    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());
        return  beerMapper.beerToBeerDto(beerRepository.save(beer));
    }

    @Override
    public BeerDto getBeerById(UUID beerId) {
       return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting a beer...");
    }

    @Override
    public BeerDto findBeerByUpc(String upc) {
        return null;
//        return beerMapper.beerToBeerDto(beerRepository.findByUpc(upc));
    }



}
