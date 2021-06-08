package quemepongo.service.prenda.guardarropa;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import quemepongo.model.atuendo.Atuendo;
import quemepongo.model.atuendo.Conjunto;
import quemepongo.model.clima.Clima;
import quemepongo.model.clima.CondicionClimatica;
import quemepongo.model.prenda.Categoria;
import quemepongo.model.prenda.Prenda;
import quemepongo.service.clima.ServicioMetereologico;

/**
 * Sugerencias de Atuendos
 */
public class SugerenciasDeGuardarropa {

    /**
     * Prendas categorizadas.
     *
     * @since Iteración VI
     */
    private Map<Categoria, Set<Prenda>> prendas;

    /**
     * Prendas categorizadas.
     *
     * @since Iteración IV
     */
    private ServicioMetereologico pronostico = ServicioMetereologico.defaultService();

    private CondicionClimatica condicionesClimaticas;

    public SugerenciasDeGuardarropa(Map<Categoria, Set<Prenda>> prendas,
            ServicioMetereologico pronostico) {
        this.prendas = prendas;
        this.pronostico = pronostico;
        setCondicionClimatica();
    }

    public Atuendo sugerirAtuendo() {
        return new Atuendo(sugerirConjuntoSegunClima());
    }

    private Conjunto sugerirConjuntoSegunClima() {
        Clima clima = condicionesClimaticas.getClima();
        return new Conjunto(sugerirPrenda(Categoria.SUPERIOR, clima),
                sugerirPrenda(Categoria.INFERIOR, clima), sugerirPrenda(Categoria.CALZADO, clima),
                sugerirPrenda(Categoria.ACCESORIOS, clima));
    }

    private SugerenciasDeGuardarropa setCondicionClimatica() {
        this.condicionesClimaticas = pronostico.getCondicionClimatica("Buenos Aires");
        return this;
    }

    /**
     * Busca una Prenda segun el clima.
     *
     * @param categoria la categoria de la prenda a buscar
     * @return una prenda apta para el clima
     */
    private Prenda sugerirPrenda(Categoria categoria, Clima clima) {

        Set<Prenda> prendasDeCategoria = prendas.get(categoria);
        Optional<Prenda> prenda =
                prendasDeCategoria.stream().filter(p -> p.getTipo().aptoClima(clima)).findAny();

        return prenda.isPresent() ? prenda.get() : null;
    }

}
