package quemepongo.model.atuendo;

import java.util.Objects;
import quemepongo.model.prenda.Prenda;

/**
 * Atuendos uniformes
 *
 * @verion 1.1
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
     * @param calzado el calzado
     */
    public Uniforme(Prenda superior, Prenda inferior, Prenda calzado) {

        if (Objects.isNull(superior))
            throw new UniformeInvalido("No puede faltar una parte superior");
        if (Objects.isNull(inferior))
            throw new UniformeInvalido("No puede faltar una parte inferior");
        if (Objects.isNull(calzado))
            throw new UniformeInvalido("No puede faltar calzado");

        this.superior = superior;
        this.inferior = inferior;
        this.calzado = calzado;
    }

    /**
     * Runtime Exceptions por Uniforme Inválido
     *
     * @throws RuntimeException Por no poder crear el uniforme.
     * @since 1.1
     */
    public static class UniformeInvalido extends RuntimeException {
        UniformeInvalido(String causa) {
            super("El uniforme es inválido: " + causa);
        }
    }
}
