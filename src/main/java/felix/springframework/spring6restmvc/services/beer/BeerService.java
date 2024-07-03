package felix.springframework.spring6restmvc.services.beer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import felix.springframework.spring6restmvc.entities.Beer;
import felix.springframework.spring6restmvc.model.BeerDTO;

public interface BeerService
{
    List<BeerDTO> listBears(); //von BeerServiceimpl

    Optional<BeerDTO> getBeerById(UUID id);

    BeerDTO saveNewBeer(BeerDTO beer);

    void updateBeerById(UUID beerId, BeerDTO beer);

    void deleteById(UUID beerId);

    void patchBeerById(UUID beerId, BeerDTO beer);
}
