package quemepongo.model.atuendo;

/**
 * Atuendos de Vestir.
 *
 * @since 05.18.2021
 */
public class Atuendo {

    /**
     * Accesorio adicional alconjunto.
     *
     * @since 1.0
     */
    private Conjunto conjunto;

    public Atuendo(Conjunto conjunto) {
        this.conjunto = conjunto;
    }

    public Conjunto getAccesorio() {
        return conjunto;
    }

    public Atuendo setConjunto(Conjunto conjunto) {
        this.conjunto = conjunto;
        return this;
    }

}
