package quemepongo.service.prenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import quemepongo.model.atuendo.Atuendo;
import quemepongo.model.atuendo.Uniforme;
import quemepongo.model.modista.Modista;
import quemepongo.model.modista.ModistaDeTemporada;
import quemepongo.model.modista.ModistaJhonson;
import quemepongo.model.modista.ModistaSanJuan;

/**
 * Recomendador de uniformes.
 *
 * @since 04.28.2021
 * @version 1.0
 */
public class Recomendador {

    /**
     * Listado de modistas de Uniformes actuales.
     *
     * @since 1.0
     */
    private List<Modista> modistasDeUniformes = new ArrayList<Modista>();

    /**
     * Instancia un recomendador con los modistas Jhonson y San Juan.
     */
    public Recomendador() {
        modistasDeUniformes.add(new ModistaJhonson());
        modistasDeUniformes.add(new ModistaSanJuan());
    }

    /**
     * Recomienda un uniforme a un usuario.
     *
     * @return un Uniforme de alguno de los modistas
     */
    public Uniforme recomendarUniforme() {
        return modistasDeUniformes.get(new Random().nextInt(modistasDeUniformes.size()))
                .fabricarUniforme();
    }

    public Atuendo recomendarAtuendoDeTemporada() {
        return new ModistaDeTemporada().fabricarAtuendo();
    }
}
