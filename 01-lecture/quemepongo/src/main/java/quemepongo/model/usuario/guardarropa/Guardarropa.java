package quemepongo.model.usuario.guardarropa;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import quemepongo.model.prenda.Categoria;
import quemepongo.model.prenda.Prenda;

/**
 * Guardarropa, repositorio de Prendas.
 *
 * @since 05.27.2021
 * @version 1.0
 */
public class Guardarropa {

    /**
     * Prendas categorizadas.
     *
     * @since Iteración V
     */
    Map<Categoria, Set<Prenda>> prendas = new HashMap<Categoria, Set<Prenda>>();

    public Guardarropa() {

        Categoria[] categorias = Categoria.values();

        for (Categoria categoria : categorias) {
            prendas.put(categoria, new LinkedHashSet<Prenda>());
        }
    }

    /**
     * Agrega una prenda al guardarropas.
     *
     * @param prenda la prenda a añadir
     * @return el guardarropa
     * @since Iteración V
     */
    public Guardarropa agregarPrenda(Prenda prenda) {

        Set<Prenda> prendasDeCategoria = prendas.get(prenda.categoria());
        prendasDeCategoria.add(prenda);

        return this;
    }
}
