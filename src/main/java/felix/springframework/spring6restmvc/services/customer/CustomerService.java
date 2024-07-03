package felix.springframework.spring6restmvc.services.customer;

import java.util.List;
import java.util.UUID;

import felix.springframework.spring6restmvc.model.CustomerDTO;

public interface CustomerService
{
    CustomerDTO getCustomerById(UUID uuid);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO saveNewCustomer(CustomerDTO customer);

    void updateCustomerById(UUID customerId, CustomerDTO customer);

    void deleteById(UUID customerId);

    void patchCustomerById(UUID customerId, CustomerDTO customer);
}

//2.Schritt