package macowins;

/**
 * Ventas representa el detalle de venta, por prenda
 *
 * @author Tomás Sánchez
 * @version 1.0
 * @since 04.12.2021
 */
public class Prenda {

    private static double coeficienteDeRecargo = 25.5;

    /**
     * Estado nuevo, no modifica el precio base.
     */
    private static Estado nuevo = new Estado(Status.NUEVO, "Nuevo", "No modifica el Precio Base", (p, d) -> p);
    /**
     * Estado liquidació, Mitad de precio
     */
    private static Estado liquidacion = new Estado(Status.LIQ, "Liquidacion", "50% off", (p, d) -> p * 0.5);
    /**
     * Estado promocion, descuento ingresado
     */
    private static Estado promocion = new Estado(Status.PROMO, "Promoción", "Descuento ingresado", (p, d) -> (p - d));

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
     * Descuento de promoción
     */
    private double dctoPromocion;

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
     * Recargos por cuotas.
     */
    double recargos;

    /**
     * Estado de la prenda
     */
    Estado estado;

    /**
     * Prendas del negocio Maco Wins. Por default la prenda es nueva.
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

        estado = nuevo;

        tipo = tipoPrenda;
    }

    /**
     * Prendas del negocio, especificando cantidad
     * 
     * @param idPrenda   - el nro de prenda.
     * @param tipoPrenda - el tipo de prenda.
     * @param cant       - la cantidad de items.
     * @param precioBase - el precio base de la prenda.
     */
    public Prenda(String idPrenda, String tipoPrenda, int cant, double precioBase) {

        cantidad = cant;

        nroDePrenda = idPrenda;

        precio = precioBase;

        estado = nuevo;

        tipo = tipoPrenda;
    }

    /**
     * Prendas del negocio Maco Wins. Por default la prenda es nueva.
     * 
     * @param idPrenda   - el nro de prenda.
     * @param tipoPrenda - el tipo de prenda
     * @param precioBase - el precio base de la prenda.
     * @param dcto       - el descuento aplicado, admite porcentajes, ej: 0.2.
     * @return Una nueva prenda.
     */
    public Prenda(String idPrenda, String tipoPrenda, double precioBase, double dcto) {
        // En un principio habría una sola
        cantidad = 1;
        // Por default es nueva.
        estado = nuevo;

        nroDePrenda = idPrenda;

        precio = precioBase;

        promocionar(dcto);

        tipo = tipoPrenda;

    }

    /**
     * Modifica el estado a promoción y guarda el descuento.
     * 
     * @param dcto - el descuento promocionado, puede ser porcentual
     */
    public Prenda promocionar(double dcto) {
        // Al asignar un descuento crea la promocion
        estado = promocion;
        // Acepta descuentos porcentuales %
        dctoPromocion = dcto < 1 ? dcto * precio * cantidad : dcto;
        descuentos = dctoPromocion;
        return this;
    }

    public Prenda liquidar() {
        estado = liquidacion;
        descuentos = estado.obtenerPrecio(precio, 0);
        return this;
    }

    /**
     * Modifica los recargos que tiene una prenda.
     * 
     * @param cuotas - cantidad de cuotas que se realiza el pago.
     */
    private void pagoEnCuotas(int cuotas) {
        recargos = coeficienteDeRecargo * cuotas + 0.01 * ganancia();
    }

    /**
     * Informa el estado de la prenda.
     * 
     * @return el estado actual que tiene la prenda.
     */
    public Status estado() {
        return estado.estado;
    }

    /**
     * Agrega un item mas de este tipo
     */
    public void agregarItem() {
        cantidad++;
    }

    /**
     * 
     * @return El precio con descuentos.
     */
    public double ganancia() {
        return estado.obtenerPrecio(precio, dctoPromocion) * cantidad;
    }

    /**
     * Agrega una prenda a una venta. También calcula el total con descuentos
     * 
     * @param idVenta - nro de venta asociada.
     */
    public void vender(long idVenta) {
        nroDeVenta = idVenta;
        total = estado.obtenerPrecio(precio, dctoPromocion);
    }

    /**
     * Agrega una prenda a una venta, permitiendo realizar una promoción.
     * 
     * @param idVenta - nro de venta asociada.
     * @param dcto    - el descuento aplicado, admite porcentajes, ej: 0.2.
     */
    public void vender(long idVenta, double dcto) {
        promocionar(dcto);
        vender(idVenta);
    }

    /**
     * Agrega una prenda a una venta, pagando en cuotas recargando el total abonado.
     * 
     * @param idVenta - nro de venta asociada.
     * @param cuotas  - cantidad de cuotas que se paga.
     */
    public void vender(long idVenta, int cuotas) {
        vender(idVenta);
        pagoEnCuotas(cuotas);
        total += recargos;
    }

    /**
     * 
     * @param idVenta - nro de venta asociada.
     * @param cuotas  - cantidad de cuotas que se paga.
     * @param dcto    - el descuento aplicado, admite porcentajes, ej: 0.2.
     */
    public void vender(long idVenta, int cuotas, double dcto) {
        vender(idVenta, dcto);
        pagoEnCuotas(cuotas);
        total += recargos;
    }

}
