package br.com.entrevista.Services;

import br.com.entrevista.Repositories.ClientRepository;
import br.com.entrevista.entities.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;

    @Override
    public void save(Client client) {
        this.clientRepository.save(client);
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> o = this.clientRepository.findById(id);

        return o.get();
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();

        for (Client client : this.clientRepository.findAll()) {
            clients.add(client);
        }
        return clients;
    }

    @Override
    public List<Client> findByName(String name) {
        return this.clientRepository.findByName(name);
    }

    @Override
    public void removeById(Long id) {
        this.clientRepository.deleteById(id);
    }
}
