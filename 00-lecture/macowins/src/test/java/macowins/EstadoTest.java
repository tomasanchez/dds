package macowins;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Pruebas de Estados
 *
 * @author Tomás Sánchez
 * @version 2.0
 * @since 04.18.2021
 */
public class EstadoTest {

    private static final double precioSuperElevado = 1999.99;
    private static final double precioElevado = 999.99;
    private static final double precioModerado = 499.99;
    private static final double precioBarato = 199.99;

    private static final double descuentoNada = 0.0;
    private static final double descuentoImportante = 200.0;
    private static final double descuentoModerado = 50.0;
    private static final double descuentoChico = 10;

    @Test
    public void estadoNuevo() {

        Assertions.assertEquals(precioElevado, Estado.nuevo.precio(precioElevado, descuentoModerado));
        Assertions.assertEquals(precioModerado, Estado.nuevo.precio(precioModerado, descuentoChico));
        Assertions.assertEquals(precioBarato, Estado.nuevo.precio(precioBarato, descuentoNada));
        Assertions.assertEquals(precioSuperElevado, Estado.nuevo.precio(precioSuperElevado, descuentoImportante));
    }

    @Test
    public void estadoPromocion() {
        Assertions.assertEquals(precioElevado - descuentoNada, Estado.promocion.precio(precioElevado, descuentoNada));
        Assertions.assertEquals(precioModerado - descuentoChico,
                Estado.promocion.precio(precioModerado, descuentoChico));
        Assertions.assertEquals(precioBarato - descuentoModerado,
                Estado.promocion.precio(precioBarato, descuentoModerado));
        Assertions.assertEquals(precioSuperElevado - descuentoImportante,
                Estado.promocion.precio(precioSuperElevado, descuentoImportante));
    }

    @Test
    public void estadoLiquidacion() {
        Assertions.assertEquals(precioElevado * 0.5, Estado.liquidacion.precio(precioElevado, descuentoModerado));
        Assertions.assertEquals(precioBarato * 0.5, Estado.liquidacion.precio(precioBarato, descuentoImportante));
        Assertions.assertEquals(precioModerado * 0.5, Estado.liquidacion.precio(precioModerado, descuentoChico));
        Assertions.assertEquals(precioSuperElevado * 0.5, Estado.liquidacion.precio(precioSuperElevado, descuentoNada));
    }

}
