package guru.springframework.msscbrewery.repositories;

import guru.springframework.msscbrewery.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;
//No need to annotate @Repository to BeerResitory, since it's already defined as repository
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
