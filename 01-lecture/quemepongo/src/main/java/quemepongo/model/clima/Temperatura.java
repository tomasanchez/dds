package quemepongo.model.clima;

/**
 * Temperatura obtenida por el servicio climático.
 *
 * @since 05.17.2021
 * @version 1.0
 */
public class Temperatura {

    private GradoTemperatura unidad = GradoTemperatura.CELSIUS;
    private double grados;

    public Temperatura() {}

    public Temperatura(GradoTemperatura unidad, double grados) {
        this.unidad = unidad;
        this.grados = grados;
    }

    public GradoTemperatura getUnidad() {
        return unidad;
    }

    public double getGrados() {
        return grados;
    }

    public Clima determinarClima() {
        return Clima.FRIO;
    }
}
