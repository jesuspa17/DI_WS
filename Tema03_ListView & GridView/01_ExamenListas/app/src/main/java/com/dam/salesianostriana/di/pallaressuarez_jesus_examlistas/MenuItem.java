package com.dam.salesianostriana.di.pallaressuarez_jesus_examlistas;

/**
 * Created by jpallares on 30/10/2015.
 */
public class MenuItem {

    private int icono;
    private String descripcion;

    public MenuItem(int icono, String descripcion) {
        this.icono = icono;
        this.descripcion = descripcion;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
