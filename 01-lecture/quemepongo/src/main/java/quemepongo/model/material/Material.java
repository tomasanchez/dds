package quemepongo.model.material;

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
     * Getter de la trama
     *
     * @return la trama del material
     */
    public TramaTela getTrama() {
        return trama;
    }

    public TipoMaterial getMaterial() {
        return nombre;
    }

    /**
     * Instancia un material
     *
     * @param nombre El material en sí
     * @param trama
     * @throws MaterialInvalido si no se cumplen las condiciones.
     * @since 2.0
     */
    public Material(TipoMaterial nombre, TramaTela trama) {

        if (Objects.isNull(nombre))
            throw new MaterialInvalido("No puede crease un material sin Tipo de Material.");

        if (Objects.isNull(trama))
            this.trama = TramaTela.LISA;
        else if (!nombre.admiteTrama(trama))
            throw new MaterialInvalido(
                    nombre.toString() + " no admite la trama " + trama.toString());
        else
            this.trama = trama;

        this.nombre = nombre;
    }

    /**
     * RuntimeException Al crear un Material.
     *
     * @author Tomás Sánchez
     * @version 1.0
     * @since 2.0
     */
    public static class MaterialInvalido extends RuntimeException {

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
