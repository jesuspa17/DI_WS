package com.dam.salesianostriana.di.listviewpersonalizado;

/**
 * Created by Jesus on 25/10/2015.
 * Clase que llamaremos para darle formato al objeto que acojerá cada elemento de la lista.
 */

public class App {
    private int imagen;
    private String nombre;

    public App(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;

    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
