package macowins;

/**
 * Item de venta
 * 
 * @version 1.0
 * @since 04.18.2021
 */
public class Item {

    /**
     * La prenda a venderse
     * 
     * @since 2.0
     */
    final Prenda prenda;

    /**
     * La cantidad de ese tipo de prenda
     * 
     * @since 2.0
     */
    final int cantidad;

    /**
     * Calcula el precio de una prenda y lo multiplica por la cantidad
     * 
     * @returns el precio de un item de venta
     */
    public double precio() {
        return prenda.precio() * cantidad;
    }

    /**
     * Añade una unica prenda a un item de venta
     * 
     * @param aVender - la prenda a venderse
     */
    public Item(Prenda aVender) {
        prenda = aVender;
        cantidad = 1;
    }

    /**
     * 
     * Añade una prenda a un item de venta.
     * 
     * @param aVender - la prenda a venderse
     * @param cant    - la cantidad de esa prenda
     */
    public Item(Prenda aVender, int cant) {

        if (cant <= 0)
            throw new IllegalArgumentException("Ingrese una cantidad válida");
        prenda = aVender;
        cantidad = cant;
    }
}
