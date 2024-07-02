package felix.springframework.spring6restmvc.services.beer;

import java.util.List;
import java.util.UUID;
import felix.springframework.spring6restmvc.model.Beer;

public interface BeerService
{
    List<Beer> listBears(); //von BeerServiceimpl

    Beer getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID beerId, Beer beer);

    void deleteById(UUID beerId);

    void patchBeerById(UUID beerId, Beer beer);
}
