package macowins;

import java.time.LocalDate; // import the LocalDate class
import java.util.ArrayList; // Fpr Collection
import java.util.Optional; // For Array Iteration
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
    final long nroDeVenta;
    /**
     * Cantidad de items de la venta
     */
    int items;
    /**
     * Número de Cliente, o DNI.
     */
    final String nroDeDeudor;
    /**
     * Fecha de venta.
     */
    LocalDate fecha;

    /**
     * Listado de Prendas
     */
    ArrayList<Prenda> prendas;

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

    /**
     * @param deudor - el cliente que realizón la compra
     */
    public Venta(String deudor) {

        Random rand = new Random();
        prendas = new ArrayList<Prenda>();
        nroDeVenta = Math.abs(rand.nextLong());
        nroDeDeudor = deudor;
        fecha = LocalDate.now();
    }

    /**
     * Genera una venta segun un carrito.
     * 
     * @param deudor  - el cliente que realizón la compra
     * @param carrito - las prendas vendidas
     */
    public Venta(String deudor, ArrayList<Prenda> carrito) {

        Random rand = new Random();
        nroDeVenta = Math.abs(rand.nextLong());
        nroDeDeudor = deudor;
        fecha = LocalDate.now();
        prendas = new ArrayList<Prenda>();

        if (!carrito.isEmpty()) {
            carrito.forEach(prenda -> agregarPrenda(prenda));
            subtotal = carrito.stream().mapToDouble(p -> p.precio).sum();
        }
    }

    /**
     * Calcula contables y vende las prendas.
     */
    public void vender() {

        prendas.forEach(prenda -> prenda.vender(nroDeVenta));
        subtotal = prendas.stream().mapToDouble(prenda -> prenda.precio).sum();
        total = prendas.stream().mapToDouble(prenda -> prenda.total).sum();
        recargos = 0;
        descuentos = prendas.stream().mapToDouble(prenda -> prenda.descuentos).sum();

    }

    /**
     * Calcula contables y vende las prendas en las cuotas indicadas
     * 
     * @param cuotas - las cuotas en las que se financia la venta
     */
    public void vender(int cuotas) {

        prendas.forEach(prenda -> prenda.vender(nroDeVenta, cuotas));
        subtotal = prendas.stream().mapToDouble(prenda -> prenda.precio).sum();
        total = prendas.stream().mapToDouble(prenda -> prenda.total).sum();
        recargos = prendas.stream().mapToDouble(prenda -> prenda.recargos).sum();
        descuentos = prendas.stream().mapToDouble(prenda -> prenda.descuentos).sum();
    }

    /**
     * Agrega una prenda al carrito.
     * 
     * @param prenda la prenda a anadirse
     */
    public void agregarPrenda(Prenda prenda) {

        Optional<Prenda> existente = prendas.stream()
                .filter(p -> p.nroDePrenda == prenda.nroDePrenda && p.estado() == prenda.estado()).findFirst();

        if (existente.isPresent()) {
            existente.get().agregarItem();
        } else {
            prendas.add(prenda);
        }

        items++;
    }

    public double ganancia() {
        return prendas.stream().mapToDouble(prenda -> prenda.ganancia()).sum();
    }

}
