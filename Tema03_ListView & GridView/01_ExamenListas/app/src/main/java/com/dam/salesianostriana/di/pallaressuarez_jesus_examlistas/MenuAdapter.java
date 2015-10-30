package com.dam.salesianostriana.di.pallaressuarez_jesus_examlistas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jpallares on 30/10/2015.
 */
public class MenuAdapter extends ArrayAdapter<MenuItem> {
    private final Context context;
    private final ArrayList<MenuItem> values;


    public MenuAdapter(Context context, ArrayList<MenuItem> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutItem = inflater.inflate(R.layout.grid_item_menu, parent, false);

        TextView descripcion = (TextView) layoutItem.findViewById(R.id.txtDescripcion);
        ImageView icono = (ImageView) layoutItem.findViewById(R.id.imageViewGrid);

        MenuItem itemActual = values.get(position);

        descripcion.setText(itemActual.getDescripcion());
        icono.setImageResource(itemActual.getIcono());


        return layoutItem;
    }
}
