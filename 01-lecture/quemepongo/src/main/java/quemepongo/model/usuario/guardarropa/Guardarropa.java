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
    private Map<Categoria, Set<Prenda>> prendas = new HashMap<Categoria, Set<Prenda>>();

    /**
     * ModificacionesAceptadas.
     *
     * @since Iteración V
     */
    private Set<Tentativa> tentativasAceptadas = new LinkedHashSet<Tentativa>();

    /**
     * Prendas Sugeridas.
     *
     * @since Iteración V
     */
    private Set<Tentativa> tentativasPendientes = new LinkedHashSet<Tentativa>();

    public Guardarropa() {

        Categoria[] categorias = Categoria.values();

        for (Categoria categoria : categorias) {
            prendas.put(categoria, new LinkedHashSet<Prenda>());
        }
    }

    public Set<Tentativa> gettentativas() {
        return this.tentativasPendientes;
    }

    /**
     * Deshace las tentativas aceptadas.
     *
     * @since Iteración V
     */
    public void deshacerCambios() {
        tentativasAceptadas
                .forEach(tentativa -> tentativa.deshacerCambios(getPrendas(tentativa.categoria())));
        tentativasAceptadas.clear();
    }

    /**
     * Acepta un cambio sugerido.
     *
     * @param tentativa el cambio sugerido.
     */
    public void aceptarTentativa(Tentativa tentativa) {

        tentativasPendientes.remove(tentativa);
        tentativa.aceptarTentativa(getPrendas(tentativa.categoria()));
    }

    public Guardarropa recibirTentativa(Tentativa tentativa) {
        tentativasPendientes.add(tentativa);
        return this;
    }

    /**
     * Obtiene las pendas de una categoria.
     *
     * @param categoria la categoria de la cual obtener
     * @return una lista de prendas
     */
    public Set<Prenda> getPrendas(Categoria categoria) {
        return this.prendas.get(categoria);
    }

    /**
     * Agrega una prenda al guardarropas.
     *
     * @param prenda la prenda a añadir
     * @return el guardarropa
     * @since Iteración V
     */
    public Guardarropa agregarPrenda(Prenda prenda) {

        Set<Prenda> prendasDeCategoria = getPrendas(prenda.categoria());
        prendasDeCategoria.add(prenda);

        return this;
    }
}
