package br.com.entrevista.Services;

import br.com.entrevista.entities.Cities;

import java.util.List;

public interface CitiesService {

    void save(Cities cities);

    Cities findById(Long id);

    List<Cities> findByUf(String uf);

    List<Cities> findByCity(String city);

    List<Cities> findAll();

    void removeById(Long id);
}
