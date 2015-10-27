package com.dam.salesianostriana.di.listviewllamadas;

/**
 * Created by jpallares on 27/10/2015.
 */
public class Llamada {

    private int numero;
    private String fecha;
    private String hora;
    private String tiempo;
    private String estado;

    public Llamada(int numero, String hora, String fecha, String tiempo, String estado) {
        this.numero = numero;
        this.hora = hora;
        this.fecha = fecha;
        this.tiempo = tiempo;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
