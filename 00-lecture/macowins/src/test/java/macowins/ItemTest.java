package macowins;

import org.junit.jupiter.api.Test;

import macowins.Item.ItemInvalido;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Pruebas de Items.
 *
 * @author Tomás Sánchez
 * @version 1.1
 * @since 04.18.2021
 */
public class ItemTest {

    // Cantidades
    static private int ninguno = 0;
    static private int pocos = 3;
    static private int algunos = 5;
    static private int muchos = 10;
    // Precios
    private static final double precioCaro = 999.99;
    private static final double precioMedio = 499.99;
    private static final double precioBarato = 199.99;
    // Descuentos
    private static final double descuentoImportante = 200.0;
    private static final double descuentoMedio = 50.0;
    private static final double liquidacion = 0.5;
    // Prendas Nuevas
    private static Prenda pantalonNuevo = new Prenda(precioBarato, TipoPrenda.PANTALON);
    private static Prenda camisaNueva = new Prenda(precioMedio, TipoPrenda.CAMISA);
    // Prendas Promociones
    private static Prenda camisaPromo = new Prenda(precioMedio, descuentoMedio, TipoPrenda.CAMISA);
    private static Prenda sacoPromo = new Prenda(precioCaro, descuentoImportante, TipoPrenda.SACO);
    // Prendas Liquidacion
    private static Prenda pantalonLiq = new Prenda(precioBarato, liquidacion, TipoPrenda.PANTALON);
    private static Prenda sacoLiq = new Prenda(precioCaro, liquidacion, TipoPrenda.SACO);

    @Test
    void precioItemsCantidades() {
        Item itemsNuevos = new Item(pantalonNuevo, muchos);
        Item itemsPromo = new Item(camisaPromo, pocos);
        Item itemsLiq = new Item(sacoLiq, algunos);

        Assertions.assertEquals(pantalonNuevo.precio() * muchos, itemsNuevos.precio());
        Assertions.assertEquals(camisaPromo.precio() * pocos, itemsPromo.precio());
        Assertions.assertEquals(sacoLiq.precio() * algunos, itemsLiq.precio());
    }

    @Test
    void precioItem() {
        Item itemNuevo = new Item(camisaNueva);
        Item itemPromo = new Item(sacoPromo);
        Item itemLiq = new Item(pantalonLiq);

        Assertions.assertEquals(camisaNueva.precio(), itemNuevo.precio());
        Assertions.assertEquals(sacoPromo.precio(), itemPromo.precio());
        Assertions.assertEquals(pantalonLiq.precio(), itemLiq.precio());
    }

    @Test
    void itemsValidos() {
        // Item con prenda válida pero cantidad 0
        assertThrows(ItemInvalido.class, () -> {
            new Item(pantalonNuevo, ninguno);
        });
        // Item sin prenda y cantidad válida
        assertThrows(ItemInvalido.class, () -> {
            new Item(null, muchos);
        });
        // Item sin prenda y cantidad 0
        assertThrows(ItemInvalido.class, () -> {
            new Item(null, ninguno);
        });
    }

}
