package quemepongo.model.usuario.guardarropa;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import quemepongo.model.atuendo.Atuendo;
import quemepongo.model.prenda.Categoria;
import quemepongo.model.prenda.Prenda;
import quemepongo.service.clima.ServicioMetereologico;
import quemepongo.service.prenda.guardarropa.SugerenciasDeGuardarropa;

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

    /**
     * Atuendo sugerido.
     *
     * @since Iteración VI
     */
    private Atuendo sugerenciaDiaria;

    /**
     * Servicio Meteorologico.
     *
     * @since Iteración IV
     */
    private ServicioMetereologico servicioMetereologico;

    /**
     * Servicio de Sugerencias de Atuendos.
     *
     * @since Iteración VI
     */
    private SugerenciasDeGuardarropa servicioDeSugerencias;

    public Guardarropa() {
        initPrendas();
        initServicios();
    }

    public Set<Tentativa> getTentativas() {
        return this.tentativasPendientes;
    }

    /**
     * Sugiere un Atuendo segun condiciones climaticas actuales.
     *
     * @return un atuendo.
     */
    public Atuendo sugerirAtuendo() {
        return setSugerenciaDiaria(servicioDeSugerencias.sugerirAtuendo()).getSugerenciaDiaria();
    }

    public Atuendo getSugerenciaDiaria() {
        return this.sugerenciaDiaria;
    }

    public Guardarropa setSugerenciaDiaria(Atuendo atuendo) {
        this.sugerenciaDiaria = atuendo;
        return this;
    }

    /**
     * Dice si posee una prenda.
     *
     * @param prenda la prenda que buscar
     * @return si la posee o no
     */
    public boolean tienePrenda(Prenda prenda) {
        return getPrendas(prenda.categoria()).stream().anyMatch(p -> p.equals(prenda));
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
        tentativasAceptadas.add(tentativa);
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

    private void initPrendas() {
        Categoria[] categorias = Categoria.values();

        for (Categoria categoria : categorias) {
            prendas.put(categoria, new LinkedHashSet<Prenda>());
        }
    }

    private void initServicios() {
        this.servicioMetereologico = ServicioMetereologico.defaultService();
        this.servicioDeSugerencias =
                new SugerenciasDeGuardarropa(this.prendas, this.servicioMetereologico);
    }
}
