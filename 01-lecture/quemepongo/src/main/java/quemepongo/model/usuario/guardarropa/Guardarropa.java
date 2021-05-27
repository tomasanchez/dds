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
    private Set<SugerenciaGuardarropa> sugerenciasAceptadas =
            new LinkedHashSet<SugerenciaGuardarropa>();

    /**
     * Prendas Sugeridas.
     *
     * @since Iteración V
     */
    private Set<SugerenciaGuardarropa> sugerenciasPendientes =
            new LinkedHashSet<SugerenciaGuardarropa>();

    public Guardarropa() {

        Categoria[] categorias = Categoria.values();

        for (Categoria categoria : categorias) {
            prendas.put(categoria, new LinkedHashSet<Prenda>());
        }
    }

    public Set<SugerenciaGuardarropa> getSugerencias() {
        return this.sugerenciasPendientes;
    }

    /**
     * Deshace las sugerencias aceptadas.
     *
     * @since Iteración V
     */
    public void deshacerCambios() {
        sugerenciasAceptadas.forEach(
                sugerencia -> sugerencia.deshacerSugerencia(getPrendas(sugerencia.categoria())));
        sugerenciasAceptadas.clear();
    }

    /**
     * Acepta un cambio sugerido.
     *
     * @param sugerencia el cambio sugerido.
     */
    public void aceptarSugerencia(SugerenciaGuardarropa sugerencia) {

        sugerenciasPendientes.remove(sugerencia);
        sugerencia.aceptarSugerencia(getPrendas(sugerencia.categoria()));
    }

    public Guardarropa recibirSugerencia(SugerenciaGuardarropa sugerencia) {
        sugerenciasPendientes.add(sugerencia);
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
