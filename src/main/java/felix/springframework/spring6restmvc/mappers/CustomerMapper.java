package felix.springframework.spring6restmvc.mappers;

import felix.springframework.spring6restmvc.entities.Customer;
import felix.springframework.spring6restmvc.model.CustomerDTO;

import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper
{
    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDTO(Customer customer);
}
