package macowins;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class ItemTest {

    // Cantidades
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
    private static Prenda pantalonNuevo = new Prenda(precioBarato, Tipo.PANTALON);
    private static Prenda camisaNueva = new Prenda(precioMedio, Tipo.CAMISA);
    // Prendas Promociones
    private static Prenda camisaPromo = new Prenda(precioMedio, descuentoMedio, Tipo.CAMISA);
    private static Prenda sacoPromo = new Prenda(precioCaro, descuentoImportante, Tipo.SACO);
    // Prendas Liquidacion
    private static Prenda pantalonLiq = new Prenda(precioBarato, liquidacion, Tipo.PANTALON);
    private static Prenda sacoLiq = new Prenda(precioCaro, liquidacion, Tipo.SACO);

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

}
