package quemepongo.service.clima;

/**
 * Servicios de Clima que pueden utilizarse.
 *
 * @author Tomás Sánchez
 * @since 05.26.2021
 */
public interface ClimaService {
    /**
     * Obtiene datos climáticos de una ciudad.
     *
     * @param localidad la ciudad de la cual obtener datos climáticos
     * @return entrega una lista con el clima de las próximas 12 horas en un diccionario.
     */
    Object getWeather(String localidad);


    /**
     * Obtiene datos climáticos de la Ciudad de Buenos Aires.
     *
     * @return las condiciones climáticas en las próximas 12.
     */
    Object getWeatherForBuenosAires();
}
