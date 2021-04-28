package quemepongo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Objects;

import org.junit.jupiter.api.Test;

/**
 * Prueba de Modistas
 *
 * @since 04.28.2021
 * @version 1.0
 */
public class ModistaTest {

    @Test
    public void creaUniforme() {
        // Deberian ambos devolver un Uniforme
        assertEquals(Uniforme.class, uniformeJhonson().getClass());
        assertEquals(Uniforme.class, uniformeSanJuan().getClass());
    }

    @Test
    public void uniformesNoVacios() {
        assertFalse(Objects.isNull(uniformeJhonson()));
        assertFalse(Objects.isNull(uniformeSanJuan()));
    }

    /**
     * Fabrica un uniforme del Modista del Intituto Jhonson
     *
     * @return la construccion de un uniforme.
     * @since 1.0
     */
    private static Object uniformeJhonson() {
        return new ModistaJhonson().fabricarUniforme();
    }

    /**
     * Fabrica un uniforme del Modista del colegio San Juan.
     *
     * @return la construccion de un uniforme.
     * @since 1.0
     */
    private static Object uniformeSanJuan() {
        return new ModistaSanJuan().fabricarUniforme();
    }

}
