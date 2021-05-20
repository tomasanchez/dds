package quemepongo.model.clima;

/**
 * Tipos de Clima.
 *
 * @since 05.18.2021
 * @version 1.0
 */
public enum Clima {
    /**
     * Temperaturas menores a 10 °C.
     */
    FRIO {
        @Override
        protected Boolean cumple(Temperatura temperatura) {
            return entreTemperaturas(CELSIUS_MIN, CELSIUS_10, temperatura.getCelcius());
        }
    },
    /**
     * Temperaturas entre a 10°C y 15°C.
     */
    FRESCO {
        @Override
        protected Boolean cumple(Temperatura temperatura) {
            return entreTemperaturas(CELSIUS_15, CELSIUS_24, temperatura.getCelcius());
        }
    },
    /**
     * Temperaturas entre 15°C y 24°C.
     */
    TEMPLADO {
        @Override
        protected Boolean cumple(Temperatura temperatura) {
            return entreTemperaturas(CELSIUS_24, CELSIUS_28, temperatura.getCelcius());
        }
    },
    /**
     * Temperaturas entre 24°C y 28°C.
     */
    AGRADABLE {
        @Override
        protected Boolean cumple(Temperatura temperatura) {
            return entreTemperaturas(CELSIUS_24, CELSIUS_28, temperatura.getCelcius());
        }
    },
    /**
     * Temperaturas mayores a 28°C.
     */
    CALUROSO {
        @Override
        protected Boolean cumple(Temperatura temperatura) {
            return entreTemperaturas(CELSIUS_28, CELSIUS_MAX, temperatura.getCelcius());
        }
    };

    private static final double CELSIUS_MIN = -100;
    private static final double CELSIUS_10 = 10;
    private static final double CELSIUS_15 = 15;
    private static final double CELSIUS_24 = 24;
    private static final double CELSIUS_28 = 28;
    private static final double CELSIUS_MAX = 100;

    /**
     * Determina si está entre las temperaturas.
     *
     * @param cotaInferior La temperatura inferior
     * @param cotaSuperior La temperatura superior
     * @param temperatura Los grados celsius
     * @return si cumple
     */
    private static Boolean entreTemperaturas(double cotaInferior, double cotaSuperior,
            double temperatura) {
        return cotaInferior <= temperatura && temperatura <= cotaSuperior;
    }

    /**
     * Determina si un clima acepta esas temperaturas.
     *
     * @param temperatura los grados celsius.
     * @return
     */
    protected abstract Boolean cumple(Temperatura temperatura);

    /**
     * Determina el clima según la temperatura.
     *
     * @param celsius los grados en Celsius
     * @return el Clima
     */
    public static Clima determinarClima(double celsius) {
        return Clima.FRIO;
    }
}
