package felix.springframework.spring6restmvc.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import felix.springframework.spring6restmvc.modul.Beer;
import felix.springframework.spring6restmvc.modul.BeerStyle;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService
{
    @Override
    public Beer getBeerById(final UUID id)
    {
        log.debug("Get Beer by Id - in service. Id: " + id.toString());

        return Beer.builder()
            .id(id)
            .version(1)
            .beerName("GalaxyCat")
            .beerStyle(BeerStyle.PALE_ALE)
            .upc("123456")
            .price(new BigDecimal("12.99"))
            .quantityOnHand(122)
            .createdDate(LocalDateTime.now())
            .updateDate(LocalDateTime.now())
            .build();
    }
}
