package felix.springframework.spring6restmvc.mappers;

import felix.springframework.spring6restmvc.entities.Beer;
import felix.springframework.spring6restmvc.model.BeerDTO;

import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper
{

    Beer beerDtotoBeer(BeerDTO dto);

    BeerDTO beerToBeerDTO(Beer beer);
}
