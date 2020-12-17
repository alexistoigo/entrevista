package br.com.entrevista.Repositories;

import br.com.entrevista.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findByName(String name);

}
