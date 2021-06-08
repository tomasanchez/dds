package quemepongo.api.clima.accuweather;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import quemepongo.model.clima.AlertaClimatica;
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
    private List<Map<String, Object>> climaticData;
    private Map<String, Object> alertsData;

    public AccuWeatherAdapter() {
        this(new AccuWeatherAPI());
    }

    public AccuWeatherAdapter(AccuWeatherAPI api) {
        this.api = api;
    }

    @Override
    public CondicionClimatica getCondicionClimatica(String localidad) {
        setClimaticData(localidad);
        return new CondicionClimatica(getTemperatura(), getPrecipitaciones());
    }

    @Override
    public List<AlertaClimatica> getAlertas(String localidad) {
        setAlertsData(localidad);
        return parseAlerts();
    }

    private List<AlertaClimatica> parseAlerts() {
        String[] alerts = (String[]) alertsData.get("Current Alerts");

        List<AlertaClimatica> allertsParsed = Arrays.stream(alerts)
                .map(s -> getCorrespondingAlert(s)).collect(Collectors.toList());

        allertsParsed.remove(null);

        return allertsParsed;
    }

    private AlertaClimatica getCorrespondingAlert(String str) {
        switch (str) {
            case "STORM":
                return AlertaClimatica.TORMENTA;
            case "HAIL":
                return AlertaClimatica.GRANIZO;
            case "SNOW":
                return AlertaClimatica.NEVADA;
            default:
                return null;
        }
    }

    private void setClimaticData(String localidad) {
        this.climaticData = api.getWeather(localidad);
    }

    private void setAlertsData(String localidad) {
        this.alertsData = api.getAlerts(localidad);
    }

    private Temperatura getTemperatura() {
        return new Temperatura(getUnidad(), getGrados());
    }

    private double getPrecipitaciones() {
        return Double.valueOf((Integer) climaticData.get(0).get("PrecipitationProbability"));
    }

    private double getGrados() {
        @SuppressWarnings("unchecked")
        Map<String, Object> temperature =
                (Map<String, Object>) climaticData.get(0).get("Temperature");
        Object value = temperature.get("Value");
        return Double.valueOf((Integer) value);
    }

    private GradoTemperatura getUnidad() {
        @SuppressWarnings("unchecked")
        Map<String, Object> temperature =
                (Map<String, Object>) climaticData.get(0).get("Temperature");

        return temperature.get("Unit").equals("F") ? GradoTemperatura.FAHRENHEIT
                : GradoTemperatura.CELSIUS;
    }

}
