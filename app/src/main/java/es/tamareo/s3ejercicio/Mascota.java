package es.tamareo.s3ejercicio;

/**
 * Created by paco on 29/3/17.
 */

public class Mascota {


    public Mascota(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
    }

    private String nombre;
    private int foto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
