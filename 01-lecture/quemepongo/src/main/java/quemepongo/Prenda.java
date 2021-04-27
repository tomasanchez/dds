package quemepongo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

/**
 * Prendas de QuéMePongo
 *
 * @author Tomás Sánchez
 * @since 04.21.2021
 * @version 2.0
 */
public class Prenda {

    /**
     * El tipo de prenda
     *
     * @since 1.0
     */
    public TipoPrenda tipo;

    /**
     * El color primario
     *
     * @since 1.0
     */
    public Color color1;

    /**
     * El color secundario
     *
     * @since 1.1
     */
    public Color color2;

    /**
     * El material con que está hecho la prenda
     *
     * @since 1.0
     */
    public Material material;

    /**
     * La categoría de la prenda, coincidente con la de su tipo.
     *
     * @since 1.0
     */
    public Categoria categoria() {
        return tipo.categoria();
    }

    /**
     * Setter de color secundario a una prenda.
     *
     * @param color2 el color secundario a añadir.
     * @since 2.0
     */
    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    /**
     * Setter de tipo a una prenda.
     *
     * @param tipo el nuevo tipo
     * @since 2.0
     */
    public void setTipo(TipoPrenda tipo) {
        this.tipo = tipo;
    }

    /**
     * Setter de color principal a una prenda.
     *
     * @param color1 el color principal.
     * @since 2.0
     */
    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    /**
     * Setter de un material.
     *
     * @param material el material del tipo
     * @since 2.0
     */
    public void setMaterial(Material material) {
        if (!tipo.admiteMaterial(material.nombre))
            throw new PrendaInvalida("El tipo de prenda no acepta el material indicado");
        else
            this.material = material;
    }

    /**
     * Instancia una prenda de un único color
     *
     * @param tipoPrenda el tipo de prenda a crear
     * @param material   el tipo de material
     * @param color1     el color principal
     * @since Iteracion 2
     */
    public Prenda(TipoPrenda tipoPrenda, TipoMaterial material, Color color1) {
        this(tipoPrenda, material, TramaTela.LISA, color1, null);
    }

    /**
     *
     * @param tipo     el tipo de prenda a crear
     * @param material el material con el que esta hecho
     * @param trama    la trama del material
     * @param color1
     * @param color2
     */
    public Prenda(TipoPrenda tipo, TipoMaterial material, TramaTela trama, Color color1, Color color2) {

        // Iteración I
        if (Objects.isNull(tipo))
            throw new PrendaInvalida("Necesita obligatoriamente un tipo de prenda");
        if (Objects.isNull(material))
            throw new PrendaInvalida("Necesita obligatoriamente un material");
        if (Objects.isNull(color1))
            throw new PrendaInvalida("Necesita obligatoriamente un color principal");

        // Iteración II
        if (!tipo.admiteMaterial(material))
            throw new PrendaInvalida("El tipo de prenda no acepta el material indicado");

        this.tipo = tipo;
        this.color1 = color1;
        this.color2 = color2;
        this.material = new Material(material, trama);
    }

    public static class PrendaInvalida extends RuntimeException {
        public PrendaInvalida(String causa) {
            super("Prenda Inválida:" + causa);
        }
    }

    public void guardar() {
        try {
            ObjectOutputStream escribir = new ObjectOutputStream(
                    new FileOutputStream("/home/tosanchez/Developer/dds/01-lecture/quemepongo/db/prenda.txt"));

            escribir.writeObject(this);
            escribir.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static public Prenda cargar() {
        Prenda cargar = null;
        try {
            ObjectInputStream leer = new ObjectInputStream(
                    new FileInputStream("/home/tosanchez/Developer/dds/01-lecture/quemepongo/db/prenda.txt"));
            cargar = (Prenda) leer.readObject();
            leer.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return cargar;
    }

}
