package felix.springframework.spring6restmvc.services.customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import felix.springframework.spring6restmvc.model.CustomerDTO;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CustomerServiceImpl implements CustomerService
{
    private Map<UUID, CustomerDTO> customerMap;

    public CustomerServiceImpl()
    {
        CustomerDTO customer1 = CustomerDTO.builder()
            .id(UUID.randomUUID())
            .name("Customer 1")
            .version(1)
            .createdDate(LocalDateTime.now())
            .updateDate(LocalDateTime.now())
            .build();


        CustomerDTO customer2 = CustomerDTO.builder()
            .id(UUID.randomUUID())
            .name("Customer 2")
            .version(1)
            .createdDate(LocalDateTime.now())
            .updateDate(LocalDateTime.now())
            .build();


        CustomerDTO customer3 = CustomerDTO.builder()
            .id(UUID.randomUUID())
            .name("Customer 3")
            .version(1)
            .createdDate(LocalDateTime.now())
            .updateDate(LocalDateTime.now())
            .build();

        customerMap = new HashMap<>();
        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);

    }

    @Override
    public CustomerDTO getCustomerById(final UUID uuid)
    {
        return customerMap.get((UUID) uuid);
    }

    @Override
    public List<CustomerDTO> getAllCustomers()
    {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public CustomerDTO saveNewCustomer(final CustomerDTO customer)
    {
        CustomerDTO savedCustomer = CustomerDTO.builder()
            .id(UUID.randomUUID())
            .version(1)
            .updateDate(LocalDateTime.now())
            .createdDate(LocalDateTime.now())
            .name(customer.getName())
            .build();

        customerMap.put(savedCustomer.getId(), savedCustomer);

        return savedCustomer;
    }

    @Override
    public void updateCustomerById(final UUID customerId, final CustomerDTO customer)
    {
        CustomerDTO existing = customerMap.get(customerId);
        existing.setName(customer.getName());
        existing.setVersion(customer.getVersion());
        existing.setCreatedDate(customer.getCreatedDate());
        existing.setUpdateDate(customer.getUpdateDate());

        //customerMap.put(customerId, customer);

    }

    @Override
    public void deleteById(final UUID customerId)
    {
        customerMap.remove(customerId);
    }

    @Override
    public void patchCustomerById(final UUID customerId, final CustomerDTO customer)
    {
        CustomerDTO existing = customerMap.get(customerId);

        if(StringUtils.hasText(customer.getName())){
            existing.setName(customer.getName());
        }

    }
}

//3.Schritt