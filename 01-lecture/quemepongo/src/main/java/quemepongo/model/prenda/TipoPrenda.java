package quemepongo.model.prenda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import quemepongo.model.material.TipoMaterial;

/**
 * Tipos de prendas.
 *
 * @author Tomás Sánchez
 * @version 3.0
 * @since 04.20.2021
 */
public enum TipoPrenda {

    /**
     * Tipo Lentes (Accesorio).
     */
    LENTES(Categoria.ACCESORIOS),
    /**
     * Tipo Remera (Superior).
     */
    REMERA_MANGAS_CORTAS(Categoria.SUPERIOR),
    /**
     * Tipo Camisa (Superior).
     */
    CAMISA(Categoria.SUPERIOR),
    /**
     * Tipo Chomba (Superior).
     */
    CHOMBA(Categoria.SUPERIOR),
    /**
     * Tipo Pantalon (Inferior).
     */
    PANTALON_JEAN(Categoria.INFERIOR, "JEAN"),
    /**
     * Tipo Pantalon (Inferior).
     */
    PANTALON(Categoria.INFERIOR, "ALGODON,ACETATO"),
    /**
     * Tipo Zapatos (Inferior).
     */
    ZAPATOS(Categoria.CALZADO, "CUERO"),
    /**
     * Tipo Zapatillas (Inferior).
     */
    ZAPATILLAS(Categoria.CALZADO, "CUERO");

    /**
     *
     * La categoria a la que ese tipo de prenda pertenece.
     *
     *
     * @since 1.0
     */
    private Categoria categoria;

    /**
     * Listado de materiales admitidos por el tipo de prenda.
     *
     * @since 3.0
     */
    private List<TipoMaterial> materiales;

    /**
     * Tipos de prenda.
     *
     * @param cat la categoría correspondiente
     * @since 2.0
     */
    TipoPrenda(Categoria cat) {
        this(cat, cat.equals(Categoria.CALZADO) ? "" : "ALGODON");
    }

    /**
     * Tipo de prenda que admite materiales.
     *
     * @param categoria la categoria del tipo de prenda
     * @param materiales los materiales que admite
     */
    TipoPrenda(Categoria categoria, String materiales) {

        this.categoria = categoria;
        String[] materialesAdmitidos = materiales.split(",");

        this.materiales = new ArrayList<TipoMaterial>();

        Arrays.stream(materialesAdmitidos).map(str -> TipoMaterial.valueOf(str))
                .forEach(material -> this.materiales.add(material));
    }

    /**
     * Determina una categoría de acuerdo al tipo.
     *
     * @return la categoria del tipo
     * @since 1.0
     */
    public Categoria categoria() {
        return this.categoria;
    }

    /**
     * Determina si el tipo de prenda soporta el material.
     *
     * @param material el material a verificar.
     * @return si lo acepta o no.
     */
    public boolean admiteMaterial(TipoMaterial material) {
        return materiales.stream().anyMatch(admitido -> admitido.equals(material));
    }
}
