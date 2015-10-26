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
public class GimnasioAdapter extends ArrayAdapter<EjercicioGimnasio> {
    private final Context context;
    private final ArrayList<EjercicioGimnasio> values;

    public GimnasioAdapter(Context context, ArrayList<EjercicioGimnasio> values) {
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
        View layoutToro = inflater.inflate(R.layout.list_item_gimnasio, parent, false);

        // Se busca en el layout los elementos que vamos a utilizar.
        ImageView toro = (ImageView) layoutToro.findViewById(R.id.imageViewToro);
        TextView nombreTextView = (TextView) layoutToro.findViewById(R.id.textViewNombre);
        TextView minutos = (TextView) layoutToro.findViewById(R.id.textViewMinutos);

        //Comentario Miguel:
        // Para poder llenar los elementos del Layout de contenido, necesito obtener
        // los datos del alumno que estoy recorriendo en esta iteración
        EjercicioGimnasio ejercicioGimnasioActual = values.get(position);

        //Coloca el texto e imagen en los elementos del UI
        toro.setImageResource(ejercicioGimnasioActual.getImagen());
        nombreTextView.setText(ejercicioGimnasioActual.getNombre_ejercicio());
        minutos.setText(String.valueOf(ejercicioGimnasioActual.getMinutos()));

        return layoutToro;
    }
}