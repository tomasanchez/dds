package quemepongo;

import java.util.Objects;

/**
 * Builder de prendas.
 *
 * @since 04.27.2021
 * @version 1.0
 */
public class Borrador {

    TipoPrenda tipo;

    TipoMaterial material;

    TramaTela trama;

    Color color1;

    Color color2;

    /**
     * Borrador desde cero.
     *
     * @since 1.0
     */
    public Borrador() {
        this(null);
    }

    /**
     * Borrador de una prenda de acuerdo a un template.
     *
     * @param template El blueprint de la prenda.
     * @since 1.0
     */
    public Borrador(Prenda template) {
        if (!Objects.isNull(template)) {
            this.tipo = template.tipo;
            this.material = template.material.nombre;
            this.trama = template.material.trama;
            this.color1 = template.color1;
            this.color2 = template.color2;
        }
    }

    public void especificarTipo(TipoPrenda tipo) {
        this.tipo = tipo;
    }

    public void especificarMaterial(TipoMaterial material) {
        this.material = material;
    }

    public void especificarColorPrimario(Color color1) {
        this.color1 = color1;
    }

    public void especificarColorSecundario(Color color2) {
        this.color2 = color2;
    }

    public void especificarTrama(TramaTela trama) {
        this.trama = trama;
    }

    public Prenda crearPrenda() {
        return new Prenda(tipo, material, trama, color1, color2);
    }
}
