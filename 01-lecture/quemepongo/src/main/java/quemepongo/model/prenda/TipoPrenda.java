package quemepongo.model.prenda;

import java.util.Arrays;
import java.util.List;
import quemepongo.model.material.TipoMaterial;
import java.util.ArrayList;

/**
 * Tipos de prendas
 *
 * @author Tomás Sánchez
 * @version 3.0
 * @since 04.20.2021
 */
public enum TipoPrenda {

    LENTES(Categoria.ACCESORIOS), REMERA_MANGAS_CORTAS(Categoria.SUPERIOR), CAMISA(
            Categoria.SUPERIOR), PANTALON_JEAN(Categoria.INFERIOR,
                    "JEAN"), CHOMBA(Categoria.SUPERIOR), ZAPATOS(Categoria.CALZADO,
                            "CUERO"), ZAPATILLAS(Categoria.CALZADO,
                                    "CUERO"), PANTALON(Categoria.INFERIOR, "ALGODON,ACETATO");

    /**
     *
     * La categoria a la que ese tipo de prenda pertenece
     *
     *
     * @since 1.0
     */
    private Categoria categoria;

    /**
     * Determina una categoría de acuerdo al tipo.
     *
     * @return la categoria del tipo
     * @since 1.0
     */
    Categoria categoria() {
        return this.categoria;
    }

    /**
     * Listado de materiales admitidos por el tipo de prenda.
     *
     * @since 3.0
     */
    List<TipoMaterial> materiales;

    public boolean admiteMaterial(TipoMaterial material) {
        return materiales.stream().anyMatch(admitido -> admitido.equals(material));
    }

    /**
     * Tipos de prenda
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
}
