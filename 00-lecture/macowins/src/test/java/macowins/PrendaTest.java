package macowins;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Pruebas de Prendas.
 *
 * @author Tomás Sánchez
 * @version 1.0
 * @since 04.13.2021
 */
public class PrendaTest {

    private static final long idVenta = 1233214;
    private static final int cuotas = 3;
    private static final double coeficienteDeRecargo = 25.5;

    private static Prenda nuevaCampera(double precioBase) {
        return new Prenda("JK000000010A", "Campera de Jean", precioBase);
    }

    private static Prenda nuevoJean(double precioBase) {
        return new Prenda("JP000000010A", "Pantalón de Jean", precioBase);
    }

    @Test
    public void estadosDePrenda() {
        double precioBase = 900;
        Prenda campera = nuevaCampera(precioBase);
        // La prenda debe ser nueva. y la ganacia el precio base
        Assertions.assertEquals(Status.NUEVO, campera.estado.estado);
        Assertions.assertEquals(precioBase, campera.ganancia());
        // Una vez liquidada, aplica descuento de 450 y el estado es liquidada
        campera.liquidar();
        Assertions.assertEquals(Status.LIQ, campera.estado.estado);
        Assertions.assertEquals(precioBase * 0.5, campera.ganancia());
        // Si se pone en promoción, debe tener descuento otorgado
        double dcto = 100;
        campera.promocionar(dcto);
        Assertions.assertEquals(Status.PROMO, campera.estado.estado);
        Assertions.assertEquals(precioBase - dcto, campera.ganancia());
    }

    @Test
    public void ventaPrendaNueva() {
        double precioBase = 300;
        Prenda pantalon = nuevoJean(precioBase);
        // Al venderse, el total abonado es el precio base.
        pantalon.vender(idVenta);
        Assertions.assertEquals(precioBase, pantalon.total);
    }

    @Test
    public void ventaPrendaNuevaCuotas() {
        double precioBase = 375;
        Prenda pantalon = nuevoJean(precioBase);
        // Al venderse, en cuotas, el total abonado es el precio base + recargos

        double recargos = coeficienteDeRecargo * cuotas + 0.01 * pantalon.ganancia();
        pantalon.vender(idVenta, cuotas);
        Assertions.assertEquals(precioBase + recargos, pantalon.total);
    }

    @Test
    public void ventaPrendaPromo() {
        double precioBase = 450;
        Prenda pantalon = nuevoJean(precioBase);
        // Descontando un 15%
        double dcto = 0.15;
        pantalon.promocionar(dcto);
        Assertions.assertEquals(precioBase * dcto, pantalon.descuentos);
        Assertions.assertEquals(precioBase - precioBase * dcto, pantalon.ganancia());
        // Al venderse, el precio total es unicamente el precio + descuento
        pantalon.vender(idVenta);
        Assertions.assertEquals(precioBase - precioBase * dcto, pantalon.total);
    }

    @Test
    public void ventaPrendaPromoCuotas() {
        double precioBase = 550;
        Prenda campera = nuevoJean(precioBase);
        // Descontando $100
        double dcto = 100;
        campera.promocionar(dcto);
        Assertions.assertEquals(dcto, campera.descuentos);
        Assertions.assertEquals(precioBase - dcto, campera.ganancia());
        // Al venderse, en cuotas, el total abonado es el
        // precio base + recargos - descuentos
        double recargos = coeficienteDeRecargo * cuotas + 0.01 * campera.ganancia();
        campera.vender(idVenta, cuotas);
        Assertions.assertEquals(precioBase - dcto + recargos, campera.total);
    }

    @Test
    public void ventaPrendaLiq() {
        double precioBase = 1000;
        Prenda campera = nuevaCampera(precioBase);
        // Liquidar = 50% off
        campera.liquidar();
        Assertions.assertEquals(precioBase / 2, campera.descuentos);
        Assertions.assertEquals(precioBase / 2, campera.ganancia());
        // Al venderse el total abonado es el 50% del precio
        campera.vender(idVenta);
        Assertions.assertEquals(precioBase / 2, campera.total);
    }

    @Test
    public void ventaPrendaLiqCuotas() {
        double precioBase = 1899.99;
        Prenda campera = nuevaCampera(precioBase);
        // Liquidar = 50% off
        campera.liquidar();
        Assertions.assertEquals(precioBase / 2, campera.descuentos);
        Assertions.assertEquals(precioBase / 2, campera.ganancia());
        // Al venderse, en cuotas, el total abonado es el
        // precio base /2 + recargos
        double recargos = coeficienteDeRecargo * cuotas + 0.01 * campera.ganancia();
        campera.vender(idVenta, cuotas);
        Assertions.assertEquals(precioBase / 2 + recargos, campera.total);
    }
}
