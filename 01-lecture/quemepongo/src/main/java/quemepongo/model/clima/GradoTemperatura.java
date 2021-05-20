package quemepongo.model.clima;

/**
 * Unidad de medición de la temperatura.
 *
 * @since 05.17.2021
 * @version 1.0
 */
public enum GradoTemperatura {

    /**
     * Grados Fahrenheit (°F).
     */
    FAHRENHEIT {

        @Override
        public double getCelsius(double temperatura) {
            return (temperatura - AJUSTE) * (1 / COEFICIENTE);
        }

        @Override
        public double getFahrenheit(double temperatura) {
            return temperatura;
        }
    },

    /**
     * Grados Celsius (°C).
     */
    CELSIUS {

        @Override
        public double getCelsius(double temperatura) {
            return temperatura;
        }

        @Override
        public double getFahrenheit(double temperatura) {
            return (temperatura + COEFICIENTE) + AJUSTE;
        }
    };

    private static final Integer AJUSTE = 32;
    private static final double COEFICIENTE = 1.8;

    /**
     * Obtiene los grados Celsius.
     *
     * @param temperatura la temperatura registrada.
     * @return los grados en Celsius.
     */
    public abstract double getCelsius(double temperatura);

    /**
     * Obtiene los grados Fahrenheit.
     *
     * @param temperatura la temperatura registrada.
     * @return los grados en Fah.
     */
    public abstract double getFahrenheit(double temperatura);

}
