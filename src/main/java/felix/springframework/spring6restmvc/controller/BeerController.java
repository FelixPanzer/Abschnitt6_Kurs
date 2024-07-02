package felix.springframework.spring6restmvc.controller;

import java.util.List;
import java.util.UUID;

import felix.springframework.spring6restmvc.model.Beer;
import felix.springframework.spring6restmvc.services.beer.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController //Returns back response body
@RequestMapping("/api/v1/beer")
public class BeerController
{
    private final BeerService beerService;


    @PatchMapping("{beerId}")
    public ResponseEntity updateBeerPatchById(@PathVariable("beerId") UUID beerId,@RequestBody Beer beer){

        beerService.patchBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }


    @DeleteMapping("{beerId}")
    public ResponseEntity deleteById(@PathVariable("beerId") UUID beerId){

        beerService.deleteById(beerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{beerId}") //for PUT
    public ResponseEntity updateById(@PathVariable("beerId") UUID beerId,@RequestBody Beer beer) {

    beerService.updateBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping //Request mapping of post
//    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePost(@RequestBody Beer beer) //Request body to not get null with postman
    {
        Beer savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString()); //adding the headers and binding it
        // to new ResponseEntity

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET) //path to list of beers
    public List<Beer> listBeers() { //list beers gets converted to JSON
        return beerService.listBears();
    }

    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beerId") UUID beerID) {

        log.debug("Get Beer by Id - in controller -1234 asdf");

        return beerService.getBeerById(beerID);
    }
}




