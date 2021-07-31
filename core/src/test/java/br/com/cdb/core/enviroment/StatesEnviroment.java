package br.com.cdb.core.enviroment;

import br.com.cdb.core.model.state.State;

public class StatesEnviroment {

    public static State stateOfRioGrandeDoSul() {
        State state = new State();
        state.setName("Rio Grande do Sul");
        state.setAcronym("RS");
        return state;
    }
}
