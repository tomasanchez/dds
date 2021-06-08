package quemepongo.api.clima.accuweather;

import quemepongo.model.clima.CondicionClimatica;
import quemepongo.service.clima.ServicioMetereologico;

public class AccuWeatherAdapter implements ServicioMetereologico {

    @Override
    public CondicionClimatica getCondicionClimatica(String localidad) {
        return null;
    }

}
