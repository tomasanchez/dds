package macowins;

import java.time.LocalDate; // import the LocalDate class
import java.util.Random; // Import the Random generator

/**
 * Ventas representa la cabecera de las ventas realizadas en Maco Wins.
 *
 * @author Tomás Sánchez
 * @version 1.0
 * @since 04.12.2021
 */
public class Venta {
    /**
     * Número de venta
     */
    long nroDeVenta;
    /**
     * Cantidad de items de la venta
     */
    int items;
    /**
     * Número de Cliente, o DNI.
     */
    String nroDeDeudor;
    /**
     * Fecha de venta.
     */
    LocalDate fecha;
    /**
     * Total del Precio Base de cada item.
     */
    double subtotal;
    /**
     * Total de descuentos realizados
     */
    double descuentos;
    /**
     * Recargos por pago con targeta de crédito.
     */
    double recargos;
    /**
     * Total abonado.
     */
    double total;

    public Venta(String deudor) {

        Random rand = new Random();

        nroDeVenta = rand.nextLong();
        nroDeDeudor = deudor;
        fecha = LocalDate.now();
    }
}
