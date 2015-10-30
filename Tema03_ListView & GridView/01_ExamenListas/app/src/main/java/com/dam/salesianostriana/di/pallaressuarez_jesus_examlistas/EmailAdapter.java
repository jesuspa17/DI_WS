package com.dam.salesianostriana.di.pallaressuarez_jesus_examlistas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EmailAdapter extends ArrayAdapter<EmailItem> {
    private final Context context;
    private final ArrayList<EmailItem> values;


    public EmailAdapter(Context context, ArrayList<EmailItem> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutEmail = inflater.inflate(R.layout.list_item_email, parent, false);

        TextView letra = (TextView) layoutEmail.findViewById(R.id.txt_letra);
        TextView titulo = (TextView) layoutEmail.findViewById(R.id.txt_titutlo);
        ImageView favorito = (ImageView) layoutEmail.findViewById(R.id.imageViewEstrella);

        EmailItem emailactual = values.get(position);

        if(emailactual.isFav()) {
            favorito.setImageResource(android.R.drawable.star_on);
        } else {
            favorito.setImageResource(android.R.drawable.star_off);
        }

        
        letra.setText(emailactual.getNombre().subSequence(0, 1));
        letra.setBackgroundColor(emailactual.getColor());
        titulo.setText(emailactual.getNombre());

        // Modificaciones a realizar en el layout...

        return layoutEmail;
    }
}