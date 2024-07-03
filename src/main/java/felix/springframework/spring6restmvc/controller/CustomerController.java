package felix.springframework.spring6restmvc.controller;

import java.util.List;
import java.util.UUID;

import felix.springframework.spring6restmvc.model.CustomerDTO;
import felix.springframework.spring6restmvc.services.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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

@Slf4j //ist für log.debug
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
@RestController
public class CustomerController
{
    private final CustomerService customerService;

    @PatchMapping("{customerId}")
    public ResponseEntity updateCustomerPatchById(@PathVariable("customerId") UUID customerId,
        @RequestBody CustomerDTO customer){

        customerService.patchCustomerById(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity deleteById(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDTO customer) {


        customerService.deleteById(customerId);


        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{customerId}") //Limits the method to only respond to HTTP PUT
    public ResponseEntity updateById(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDTO customer){

        customerService.updateCustomerById(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDTO customer){
        CustomerDTO savedCustomer = customerService.saveNewCustomer(customer); //new customer object

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + savedCustomer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CustomerDTO> listAllCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping("/{customerId}")
    public CustomerDTO getCustomerById(@PathVariable("customerId") UUID id) {

        log.debug("Get Customer by Id - in controller ");

        return customerService.getCustomerById(id);
    }

}

//4.Schritt