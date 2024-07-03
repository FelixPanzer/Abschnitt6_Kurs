package felix.springframework.spring6restmvc.repositories;

import java.util.UUID;

import felix.springframework.spring6restmvc.entities.Beer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, UUID>
{
}
