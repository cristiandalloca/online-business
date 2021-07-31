package br.com.cdb.core.model.city.repository;

import br.com.cdb.core.model.city.City;
import br.com.cdb.core.enviroment.CitiesEnviroment;
import br.com.cdb.core.enviroment.StatesEnviroment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CityRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CityRepository repository;

    @Test
    void shouldInsertANewCityAndState() {
        entityManager.persist(CitiesEnviroment.cityOfSaoPaulo());

        List<City> cities = repository.findAllByNameContaining("São Paulo");

        assertCityOfSaoPaulo(cities);
    }

    @Test
    void shouldUpdateAnExistingCity() {
        Long id = entityManager.persist(CitiesEnviroment.cityOfSaoPaulo()).getId();
        assertNotNull(id);

        City city = repository.findById(id).orElseThrow();
        assertCityOfSaoPaulo(Collections.singletonList(city));
        city.setState(StatesEnviroment.stateOfRioGrandeDoSul());

        City updatedCity = repository.save(city);

        assertNotNull(updatedCity);
        assertNotNull(updatedCity.getState());
        assertEquals("Rio Grande do Sul", updatedCity.getState().getName());
        assertEquals("RS", updatedCity.getState().getAcronym());
    }

    @Test
    void shouldDeleteAnExistingCity() {
        Long id = entityManager.persist(CitiesEnviroment.cityOfSaoPaulo()).getId();
        assertNotNull(id);

        City city = repository.findById(id).orElseThrow();
        assertCityOfSaoPaulo(Collections.singletonList(city));

        repository.deleteById(id);

        Optional<City> cityDeleted = repository.findById(id);
        assertFalse(cityDeleted.isPresent());
    }

    private void assertCityOfSaoPaulo(List<City> cities) {
        assertFalse(cities.isEmpty());
        assertNotNull(cities.get(0).getId());
        assertEquals("São Paulo", cities.get(0).getName());
        assertEquals("São Paulo", cities.get(0).getState().getName());
        assertEquals("SP", cities.get(0).getState().getAcronym());
    }
}