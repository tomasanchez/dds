package macowins;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class VentaTest {

    @Test
    public void siCreaVenta() {
        String syUname = System.getProperty("user.name");
        Venta delSabado = new Venta(syUname);
        Assertions.assertEquals(delSabado.nroDeDeudor, syUname);
    }

}
