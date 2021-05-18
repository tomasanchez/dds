package quemepongo.model.modista;

import quemepongo.model.atuendo.Atuendo;
import quemepongo.model.atuendo.Conjunto;
import quemepongo.model.atuendo.Uniforme;
import quemepongo.model.prenda.Prenda;

/**
 * Factory de Atuendos.
 *
 * @version 2.0
 * @since 04.27.2021
 */
public abstract class Modista {

    /**
     * Fabrica un uniforme.
     *
     * @return un nuevo uniforme
     * @since 1.0
     */
    public Uniforme fabricarUniforme() {
        return new Uniforme(fabricarConjunto());
    }

    /**
     * Fabrica un atuendo.
     *
     * @return un nuevo atuendo
     * @since Iteración IV
     */
    public Atuendo fabricarAtuendo() {
        return new Atuendo(fabricarConjunto());
    }

    /**
     * Instancia un nuevo conjunto.
     *
     * @return un nuevo conjunto
     * @since Iteración IV
     */
    public Conjunto fabricarConjunto() {
        return new Conjunto(this.fabricarPrendaSuperior(), this.fabricarPrendaInferior(),
                this.fabricarCalzado(), this.fabricarAccesorio());
    }

    /**
     * Fabrica la parte superior.
     *
     * @return una prenda de categoria Prenda Superior.
     * @since 1.0
     */
    protected abstract Prenda fabricarPrendaSuperior();

    /**
     * Fabrica la parte inferior.
     *
     * @return una prenda de categoria Prenda Inferior.
     * @since 1.0
     */
    protected abstract Prenda fabricarPrendaInferior();

    /**
     * Fabrica un calsado.
     *
     * @return una prenda de categoria Calzado.
     * @since 1.0
     */
    protected abstract Prenda fabricarCalzado();

    /**
     * Fabrica un Accesorio.
     *
     * @return una prenda de categoria Prenda Accesorio.
     * @since Iteración IV
     */
    protected abstract Prenda fabricarAccesorio();
}
