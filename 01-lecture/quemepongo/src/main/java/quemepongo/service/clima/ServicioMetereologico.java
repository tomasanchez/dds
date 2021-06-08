package quemepongo.service.clima;

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
     * @return entrega una lista con el clima de las próximas 12 horas en un diccionario.
     */
    CondicionClimatica getCondicionClimatica(String localidad);
}
