package felix.springframework.spring6restmvc.repositories;

import java.util.UUID;

import felix.springframework.spring6restmvc.entities.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, UUID>
{
}
