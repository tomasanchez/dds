package macowins;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Pruebas de Ventas.
 *
 * @author Tomás Sánchez
 * @version 1.0
 * @since 04.13.2021
 */
public class VentaTest {

    private double precioCaro = 1999.99, precioNormal = 750, precioBarato = 349.99;

    private String syUname = System.getProperty("user.name");

    private Prenda camperaJean = new Prenda("JJ000000010A", "Campera de Jean", precioNormal),
            camperaJeanLiq = new Prenda("JJ000000010A", "Campera de Jean", precioNormal).liquidar(),
            camperaCuero = new Prenda("LJ000000011A", "Campera de Cuero", precioCaro),
            camperaCueroPromo = new Prenda("LJ000000011A", "Campera de Cuero", precioCaro, 99.99),
            elepants = new Prenda("EP00012469L", "Elepants Azules", precioNormal),
            pantalonDeJean = new Prenda("JP00000567L", "Skinny Jeans", precioBarato);

    @Test
    public void siCreaVenta() {
        Venta venta = new Venta(syUname);
        Assertions.assertEquals(venta.nroDeDeudor, syUname);
        Assertions.assertEquals(0, venta.prendas.size());
    }

    @Test
    public void siAgregaItems() {
        Venta venta = new Venta(syUname);

        // Agrego dos camperas iguales
        venta.agregarPrenda(camperaJean);
        venta.agregarPrenda(camperaJean);
        // Ergo deberia haber 1 solo item en la coleccion, pero 2 items contabilizados
        Assertions.assertEquals(1, venta.prendas.size());
        Assertions.assertEquals(2, venta.items);
        Assertions.assertEquals(2 * precioNormal, venta.ganancia());
        // Al añadir una prenda de otro estado...
        venta.agregarPrenda(camperaJeanLiq);
        // Deberia haber una nueva entrada y un nuevo item
        Assertions.assertEquals(2, venta.prendas.size());
        Assertions.assertEquals(3, venta.items);
        Assertions.assertEquals(2 * precioNormal + 0.5 * precioNormal, venta.ganancia());

    }

}
