package felix.springframework.spring6restmvc.services.JPA;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import felix.springframework.spring6restmvc.mappers.BeerMapper;
import felix.springframework.spring6restmvc.model.BeerDTO;
import felix.springframework.spring6restmvc.repositories.BeerRepository;
import felix.springframework.spring6restmvc.services.beer.BeerService;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class BeerServiceJPA implements BeerService
{
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public List<BeerDTO> listBears()
    {
        return beerRepository.findAll()
            .stream()
            .map(beerMapper::beerToBeerDTO)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<BeerDTO> getBeerById(final UUID id)
    {
        return Optional.ofNullable(beerMapper.beerToBeerDTO(beerRepository.findById(id)
            .orElse(null)));
    }

    @Override
    public BeerDTO saveNewBeer(final BeerDTO beer)
    {
        return null;
    }

    @Override
    public void updateBeerById(final UUID beerId, final BeerDTO beer)
    {

    }

    @Override
    public void deleteById(final UUID beerId)
    {

    }

    @Override
    public void patchBeerById(final UUID beerId, final BeerDTO beer)
    {

    }
}
