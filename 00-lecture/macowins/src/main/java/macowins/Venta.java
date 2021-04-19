package macowins;

import java.time.LocalDate; // import the LocalDate class
import java.util.ArrayList; // for collection

/**
 * Ventas representa la cabecera de las ventas realizadas en Maco Wins.
 *
 * @author Tomás Sánchez
 * @version 2.0
 * @since 04.18.2021
 */
public class Venta {

    /**
     * Fecha de venta.
     * 
     * @since 1.0
     */
    public LocalDate fecha;

    /**
     * Listado de Items de prendas
     * 
     * @since 2.0
     */
    ArrayList<Item> items;

    /**
     * Coeficiente de recargo para el medio de pago
     * 
     * @since 1.0
     */
    public final double coeficienteDeRecargo;

    /**
     * Cantidad de cuotas en las que se abona
     * 
     * @since 1.0
     */
    public final int cuotas;

    /**
     * Medio de pago
     * 
     * @since 2.0
     */
    public final Pago medio;

    /**
     * Obtiene el precio final
     * 
     * @return el precio final segun el medio de pago
     * @since 2.0
     */
    public double precio() {

        double total = items.stream().mapToDouble(item -> item.precio()).sum();

        return medio.precio(total, coeficienteDeRecargo, cuotas);
    }

    /**
     * Genera una venta en efectivo segun un carrito de prendas.
     * 
     * @since 2.0
     */
    public Venta(ArrayList<Item> carrito) {

        fecha = LocalDate.now();
        items = carrito;
        coeficienteDeRecargo = 0;
        medio = TipoPago.efectivo;
        cuotas = 1;
    }

    public Venta(ArrayList<Item> carrito, double recargo, int cuantasCuotas) {

        if (cuantasCuotas <= 0)
            throw new IllegalArgumentException("Las cuotas deben ser mayores a 0");

        fecha = LocalDate.now();
        items = carrito;
        // Tarjeta
        coeficienteDeRecargo = recargo;
        medio = TipoPago.tarjeta;
        cuotas = cuantasCuotas;
    }

}
