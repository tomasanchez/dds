package quemepongo.model.clima;

import quemepongo.service.clima.AccuWeatherAPI;
import quemepongo.service.clima.ClimaService;

/**
 * Reporte del clima en Bunos Aires.
 *
 * @since 05.17.2021
 * @version 1.0
 */
public class Pronostico {

    private ClimaService service;

    /**
     * Instancia un pronostico utilizando el default service.
     *
     * @since Iteración IV
     */
    public Pronostico() {
        this(new AccuWeatherAPI());
    }

    /**
     * Instancia un pronostico con el serivicio indicado.
     *
     * @param service servicio de consultas climáticas.
     * @since Iteración IV
     */
    public Pronostico(ClimaService service) {
        this.service = service;
    }

    /**
     * Obtiene el pronostico para la ciudad de Buenos Aires.
     *
     * @return el pronostico según el servicio utilizado.
     */
    public Object getBuenosAires() {
        return this.service.getWeatherForBuenosAires();
    }

    public ClimaService getService() {
        return service;
    }
}
