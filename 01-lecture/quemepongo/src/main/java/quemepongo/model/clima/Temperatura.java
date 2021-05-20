package quemepongo.model.clima;

/**
 * Temperatura obtenida por el servicio climático.
 *
 * @since 05.17.2021
 * @version 1.0
 */
public class Temperatura {

    /**
     * La unidad de medición.
     *
     * @since Iteración IV
     */
    private GradoTemperatura unidad = GradoTemperatura.CELSIUS;

    /**
     * El valor en grados.
     *
     * @since Iteración IV
     */
    private double grados;

    public Temperatura() {}

    /**
     * Instancia una temperatura en la unidad dada.
     *
     * @param unidad la unidad de medición
     * @param grados los valores de temperatura
     */
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

    public double getCelcius() {
        return unidad.getCelsius(grados);
    }

    public double getFahrenheit() {
        return unidad.getFahrenheit(grados);
    }

}
