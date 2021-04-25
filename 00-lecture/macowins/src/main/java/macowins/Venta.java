package macowins;

import java.time.LocalDate; // import the LocalDate class
import java.util.List;
import java.util.Objects;

/**
 * Ventas representa la cabecera de las ventas realizadas en Maco Wins.
 *
 * @author Tomás Sánchez
 * @version 3.0
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
    List<Item> items;

    /**
     * Coeficiente de recargo para el medio de pago
     * 
     * @since 1.0
     */
    public double coeficienteDeRecargo;

    /**
     * Cantidad de cuotas en las que se abona
     * 
     * @since 1.0
     */
    public int cuotas;

    /**
     * Medio de pago
     * 
     * @since 2.0
     */
    public Pago medio;

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
     * @param carrito un listado de items a vender
     * @since 2.0
     */
    public Venta(List<Item> carrito) {
        this(carrito, 0, 0);
    }

    /**
     * Generauna venta
     * 
     * @param carrito       los items a vender
     * @param recargo       un coeficiente de recargo por venta de tarjetas
     * @param cuantasCuotas la cantidad de cuotas en las que se abona
     */
    public Venta(List<Item> carrito, double recargo, int cuantasCuotas) {

        // Fail fasts

        if (Objects.isNull(carrito) || carrito.size() == 0)
            throw new VentaInvalida("El carrito no puede estar vacío");

        if (cuantasCuotas < 0)
            throw new VentaInvalida("No pueden haber cuotas negativas");

        if (cuantasCuotas == 0 && recargo > 0)
            throw new VentaInvalida("Las cuotas en tarjeta deben ser mayores a 0");

        if (cuantasCuotas > 0 && recargo <= 0)
            throw new VentaInvalida("Las ventas en cuotas, deben poseer un recargo mayor a 0");

        fecha = LocalDate.now();
        items = carrito;
        // Tarjeta
        coeficienteDeRecargo = recargo;
        cuotas = cuantasCuotas;
        medio = cuotas == 0 ? TipoPago.efectivo : TipoPago.tarjeta;

    }

    /**
     * RuntimeException por Venta Inválida.
     * 
     * @author Tomás Sánchez
     * @version 1.0
     * @since 3.0
     */
    public class VentaInvalida extends RuntimeException {
        /**
         * Excepción en runtime, al ingresar una Venta.
         * 
         * @param causa la causa de invalidez
         * @throws RuntimeException
         */
        public VentaInvalida(String causa) {
            super("La venta es inválida: " + causa);
        }
    }

    /**
     * Modifica la fecha (solo debugging)
     * 
     * @param fecha el nuevo valor
     * @since 3.0
     */
    public void fecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
