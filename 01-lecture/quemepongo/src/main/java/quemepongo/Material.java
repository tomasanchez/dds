package quemepongo;

import java.util.Objects;

/**
 * Material de una Prenda.
 *
 * @version 2.0
 * @since 04.25.2021
 */
public class Material {

    /**
     * El material en sí.
     *
     * @since 2.0
     */
    TipoMaterial nombre;

    /**
     * La trama del material.
     *
     * @since 2.0
     */
    TramaTela trama;

    /**
     * Instancia un material
     *
     * @param nombre El material en sí
     * @param trama
     * @throws MaterialInvalido si no se cumplen las condiciones.
     * @since 2.0
     */
    public Material(TipoMaterial nombre, TramaTela trama) {

        if (!this.nombre.admiteTrama(trama))
            throw new MaterialInvalido(nombre.toString() + " no admite " + trama.toString());

        this.nombre = nombre;
        this.trama = Objects.isNull(trama) ? TramaTela.LISA : trama;
    }

    /**
     * RuntimeException Al crear un Material.
     *
     * @author Tomás Sánchez
     * @version 1.0
     * @since 2.0
     */
    public class MaterialInvalido extends RuntimeException {

        /**
         * Excepción al crear Material.
         *
         * @param causa la causa de invalidez
         * @throws RuntimeException
         */
        public MaterialInvalido(String causa) {
            super("Material inválido: " + causa);
        }
    }

}
