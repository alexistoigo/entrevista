package br.com.entrevista.Repositories;

import br.com.entrevista.entities.Cities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitiesRepository extends CrudRepository<Cities, Long> {

    List<Cities> findByUf(String uf);

    List<Cities> findByCity(String city);
}
