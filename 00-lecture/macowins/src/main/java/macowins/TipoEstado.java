package macowins;

/**
 * Estado
 *
 * @author Tomás Sánchez
 * @version 2.0
 * @since 18.04.2021
 */
@FunctionalInterface
interface Estado {
    /**
     * Obtiene el precio final de acuerdo a un TipoEstado
     * 
     * @param precioBase - el precio base.
     * @param descuento  - el descuento aplicado
     * @return el precio final
     * @since 1.0
     */
    double precio(double precioBase, double descuento);
}

/**
 * Estado representa el estado que puede tener una prenda.
 *
 * @author Tomás Sánchez
 * @version 2.0
 * @since 04.18.2021
 */
public class TipoEstado {

    /**
     * Estado nuevo, no modifica el precio base de la prenda.
     * 
     * @since 2.0
     */
    static Estado nuevo = ((p, d) -> p);

    /**
     * Estado promocion, resta al precio base el descuento, o aplica % de dcto.
     * 
     * @since 2.0
     */
    static Estado promocion = ((p, d) -> d > 0 && d < 1 ? p * d : p - d);

    /**
     * Estado liquidacion, 50% off
     * 
     * @since 2.0
     */
    static Estado liquidacion = ((p, d) -> p * 0.5);
}