package quemepongo.api.clima.accuweather;

import java.util.*;

/**
 * API de AccuWeather para obtener datos climáticos.
 *
 * @author Gastón Prieto
 * @since 05.26.2020
 */
public final class AccuWeatherAPI {

    private final Object epochDateTime = 1556856000;
    private final Object clear = 33;
    private final Object value = 57;
    private final Object fahrenheit = 18;

    public List<Map<String, Object>> getWeather(String ciudad) {
        return Arrays.asList(new HashMap<String, Object>() {
            {
                put("DateTime", "2019-05-03T01:00:00-03:00");
                put("EpochDateTime", epochDateTime);
                put("WeatherIcon", clear);
                put("IconPhrase", "Clear");
                put("IsDaylight", false);
                put("PrecipitationProbability", 0);
                put("MobileLink", "http://m.accuweather.com/en/ar/villa-vil/7984/");
                put("Link", "http://www.accuweather.com/en/ar/villa-vil/7984");
                put("Temperature", new HashMap<String, Object>() {
                    {
                        put("Value", value);
                        put("Unit", "F");
                        put("UnitType", fahrenheit);
                    }
                });
            }
        });
    }
}
