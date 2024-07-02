package felix.springframework.spring6restmvc.services.customer;

import java.util.List;
import java.util.UUID;

import felix.springframework.spring6restmvc.model.Customer;

public interface CustomerService
{
    Customer getCustomerById(UUID uuid);

    List<Customer> getAllCustomers();

    Customer saveNewCustomer(Customer customer);

    void updateCustomerById(UUID customerId, Customer customer);

    void deleteById(UUID customerId);

    void patchCustomerById(UUID customerId, Customer customer);
}

//2.Schritt