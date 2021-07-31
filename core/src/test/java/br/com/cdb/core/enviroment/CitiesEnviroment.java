package br.com.cdb.core.enviroment;

import br.com.cdb.core.model.city.City;
import br.com.cdb.core.model.state.State;

public class CitiesEnviroment {

    public static City cityOfSaoPaulo() {
        State state = new State();
        state.setName("São Paulo");
        state.setAcronym("SP");

        City city = new City();
        city.setName("São Paulo");
        city.setState(state);
        return city;
    }
}
