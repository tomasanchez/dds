package quemepongo.service.clima;

import java.util.List;
import quemepongo.api.clima.accuweather.AccuWeatherAdapter;
import quemepongo.model.clima.AlertaClimatica;
import quemepongo.model.clima.CondicionClimatica;

/**
 * Servicios de Clima que pueden utilizarse.
 *
 * @author Tomás Sánchez
 * @since 05.26.2021
 */
public interface ServicioMetereologico {

    /**
     * Obtiene datos climáticos de una ciudad.
     *
     * @param localidad la ciudad de la cual obtener datos climáticos
     * @return las condiciones climaticas actuales.
     * @since Iteration IV
     */
    CondicionClimatica getCondicionClimatica(String localidad);

    /**
     * Obtiene las alertas climaticas de una ciudad.
     *
     * @param localidad la ciudad de la cual obtener datos climáticos
     * @return un listado de alertas actuales
     * @since Iteration VI
     */
    List<AlertaClimatica> getAlertas(String localidad);

    /**
     * Obtiene el servicio meteorologico actual.
     *
     * @return el serivicio por default
     */
    static ServicioMetereologico defaultService() {
        return new AccuWeatherAdapter();
    }
}
