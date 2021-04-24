package macowins;

import java.util.Objects;

/**
 * Item de venta
 * 
 * @version 2.0
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
     * @since 2.0
     */
    public Item(Prenda aVender) {
        this(aVender, 1);
    }

    /**
     * 
     * Añade una prenda a un item de venta.
     * 
     * @param aVender - la prenda a venderse
     * @param cant    - la cantidad de esa prenda
     * @since 2.0
     */
    public Item(Prenda aVender, int cant) {

        // Fail fast
        if (Objects.isNull(aVender))
            throw new ItemInvalido("Se requiere almenos una (1) prenda.");

        // Fail fast
        if (cant <= 0)
            throw new ItemInvalido("Cantidad incorrecta");

        prenda = aVender;
        cantidad = cant;
    }

    /**
     * RuntimeException de Item Inv
     * 
     * @author Tomás Sánchez
     * @version 1.0
     * @since 2.0
     */
    public class ItemInvalido extends RuntimeException {
        public ItemInvalido(String causa) {
            super("Item inválido: " + causa);
        }
    }
}
