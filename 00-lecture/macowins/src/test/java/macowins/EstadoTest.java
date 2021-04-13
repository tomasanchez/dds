package macowins;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Pruebas de Estados
 *
 * @author Tomás Sánchez
 * @version 1.0
 * @since 04.13.2021
 */
public class EstadoTest {

    @Test
    public void estadoNuevo() {
        Estado nuevo = new Estado("Nuevo", "No modifica el Precio Base", (p, d) -> p);
        Assertions.assertEquals(25.5, nuevo.obtenerPrecio(25.5, 10));
    }

    @Test
    public void estadoLiquidacion() {
        Estado liquidacion = new Estado("Liquidacion", "50% off", (p, d) -> p * 0.5);
        Assertions.assertEquals(10, liquidacion.obtenerPrecio(20, 0));
    }

    @Test
    public void estadoPromocion() {
        Estado promocion = new Estado("Promoción", "Descuento ingresado", (p, d) -> (p - d));
        Assertions.assertEquals(150.75, promocion.obtenerPrecio(200.75, 50));
    }
}
