package quemepongo.model.atuendo;

import quemepongo.model.prenda.Prenda;

/**
 * Atuendos de Vestir.
 *
 * @since 05.18.2021
 * @version Iteración IV.
 */
public class Conjunto {

    /**
     * Parte superior del conjunto.
     *
     * @since 1.0
     */
    private Prenda superior;

    /**
     * Parte inferior del conjunto.
     *
     * @since 1.0
     */
    private Prenda inferior;

    /**
     * Calzado del conjunto.
     *
     * @since 1.0
     */
    private Prenda calzado;

    /**
     * Accesorio adicional alconjunto.
     *
     * @since 1.0
     */
    private Prenda accesorio;

    /**
     * Instancia un Conjunto de prendas.
     *
     * @param superior la prenda de categoria superior
     * @param inferior la prenda de categoria inferior
     * @param calzado una prenda de categoria calzado
     * @param accesorio una prenda de categoria accesorio
     */
    public Conjunto(Prenda superior, Prenda inferior, Prenda calzado, Prenda accesorio) {
        this.superior = superior;
        this.inferior = inferior;
        this.calzado = calzado;
        this.accesorio = accesorio;
    }

    public Prenda getSuperior() {
        return superior;
    }

    public void setSuperior(Prenda superior) {
        this.superior = superior;
    }

    public Prenda getInferior() {
        return inferior;
    }

    public void setInferior(Prenda inferior) {
        this.inferior = inferior;
    }

    public Prenda getCalzado() {
        return calzado;
    }

    public void setCalzado(Prenda calzado) {
        this.calzado = calzado;
    }

    public Prenda getAccesorio() {
        return accesorio;
    }

    public void setAccesorio(Prenda accesorio) {
        this.accesorio = accesorio;
    }

}
