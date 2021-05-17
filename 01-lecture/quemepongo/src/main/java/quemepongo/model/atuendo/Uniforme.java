package quemepongo.model.atuendo;

import java.util.Objects;
import quemepongo.model.prenda.Prenda;

/**
 * Atuendos uniformes.
 *
 * @since 04.27.2021
 */
public class Uniforme {

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
     * Instancia un nuevo uniforme dado sus tres componentes.
     *
     * @param superior la prenda superior
     * @param inferior la prenda inferior
     * @param calzado el calzado
     */
    public Uniforme(Prenda superior, Prenda inferior, Prenda calzado) {

        validarConsistencia(superior, inferior, calzado);


        this.superior = superior;
        this.inferior = inferior;
        this.calzado = calzado;
    }

    /**
     * Valida que no se instancie un uniforme sin alguna prenda.
     *
     * @param s una prenda de categoria superior.
     * @param i una prenda de categoria inferior.
     * @param c una prenda de categoria calzado.
     * @throws UniformeInvalido de faltar alguna prenda.
     */
    private void validarConsistencia(Prenda s, Prenda i, Prenda c) {

        if (Objects.isNull(s)) {
            throw new UniformeInvalido("No puede faltar una parte superior");
        }

        if (Objects.isNull(i)) {
            throw new UniformeInvalido("No puede faltar una parte inferior");
        }

        if (Objects.isNull(c)) {
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

}
