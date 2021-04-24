package macowins;

/**
 * Ventas representa el detalle de venta, por prenda
 *
 * @author Tomás Sánchez
 * @version 3.2
 * @since 04.18.2021
 */
public class Prenda {

    /**
     * El precio sin descuentos de la prenda
     * 
     * @since 1.0
     */
    public final double precioBase;

    /**
     * El tipo de prenda segun el dominio
     * 
     * @since 2.0
     */
    public final Tipo tipo;

    /**
     * Los descuentos manuales de la prenda
     * 
     * @since 1.0
     */
    public final double descuentos;

    /**
     * El estado de la prenda, según el dominio
     * 
     * @since 3.0
     * 
     */
    public final Estado estado;

    /**
     * Calcula el precio total de una prenda.
     * 
     * @return el precio final de la prenda, según su estado
     * @since 2.0
     */
    public double precio() {
        return estado.precio(precioBase, descuentos);
    }

    /**
     * Prenda nueva.
     * 
     * @param base       - el precio base
     * @param tipoPrenda - el tipo de la prenda
     * @since 3.1
     */
    public Prenda(double base, Tipo tipoPrenda) {
        this(base, 0, tipoPrenda);
    }

    /**
     * Prenda liquidacion si el descueto es del 50%, sino Prenda en promoción.
     * 
     * @param base       - el precion original
     * @param dcto       - el descuento aplicado
     * @param tipoPrenda - el tipo de la prenda
     * @since 3.2
     */
    public Prenda(double base, double dcto, Tipo tipoPrenda) {

        if (base <= 0)
            throw new PrendaInvalida("El precio base debe ser mayor a 0.");

        if (base - Math.abs(dcto) <= 0)
            throw new PrendaInvalida("El descuento no puede ser mayor o igual al precio base.");

        precioBase = base;
        descuentos = dcto > 0 && dcto < 1 ? base * dcto : Math.abs(dcto);

        if (dcto == 0)
            estado = TipoEstado.nuevo;
        else
            estado = precioBase - descuentos == precioBase * 0.5 ? TipoEstado.liquidacion : TipoEstado.promocion;

        tipo = tipoPrenda;
    }

    /**
     * RuntimeException por Prenda Inválida.
     * 
     * @author Tomás Sánchez
     * @version 1.0
     * @since 3.2
     */
    public class PrendaInvalida extends RuntimeException {

        /**
         * Excepción por Prenda inválida.
         * 
         * @param causa la causa de la excepcion
         * @since 1.0
         */
        public PrendaInvalida(String causa) {
            super("Prenda inválida: " + causa);
        }
    }

}
