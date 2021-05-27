package quemepongo.model.guardarropa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quemepongo.model.material.Color;
import quemepongo.model.material.TipoMaterial;
import quemepongo.model.prenda.Borrador;
import quemepongo.model.prenda.Prenda;
import quemepongo.model.prenda.TipoPrenda;
import quemepongo.model.usuario.guardarropa.Guardarropa;
import quemepongo.model.usuario.guardarropa.Tentativa;
import quemepongo.model.usuario.guardarropa.TentativaAgregar;
import quemepongo.model.usuario.guardarropa.TentativaQuitar;

public class GuardarropaTest {

    private Guardarropa guardarropa;
    private Prenda prenda;
    private Tentativa tentativaAgregar;
    private Tentativa tentativaQuitar;


    @BeforeEach
    void initGuardarropa() {
        guardarropa = new Guardarropa();
        prenda = prendaDePrueba();
        tentativaAgregar = new TentativaAgregar(prenda);
        tentativaQuitar = new TentativaQuitar(prenda);
    }

    @Test
    void aceptaPrenda() {
        guardarropa.agregarPrenda(prenda);
        // Verifico si está en la lista
        Assertions.assertTrue(guardarropa.tienePrenda(prenda));
        Assertions.assertFalse(guardarropa.tienePrenda(prendaDePrueba()));
    }

    @Test
    void recibirTentativa() {

        Assertions.assertEquals(guardarropa.getTentativas().size(), 0);

        guardarropa.recibirTentativa(tentativaAgregar);
        guardarropa.recibirTentativa(tentativaQuitar);

        Assertions.assertEquals(guardarropa.getTentativas().size(), 2);
    }

    @Test
    void aceptaTentativaAgregar() {

        Assertions.assertFalse(guardarropa.tienePrenda(prenda));

        guardarropa.recibirTentativa(tentativaAgregar);
        guardarropa.aceptarTentativa(tentativaAgregar);

        Assertions.assertTrue(guardarropa.tienePrenda(prenda));
    }

    @Test
    void deshaceCambiosAgregar() {

        guardarropa.recibirTentativa(tentativaAgregar);
        guardarropa.aceptarTentativa(tentativaAgregar);

        Assertions.assertTrue(guardarropa.tienePrenda(prenda));
        guardarropa.deshacerCambios();
        Assertions.assertFalse(guardarropa.tienePrenda(prenda));
    }

    @Test
    void aceptaTentativaQuitar() {

        guardarropa.agregarPrenda(prenda);
        Assertions.assertTrue(guardarropa.tienePrenda(prenda));
        guardarropa.recibirTentativa(tentativaQuitar);
        guardarropa.aceptarTentativa(tentativaQuitar);
        Assertions.assertFalse(guardarropa.tienePrenda(prenda));
    }

    @Test
    void deshaceCambiosQuitar() {

        guardarropa.agregarPrenda(prenda);
        guardarropa.recibirTentativa(tentativaQuitar);
        guardarropa.aceptarTentativa(tentativaQuitar);
        Assertions.assertFalse(guardarropa.tienePrenda(prenda));
        guardarropa.deshacerCambios();
        Assertions.assertTrue(guardarropa.tienePrenda(prenda));
    }

    Prenda prendaDePrueba() {
        Borrador bosquejo = new Borrador();
        bosquejo.setTipo(TipoPrenda.CAMISA);
        bosquejo.setMaterial(TipoMaterial.ALGODON);
        bosquejo.setColor1(new Color("#blanco"));
        return bosquejo.guardarPrenda();
    }

}
