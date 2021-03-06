package quemepongo.model.prenda;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import quemepongo.model.material.Material;
import quemepongo.model.material.Material.MaterialInvalido;
import quemepongo.model.material.TipoMaterial;
import quemepongo.model.material.TramaTela;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pruebas de Materiales.
 *
 * @version 2.0
 * @since 04.28.2021
 */
public class MaterialTest {

    @Test
    public void todosPuedenSerLisos() {
        // Todos los materiales aceptan la trama lisa.
        assertTrue(Arrays.stream(TipoMaterial.values())
                .allMatch(material -> material.admiteTrama(TramaTela.LISA)));
    }

    @Test
    public void noMaterialSinMaterial() {
        // No se van a instanciar materiales sin un Tipo de Material.
        assertThrows(MaterialInvalido.class, () -> {
            new Material(null, null);
        });
    }

    @Test
    public void materialTramaLisaDefault() {
        // Para todo tipo de material, la trama lisa es la default.
        assertTrue(Arrays.stream(TipoMaterial.values()).map(tipo -> new Material(tipo, null))
                .allMatch(material -> material.getTrama().equals(TramaTela.LISA)));
    }

}
