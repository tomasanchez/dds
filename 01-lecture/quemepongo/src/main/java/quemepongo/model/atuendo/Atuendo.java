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

    public Conjunto getConjunto() {
        return conjunto;
    }

    public Atuendo setConjunto(Conjunto conj) {
        this.conjunto = conj;
        return this;
    }

}
