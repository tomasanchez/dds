package quemepongo.services.accuweather;

import java.util.*;

/**
 * API de AccuWeather para obtener datos climáticos.
 *
 * @author Gastón Prieto
 * @since 05.26.2020
 */
public final class AccuWeatherAPI {

    private final Object epochDateTime = 1556856000;
    private final Object weatherIcon = 33;
    private final Object value = 57;
    private final Object unitType = 18;

    /**
     * Obtiene datos climáticos de una ciudad.
     *
     * @param ciudad la ciudad de la cual obtener datos climáticos
     * @return entrega una lista con el clima de las próximas 12 horas en un diccionario.
     */
    public List<Map<String, Object>> getWeather(String ciudad) {
        return Arrays.asList(new HashMap<String, Object>() {
            {
                put("DateTime", "2019-05-03T01:00:00-03:00");
                put("EpochDateTime", epochDateTime);
                put("WeatherIcon", weatherIcon);
                put("IconPhrase", "Clear");
                put("IsDaylight", false);
                put("PrecipitationProbability", 0);
                put("MobileLink", "http://m.accuweather.com/en/ar/villa-vil/7984/");
                put("Link", "http://www.accuweather.com/en/ar/villa-vil/7984");
                put("Temperature", new HashMap<String, Object>() {
                    {
                        put("Value", value);
                        put("Unit", "F");
                        put("UnitType", unitType);
                    }
                });
            }
        });
    }
}
