package felix.springframework.spring6restmvc.services.beer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import felix.springframework.spring6restmvc.model.BeerDTO;
import felix.springframework.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService
{
    private Map<UUID, BeerDTO> beerMap;

     public BeerServiceImpl()
     {
         this.beerMap = new HashMap<>();

         BeerDTO beer1 = BeerDTO.builder()
             .id(UUID.randomUUID())
             .version(1)
             .beerName("GalaxyCat")
             .beerStyle(BeerStyle.PALE_ALE)
             .upc("123456")
             .price(new BigDecimal("12.99"))
             .quantityOnHand(122)
             .createdDate(LocalDateTime.now())
             .updateDate(LocalDateTime.now())
             .build();

         BeerDTO beer2 = BeerDTO.builder()
             .id(UUID.randomUUID())
             .version(1)
             .beerName("Crank")
             .beerStyle(BeerStyle.PALE_ALE)
             .upc("123456222")
             .price(new BigDecimal("11.99"))
             .quantityOnHand(392)
             .createdDate(LocalDateTime.now())
             .updateDate(LocalDateTime.now())
             .build();

         BeerDTO beer3 = BeerDTO.builder()
             .id(UUID.randomUUID())
             .version(1)
             .beerName("Sunshine City")
             .beerStyle(BeerStyle.IPA)
             .upc("123456")
             .price(new BigDecimal("13.99"))
             .quantityOnHand(144)
             .createdDate(LocalDateTime.now())
             .updateDate(LocalDateTime.now())
             .build();

         beerMap.put(beer1.getId(), beer1); //Setting keys to id value to each beer
         beerMap.put(beer2.getId(), beer2);
         beerMap.put(beer3.getId(), beer3);

     }

     @Override
     public List<BeerDTO> listBears() {
         return new ArrayList<>(beerMap.values());
     }


    @Override
    public Optional<BeerDTO> getBeerById(final UUID id)
    {
        log.debug("Get Beer by Id - in service. Id: " + id.toString());

        return Optional.of(beerMap.get(id));
    }

    @Override
    public BeerDTO saveNewBeer(final BeerDTO beer)
    {

        BeerDTO savedBeer = BeerDTO.builder()
            .id(UUID.randomUUID())
            .createdDate(LocalDateTime.now())
            .updateDate(LocalDateTime.now())
            .beerName(beer.getBeerName())
            .beerStyle(beer.getBeerStyle())
            .quantityOnHand(beer.getQuantityOnHand())
            .upc(beer.getUpc())
            .price(beer.getPrice())
            .build();

        beerMap.put(savedBeer.getId(), savedBeer);

        return savedBeer;
    }

    @Override
    public void updateBeerById(final UUID beerId, final BeerDTO beer)
    {
        BeerDTO existing = beerMap.get(beerId);
        existing.setBeerName(beer.getBeerName());
        existing.setPrice(beer.getPrice());
        existing.setUpc(beer.getUpc());
        existing.setQuantityOnHand(beer.getQuantityOnHand());

        beerMap.put(existing.getId(), existing);
    }

    @Override
    public void deleteById(final UUID beerId)
    {
        beerMap.remove(beerId);
    }

    @Override
    public void patchBeerById(final UUID beerId, final BeerDTO beer) //ohne das wirds in postman nicht geupdated
    {
        BeerDTO existing = beerMap.get(beerId);

        if(StringUtils.hasText(beer.getBeerName())){
            existing.setBeerName(beer.getBeerName());
        }

        if(beer.getBeerStyle() !=null){
            existing.setBeerStyle(beer.getBeerStyle());
        }

        if(beer.getPrice() != null) {
            existing.setPrice(beer.getPrice());
        }

        if(beer.getQuantityOnHand() != null) {
            existing.setQuantityOnHand(beer.getQuantityOnHand());
        }

        if(StringUtils.hasText(beer.getUpc())){
            existing.setUpc(beer.getUpc());
        }

    }
}
