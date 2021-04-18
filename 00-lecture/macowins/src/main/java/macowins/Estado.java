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
    double precio(double precioBase, double descuento);
}

/**
 * Estado representa el estado que puede tener una prenda.
 *
 * @author Tomás Sánchez
 * @version 2.0
 * @since 04.13.2021
 */
public class Estado {
    // Estado nuevo, no modifica el precio base de la prenda.
    static Status nuevo = ((p, d) -> p);
    // Estado promocion, resta al precio base el descuento, o aplica % de dcto.
    static Status promocion = ((p, d) -> d > 0 && d < 1 ? p * d : p - d);
    // Estado liquidacion, 50% off
    static Status liquidacion = ((p, d) -> p * 0.5);
}