package quemepongo.model.clima;

public class CondicionClimatica {

    private Temperatura temperatura = new Temperatura();
    private Clima clima;
    private double precipitaciones;

    public CondicionClimatica() {}

    public CondicionClimatica(Temperatura temperatura, double precipitaciones) {
        this.temperatura = temperatura;
        this.precipitaciones = precipitaciones;
        this.clima = temperatura.determinarClima();
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

}
