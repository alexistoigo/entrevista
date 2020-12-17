package br.com.entrevista.Services;

import br.com.entrevista.entities.Cities;
import br.com.entrevista.entities.Client;

import java.util.List;

public interface ClientService {

    void save(Client client);

    Client findById(Long id);

    List<Client> findByName(String name);

    List<Client> findAll();

    void removeById(Long id);

}
