package macowins;

/**
 * El pago determina el precio final que se le cobra el usuario.
 * 
 * @version 1.0
 * @since 04.18.2021
 */
@FunctionalInterface
interface Pago {
    /**
     * Calcula el precio final
     * 
     * @param total       - el precio Total
     * @param coeficiente - un coeficiente de recargo
     * @param cuotas      - las cuotas en las que se abonan
     * @since 1.0
     */
    public double precio(double total, double coeficiente, int cuotas);
}

/**
 * Tipos de Pagos disponibles en macowins
 * 
 * @version 1.0
 * @since 04.18.2021
 */
public class TipoPago {

    /**
     * El pago en efectivo no incluye ninguna modificación
     * 
     * @since 1.0
     */
    static Pago efectivo = ((t, coef, c) -> t);

    /**
     * El pago con tarjeta calcula: Cuotas * coeficiente + 1% * Total
     * 
     * @since 1.0
     */
    static Pago tarjeta = ((t, coef, c) -> c * coef + 0.01 * t);
}
