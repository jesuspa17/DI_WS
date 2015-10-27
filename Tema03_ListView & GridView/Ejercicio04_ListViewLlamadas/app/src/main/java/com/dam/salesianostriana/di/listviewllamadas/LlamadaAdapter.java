package com.dam.salesianostriana.di.listviewllamadas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jpallares on 27/10/2015.
 */
public class LlamadaAdapter extends ArrayAdapter<Llamada> {

    private final Context context;
    private final ArrayList<Llamada> values;

    public LlamadaAdapter(Context context, ArrayList<Llamada> values) {
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
        View layoutLlamadas = inflater.inflate(R.layout.list_item_llamadas, parent, false);

        // Se busca en el layout los elementos que vamos a utilizar.
        ImageView estadoLlamada = (ImageView) layoutLlamadas.findViewById(R.id.imageViewEstado);
        TextView numero = (TextView) layoutLlamadas.findViewById(R.id.textViewNumTlf);
        TextView tiempo = (TextView) layoutLlamadas.findViewById(R.id.textViewTiempo);
        TextView fecha = (TextView) layoutLlamadas.findViewById(R.id.textViewFecha);
        TextView hora = (TextView) layoutLlamadas.findViewById(R.id.textViewHora);

        //Comentario Miguel:
        // Para poder llenar los elementos del Layout de contenido, necesito obtener
        // los datos del alumno que estoy recorriendo en esta iteración
        Llamada llamada = values.get(position);

        if(llamada.getEstado().equalsIgnoreCase("recibida")){
            estadoLlamada.setImageResource(R.drawable.call_recive_1);
        }else if(llamada.getEstado().equalsIgnoreCase("perdida")){
            estadoLlamada.setImageResource(R.drawable.call_lost);
        }else if(llamada.getEstado().equalsIgnoreCase("realizada")){
            estadoLlamada.setImageResource(R.drawable.realizada);
        }
        //Coloca el texto e imagen en los elementos del UI
            numero.setText(String.valueOf(llamada.getNumero()));
            tiempo.setText(llamada.getTiempo());
            fecha.setText(llamada.getFecha()+", ");
            hora.setText(llamada.getHora());

        return layoutLlamadas;
    }
}
