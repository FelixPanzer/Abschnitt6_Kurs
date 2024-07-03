package felix.springframework.spring6restmvc.services.JPA;

import java.util.List;
import java.util.UUID;

import felix.springframework.spring6restmvc.mappers.CustomerMapper;
import felix.springframework.spring6restmvc.model.CustomerDTO;
import felix.springframework.spring6restmvc.repositories.CustomerRepository;
import felix.springframework.spring6restmvc.services.customer.CustomerService;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService
{
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO getCustomerById(final UUID uuid)
    {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers()
    {
        return List.of();
    }

    @Override
    public CustomerDTO saveNewCustomer(final CustomerDTO customer)
    {
        return null;
    }

    @Override
    public void updateCustomerById(final UUID customerId, final CustomerDTO customer)
    {

    }

    @Override
    public void deleteById(final UUID customerId)
    {

    }

    @Override
    public void patchCustomerById(final UUID customerId, final CustomerDTO customer)
    {

    }
}
