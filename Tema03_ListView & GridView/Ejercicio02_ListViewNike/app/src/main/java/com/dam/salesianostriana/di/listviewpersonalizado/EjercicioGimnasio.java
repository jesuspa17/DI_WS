package com.dam.salesianostriana.di.listviewpersonalizado;

/**
 * Created by Jesus on 25/10/2015.
 * Clase que llamaremos para darle formato al objeto que acojerá cada elemento de la lista.
 */

public class EjercicioGimnasio {
    private int imagen;
    private String nombre_ejercicio;
    private int minutos;

    public EjercicioGimnasio(int imagen, String nombre_ejercicio, int minutos) {
        this.imagen = imagen;
        this.nombre_ejercicio = nombre_ejercicio;
        this.minutos = minutos;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getNombre_ejercicio() {
        return nombre_ejercicio;
    }

    public void setNombre_ejercicio(String nombre_ejercicio) {
        this.nombre_ejercicio = nombre_ejercicio;
    }
}
