package quemepongo;

/**
 * Factory de Atuendos.
 *
 * @version 1.0
 * @since 04.27.2021
 */
public abstract class Modista {

    /**
     * Fabrica un uniforme
     *
     * @return un nuevo uniforme
     * @since 1.0
     */
    public Uniforme fabricarUniforme() {
        return new Uniforme(this.fabricarPrendaSuperior(), this.fabricarPrendaInferior(), this.fabricarCalzado());
    }

    /**
     * Fabrica la parte superior
     *
     * @return una prenda de categoria Prenda Superior.
     * @since 1.0
     */
    protected abstract Prenda fabricarPrendaSuperior();

    /**
     * Fabrica la parte inferior
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
}
