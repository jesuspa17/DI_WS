package com.dam.salesianostriana.di.listviewpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jesus on 25/10/2015.
 */
public class ToroAdapter extends ArrayAdapter<Toro> {
    private final Context context;
    private final ArrayList<Toro> values;

    public ToroAdapter(Context context, ArrayList<Toro> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Comentario Miguel:
        // La siguiente línea de código recibe como parámetro el layout
        // que he diseñado para un elemento del ListView, en este caso
        // para un Alumno de la lista >>> R.layout.list_item_alumno
        View layoutToro = inflater.inflate(R.layout.list_item_toro, parent, false);

        // Se busca en el layout los elementos que vamos a utilizar.
        ImageView toro = (ImageView) layoutToro.findViewById(R.id.imageViewToro);
        ImageView vendido = (ImageView) layoutToro.findViewById(R.id.imageViewVendido);
        TextView nombreTextView = (TextView) layoutToro.findViewById(R.id.textViewNombre);
        TextView pesoTextView = (TextView) layoutToro.findViewById(R.id.textViewPeso);
        TextView ganaderiaTextView = (TextView) layoutToro.findViewById(R.id.textViewGanaderia);

        //Comentario Miguel:
        // Para poder llenar los elementos del Layout de contenido, necesito obtener
        // los datos del alumno que estoy recorriendo en esta iteración
        Toro toroActual = values.get(position);

        //Si el Toro está vendido, mostrará un icono u otro.
        if(toroActual.isVendido()) {
            vendido.setImageResource(R.drawable.vendido);
        } else {
            vendido.setImageResource(R.drawable.offventa);
        }
        //Dibuja de tal color, el fondo de los elementos pares de la lista.
        if(position % 2 == 0){
            layoutToro.setBackgroundColor(android.graphics.Color.rgb(224,224,224));
        }

        //Coloca el texto e imagen en los elementos del UI list_item_toro
        toro.setImageResource(toroActual.getImagen());
        nombreTextView.setText(toroActual.getNombre());
        pesoTextView.setText(String.valueOf(toroActual.getPeso())+ " kg");
        ganaderiaTextView.setText(toroActual.getGanaderia());

        return layoutToro;
    }
}