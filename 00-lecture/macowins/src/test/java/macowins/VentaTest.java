package macowins;

import org.junit.jupiter.api.Test;

import macowins.Venta.VentaInvalida;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

/**
 * Pruebas de Ventas.
 *
 * @author Tomás Sánchez
 * @version 2.0
 * @since 04.18.2021
 */
public class VentaTest {

    // Cantidades
    static private double ninguno = 0;
    static private int pocos = 3;
    static private int algunos = 5;
    static private int muchos = 10;
    // Precios
    private static final double precioCaro = 999.99;
    private static final double precioMedio = 499.99;
    private static final double precioBarato = 199.99;
    // Descuentos
    private static final double descuentoMedio = 50.0;
    private static final double liquidacion = 0.5;
    // Prendas Nuevas
    private static Prenda pantalonNuevo = new Prenda(precioBarato, TipoPrenda.PANTALON);
    // Prendas Promociones
    private static Prenda camisaPromo = new Prenda(precioMedio, descuentoMedio, TipoPrenda.CAMISA);
    // Prendas Liquidacion
    private static Prenda sacoLiq = new Prenda(precioCaro, liquidacion, TipoPrenda.SACO);
    // Items
    private static Item pantalonesNuevos = new Item(pantalonNuevo, pocos);
    private static Item camisasPromo = new Item(camisaPromo, algunos);
    private static Item sacosLiq = new Item(sacoLiq, muchos);

    @Test
    public void ventasVacias() {

        // Venta sin listado de items.
        assertThrows(VentaInvalida.class, () -> {
            new Venta(null);
        });
        // Venta con listado vacío
        assertThrows(VentaInvalida.class, () -> {
            new Venta(new ArrayList<Item>());
        });
        // Venta sin items sin recargo y sin cuotas
        assertThrows(VentaInvalida.class, () -> {
            new Venta(null, 0, 0);
        });
    }

    @Test
    public void ventaEnEfectivo() {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(pantalonesNuevos);
        double precio = pantalonesNuevos.precio();
        Venta venta = new Venta(items);

        assertEquals(TipoPago.efectivo, venta.medio);
        assertEquals(ninguno, venta.cuotas);
        assertEquals(ninguno, venta.coeficienteDeRecargo);
        assertEquals(precio, venta.precio());

    }

    @Test
    public void ventaConTarjeta() {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(pantalonesNuevos);
        items.add(camisasPromo);
        items.add(sacosLiq);

        double coeficienteDeRecargo = 100;
        double total = pantalonesNuevos.precio() + camisasPromo.precio() + sacosLiq.precio();
        double precio = coeficienteDeRecargo * muchos + 0.01 * total;

        Venta venta = new Venta(items, coeficienteDeRecargo, muchos);
        assertEquals(TipoPago.tarjeta, venta.medio);
        assertEquals(muchos, venta.cuotas);
        assertEquals(coeficienteDeRecargo, venta.coeficienteDeRecargo);
        assertEquals(precio, venta.precio());

    }

}
