package macowins;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import macowins.Prenda.PrendaInvalida;

/**
 * Pruebas de Prendas.
 *
 * @author Tomás Sánchez
 * @version 2.0
 * @since 04.18.2021
 */
public class PrendaTest {

    private static final double precioCarisimo = 1999.99;
    private static final double precioCaro = 999.99;
    private static final double precioNormal = 499.99;
    private static final double precioBarato = 199.99;
    private static final double sinPrecio = 0.0;

    private static final double descuentoImportante = 200.0;
    private static final double descuentoModerado = 50.0;
    private static final double liquidacion = 0.5;
    private static final double descuentoNada = 0.0;

    @Test
    public void prendaSinPrecio() {
        // No se deberian crear prendas sin precio, o precio negativo
        assertThrows(PrendaInvalida.class, () -> {
            new Prenda(sinPrecio, Tipo.CAMISA);
        });
        assertThrows(PrendaInvalida.class, () -> {
            new Prenda(-precioCaro, Tipo.PANTALON);
        });
        assertThrows(PrendaInvalida.class, () -> {
            new Prenda(-0.01, Tipo.SACO);
        });
    }

    @Test
    public void descuentoHaceGratis() {
        // No se deberian crear prendas sin precio, o precio negativo
        assertThrows(PrendaInvalida.class, () -> {
            new Prenda(sinPrecio, descuentoNada, Tipo.CAMISA);
        });
        assertThrows(PrendaInvalida.class, () -> {
            new Prenda(precioBarato, 2 * precioBarato, Tipo.PANTALON);
        });
        // Tampoco serian valido...
        assertThrows(PrendaInvalida.class, () -> {
            new Prenda(precioBarato, -2 * precioBarato, Tipo.SACO);
        });
    }

    @Test
    public void prendaNueva() {
        Prenda pantalon = new Prenda(precioCarisimo, Tipo.PANTALON);
        Prenda camisa = new Prenda(precioCaro, Tipo.CAMISA);
        Prenda saco = new Prenda(precioNormal, Tipo.SACO);
        // El estado debe ser nuevo
        Assertions.assertEquals(TipoEstado.nuevo, pantalon.estado);
        Assertions.assertEquals(TipoEstado.nuevo, camisa.estado);
        Assertions.assertEquals(TipoEstado.nuevo, saco.estado);
        // Los precios deben ser exactamente los precios base seteados.
        Assertions.assertEquals(precioCarisimo, pantalon.precio());
        Assertions.assertEquals(precioCaro, camisa.precio());
        Assertions.assertEquals(precioNormal, saco.precio());
    }

    @Test
    public void prendaPromo() {
        Prenda pantalon = new Prenda(precioCarisimo, descuentoNada, Tipo.PANTALON);
        Prenda camisa = new Prenda(precioCaro, descuentoModerado, Tipo.CAMISA);
        Prenda saco = new Prenda(precioNormal, descuentoImportante, Tipo.SACO);
        // El estado debe ser promoción
        Assertions.assertNotEquals(TipoEstado.promocion, pantalon.estado);
        Assertions.assertEquals(TipoEstado.promocion, camisa.estado);
        Assertions.assertEquals(TipoEstado.promocion, saco.estado);
        // El precio final debe ser el precio base - el descuento.
        Assertions.assertEquals(precioCarisimo - descuentoNada, pantalon.precio());
        Assertions.assertEquals(precioCaro - descuentoModerado, camisa.precio());
        Assertions.assertEquals(precioNormal - descuentoImportante, saco.precio());
    }

    @Test
    public void prendaLiquiacion() {
        Prenda pantalon = new Prenda(precioCarisimo, liquidacion, Tipo.PANTALON);
        Prenda camisa = new Prenda(precioCaro, liquidacion, Tipo.CAMISA);
        Prenda saco = new Prenda(precioNormal, liquidacion, Tipo.SACO);
        // El estado debe ser liquidación
        Assertions.assertEquals(TipoEstado.liquidacion, pantalon.estado);
        Assertions.assertEquals(TipoEstado.liquidacion, camisa.estado);
        Assertions.assertEquals(TipoEstado.liquidacion, saco.estado);
        // El precio debe ser la mitad del base.
        Assertions.assertEquals(precioCarisimo / 2, pantalon.precio());
        Assertions.assertEquals(precioCaro / 2, camisa.precio());
        Assertions.assertEquals(precioNormal / 2, saco.precio());
    }
}
