package quemepongo.api.clima.accuweather;

import java.util.List;
import java.util.Map;
import quemepongo.model.clima.CondicionClimatica;
import quemepongo.model.clima.GradoTemperatura;
import quemepongo.model.clima.Temperatura;
import quemepongo.service.clima.ServicioMetereologico;

/**
 * Adaptador para AccuWeather.
 *
 * @since 06.08.2021
 * @version 1.0
 */
public class AccuWeatherAdapter implements ServicioMetereologico {

    private AccuWeatherAPI api;
    private List<Map<String, Object>> data;

    public AccuWeatherAdapter() {
        this(new AccuWeatherAPI());
    }

    public AccuWeatherAdapter(AccuWeatherAPI api) {
        this.api = api;
    }

    @Override
    public CondicionClimatica getCondicionClimatica(String localidad) {
        setData(localidad);
        return new CondicionClimatica(getTemperatura(), getPrecipitaciones());
    }

    private void setData(String localidad) {
        this.data = api.getWeather(localidad);
    }

    private Temperatura getTemperatura() {
        return new Temperatura(getUnidad(), getGrados());
    }

    private double getPrecipitaciones() {
        return Double.valueOf((Integer) data.get(0).get("PrecipitationProbability"));
    }

    private double getGrados() {
        @SuppressWarnings("unchecked")
        Map<String, Object> temperature = (Map<String, Object>) data.get(0).get("Temperature");
        Object value = temperature.get("Value");
        return Double.valueOf((Integer) value);
    }

    private GradoTemperatura getUnidad() {
        @SuppressWarnings("unchecked")
        Map<String, Object> temperature = (Map<String, Object>) data.get(0).get("Temperature");

        return temperature.get("Unit").equals("F") ? GradoTemperatura.FAHRENHEIT
                : GradoTemperatura.CELSIUS;
    }
}
