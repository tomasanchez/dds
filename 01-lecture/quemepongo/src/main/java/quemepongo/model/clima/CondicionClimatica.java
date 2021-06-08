package quemepongo.model.clima;

import java.time.LocalDate;

/**
 * Reporte de temperatura, probabilidad de lluvia y clima.
 *
 * @since 05.18.2021
 * @version 1.0
 */
public class CondicionClimatica {

    private Temperatura temperatura = new Temperatura();
    private Clima clima = Clima.FRIO;
    private LocalDate fecha = LocalDate.now();
    private double precipitaciones;

    public CondicionClimatica() {}

    /**
     * Instancia una Condicion.
     *
     * @param temperatura la temperatura registrada
     * @param precipitaciones la probabilidad de precipitaciones.
     */
    public CondicionClimatica(Temperatura temperatura, double precipitaciones) {
        this.temperatura = temperatura;
        this.precipitaciones = precipitaciones;
        this.clima = Clima.determinarClima(temperatura);
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    public Clima getClima() {
        return clima;
    }

    public double getPrecipitaciones() {
        return precipitaciones;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

}
