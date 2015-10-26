package com.dam.salesianostriana.di.listviewpersonalizado;

/**
 * Created by Jesus on 25/10/2015.
 * Clase que llamaremos para darle formato al objeto Toro que acojerá cada elemento de la lista.
 */

public class Toro {
    private int imagen;
    private String nombre;
    private int peso;
    private String ganaderia;
    private boolean vendido;

    public Toro(int imagen,String nombre, int peso, String ganaderia, boolean vendido) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.peso = peso;
        this.ganaderia = ganaderia;
        this.vendido = vendido;
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

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public String getGanaderia() {
        return ganaderia;
    }

    public void setGanaderia(String ganaderia) {
        this.ganaderia = ganaderia;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
