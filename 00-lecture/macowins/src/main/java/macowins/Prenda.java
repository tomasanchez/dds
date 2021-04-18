package macowins;

/**
 * Ventas representa el detalle de venta, por prenda
 *
 * @author Tomás Sánchez
 * @version 2.0
 * @since 04.18.2021
 */
public class Prenda {

    /**
     * El precio sin descuentos de la prenda
     */
    public final double precioBase;

    /**
     * El tipo de prenda segun el dominio
     */
    public final Tipo tipo;

    /**
     * Los descuentos manuales de la prenda
     */
    public final double descuentos;

    /**
     * El estado de la prenda, según el dominio
     */
    public final Status estado;

    /**
     * Calcula el precio total de una prenda.
     * 
     * @return el precio final de la prenda, según su estado
     */
    public double precio() {
        return estado.precio(precioBase, descuentos);
    }

    /**
     * Prenda nueva.
     * 
     * @param base       - el precio base
     * @param tipoPrenda - el tipo de la prenda
     */
    public Prenda(double base, Tipo tipoPrenda) {
        precioBase = base;
        descuentos = 0;
        estado = Estado.nuevo;
        tipo = tipoPrenda;
    }

    /**
     * Prenda liquidacion si el descueto es del 50%, sino Prenda en promoción.
     * 
     * @param base       - el precion original
     * @param dcto       - el descuento aplicado
     * @param tipoPrenda - el tipo de la prenda
     */
    public Prenda(double base, double dcto, Tipo tipoPrenda) {
        precioBase = base;
        descuentos = dcto > 0 && dcto < 1 ? base * dcto : dcto;
        estado = precioBase - descuentos == precioBase * 0.5 ? Estado.liquidacion : Estado.promocion;
        tipo = tipoPrenda;
    }

}
