package macowins;

/**
 * Status
 *
 * @author Tomás Sánchez
 * @version 2.0
 * @since 18.04.2021
 */
@FunctionalInterface
interface Status {
    /**
     * Obtiene el precio final de acuerdo a un estado.
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
public class Estado {

    /**
     * Estado nuevo, no modifica el precio base de la prenda.
     * 
     * @since 2.0
     */
    static Status nuevo = ((p, d) -> p);

    /**
     * Estado promocion, resta al precio base el descuento, o aplica % de dcto.
     * 
     * @since 2.0
     */
    static Status promocion = ((p, d) -> d > 0 && d < 1 ? p * d : p - d);

    /**
     * Estado liquidacion, 50% off
     * 
     * @since 2.0
     */
    static Status liquidacion = ((p, d) -> p * 0.5);
}