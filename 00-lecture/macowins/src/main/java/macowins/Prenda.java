package macowins;

/**
 * Ventas representa el detalle de venta, por prenda
 *
 * @author Tomás Sánchez
 * @version 1.0
 * @since 04.12.2021
 */
public class Prenda {
    /**
     * Número de venta.
     */
    long nroDeVenta;

    /**
     * Número de prenda.
     */
    String nroDePrenda;

    /**
     * Cantidad de prendas de este tipo.
     */
    int cantidad;

    /**
     * Tipo de prenda.
     */
    String tipo;

    /**
     * Subtotal de Descuentos
     */
    double descuentos;

    /**
     * Precio base, sin descuentos
     */
    double precio;

    /**
     * Total Abonado
     */
    double total;

    /**
     * Prendas del negocio Maco Wins.
     * 
     * @param idPrenda   - el nro de prenda.
     * @param tipoPrenda - el tipo de prenda
     * @param precioBase - el precio base de la prenda.
     * @return Una nueva prenda.
     */
    public Prenda(String idPrenda, String tipoPrenda, double precioBase) {
        // En un principio habría una sola
        cantidad = 1;

        nroDePrenda = idPrenda;

        precio = precioBase;

        tipo = tipoPrenda;
    }

}
