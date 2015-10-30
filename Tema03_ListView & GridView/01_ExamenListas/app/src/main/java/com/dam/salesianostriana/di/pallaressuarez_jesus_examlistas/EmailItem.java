package com.dam.salesianostriana.di.pallaressuarez_jesus_examlistas;

/**
 * Created by jpallares on 30/10/2015.
 */
public class EmailItem {

    private int color;
    private String nombre;
    private boolean fav;

    public EmailItem(int color, String nombre, boolean fav) {
        this.color = color;
        this.nombre = nombre;
        this.fav = fav;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }
}
