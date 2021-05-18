package quemepongo.model.modista;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import quemepongo.model.atuendo.Uniforme;

/**
 * Recomendador de uniformes.
 *
 * @since 04.28.2021
 * @version 1.0
 */
public class Recomendador {

    /**
     * Listado de modistas actuales.
     *
     * @since 1.0
     */
    private List<Modista> modistas;

    /**
     * Instancia un recomendador con los modistas Jhonson y San Juan.
     */
    public Recomendador() {
        modistas = new ArrayList<Modista>();
        modistas.add(new ModistaJhonson());
        modistas.add(new ModistaSanJuan());
    }

    /**
     * Recomienda un uniforme a un usuario.
     *
     * @return un Uniforme de alguno de los modistas
     */
    public Uniforme recomendarUniforme() {
        return modistas.get(new Random().nextInt(modistas.size())).fabricarUniforme();
    }
}
