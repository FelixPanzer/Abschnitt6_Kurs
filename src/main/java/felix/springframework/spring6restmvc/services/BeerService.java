package felix.springframework.spring6restmvc.services;

import java.util.UUID;
import felix.springframework.spring6restmvc.modul.Beer;

public interface BeerService
{
    Beer getBeerById(UUID id);
}
