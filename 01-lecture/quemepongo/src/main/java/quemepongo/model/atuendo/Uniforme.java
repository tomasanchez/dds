package quemepongo.model.atuendo;

import java.util.Objects;
import quemepongo.model.prenda.Prenda;

/**
 * Atuendos uniformes.
 *
 * @since 04.27.2021
 */
public class Uniforme {

    private Conjunto conjunto;

    /**
     * Instancia un nuevo uniforme dado sus tres componentes.
     *
     * @param conjunto el conjunto de prendas
     */
    public Uniforme(Conjunto conjunto) {

        validarConsistencia(conjunto);

        this.conjunto = conjunto;
    }

    /**
     * Valida que no se instancie un uniforme sin alguna prenda.
     *
     * @param c el conjunto de prendas
     * @throws UniformeInvalido de faltar alguna prenda.
     */
    private void validarConsistencia(Conjunto c) {

        if (Objects.isNull(c.getSuperior())) {
            throw new UniformeInvalido("No puede faltar una parte superior");
        }

        if (Objects.isNull(c.getInferior())) {
            throw new UniformeInvalido("No puede faltar una parte inferior");
        }

        if (Objects.isNull(c.getCalzado())) {
            throw new UniformeInvalido("No puede faltar calzado");
        }
    }

    /**
     * Runtime Exceptions por Uniforme Inválido.
     *
     * @throws RuntimeException Por no poder crear el uniforme.
     * @since 1.1
     */
    public static class UniformeInvalido extends RuntimeException {
        UniformeInvalido(String causa) {
            super("El uniforme es inválido: " + causa);
        }
    }

    public Prenda getSuperior() {
        return conjunto.getSuperior();
    }

    public Prenda getInferior() {
        return conjunto.getInferior();
    }

    public Prenda getCalzado() {
        return conjunto.getCalzado();
    }

    public Conjunto getConjunto() {
        return conjunto;
    }

    public void setConjunto(Conjunto conjunto) {
        this.conjunto = conjunto;
    }
}
