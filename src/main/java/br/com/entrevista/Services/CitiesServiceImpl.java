package br.com.entrevista.Services;

import br.com.entrevista.Repositories.CitiesRepository;
import br.com.entrevista.entities.Cities;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CitiesServiceImpl implements CitiesService {

    private CitiesRepository citiesRepository;

    @Override
    public void save(Cities cities) {
        this.citiesRepository.save(cities);
    }

    @Override
    public Cities findById(Long id) {
        Optional<Cities> optionalCities = this.citiesRepository.findById(id);

        return optionalCities.get();
    }

    @Override
    public List<Cities> findAll() {
        List<Cities> cities = new ArrayList<>();

        for (Cities value : this.citiesRepository.findAll()) {
            cities.add(value);
        }
        return cities;
    }

    @Override
    public void removeById(Long id) {
        this.citiesRepository.deleteById(id);
    }
}
