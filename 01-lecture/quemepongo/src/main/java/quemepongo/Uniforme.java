package quemepongo;

/**
 * Atuendos uniformes
 *
 * @verion 1.0
 * @since 04.27.2021
 */
public class Uniforme {

    /**
     * Parte superior del conjunto
     *
     * @since 1.0
     */
    public Prenda superior;

    /**
     * Parte inferior del conjunto
     *
     * @since 1.0
     */
    public Prenda inferior;

    /**
     * Calzado del conjunto
     *
     * @since 1.0
     */
    public Prenda calzado;

    /**
     * Instancia un nuevo uniforme dado sus tres componentes.
     *
     * @param superior la prenda superior
     * @param inferior la prenda inferior
     * @param calzado  el calzado
     */
    public Uniforme(Prenda superior, Prenda inferior, Prenda calzado) {
        this.superior = superior;
        this.inferior = inferior;
        this.calzado = calzado;
    }
}
