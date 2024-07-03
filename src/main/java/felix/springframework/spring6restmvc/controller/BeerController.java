package felix.springframework.spring6restmvc.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import felix.springframework.spring6restmvc.model.BeerDTO;
import felix.springframework.spring6restmvc.services.beer.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController //Returns back response body
//@RequestMapping("/api/v1/beer")
public class BeerController
{
    public static final String BEER_PATH = "/api/v1/beer/";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";

    private final BeerService beerService;


    @PatchMapping(BEER_PATH_ID)
    public ResponseEntity updateBeerPatchById(@PathVariable("beerId") UUID beerId,@RequestBody BeerDTO beer){

        beerService.patchBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }


    @DeleteMapping(BEER_PATH_ID)
    public ResponseEntity deleteById(@PathVariable("beerId") UUID beerId){

        beerService.deleteById(beerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(BEER_PATH_ID) //for PUT
    public ResponseEntity updateById(@PathVariable("beerId") UUID beerId,@RequestBody BeerDTO beer) {

    beerService.updateBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(BEER_PATH) //Request mapping of post
//    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePost(@RequestBody BeerDTO beer) //Request body to not get null with postman
    {
        BeerDTO savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString()); //adding the headers and binding it
        // to new ResponseEntity

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    //@RequestMapping(method = RequestMethod.GET) //path to list of beers
    @GetMapping(value = BEER_PATH)
    public List<BeerDTO> listBeers()
    { //list beers gets converted to JSON
        return beerService.listBears();
    }

    //@RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    @GetMapping(value = BEER_PATH_ID)
    public BeerDTO getBeerById(@PathVariable("beerId") UUID beerID) {

        log.debug("Get Beer by Id - in controller -1234 asdf");

        return beerService.getBeerById(beerID).orElseThrow(NotFoundException::new );
    }
}




