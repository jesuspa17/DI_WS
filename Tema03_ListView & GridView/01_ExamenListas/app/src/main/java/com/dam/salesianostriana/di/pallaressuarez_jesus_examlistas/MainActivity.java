package com.dam.salesianostriana.di.pallaressuarez_jesus_examlistas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView emails;
    GridView items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emails = (ListView)findViewById(R.id.listView);
        items = (GridView) findViewById(R.id.gridView);

        final ArrayList<EmailItem> listadoEmail = new ArrayList<EmailItem>();

        //Colores extraidos de un archivo personalizado de colores en res/values
        listadoEmail.add(new EmailItem(getResources().getColor(R.color.celeste),"Los Escarabajos", false));
        listadoEmail.add(new EmailItem(getResources().getColor(R.color.naranja),"TIBCO Japersfot", true));
        listadoEmail.add(new EmailItem(getResources().getColor(R.color.morado),"Klout", false));
        listadoEmail.add(new EmailItem(getResources().getColor(R.color.rojo),"Google AdSense", true));


        final EmailAdapter adaptador = new EmailAdapter(this,listadoEmail);
        emails.setAdapter(adaptador);

        emails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                EmailItem emailSelec = listadoEmail.get(position);
                if (emailSelec.isFav()) {
                    emailSelec.setFav(false);
                } else {
                    emailSelec.setFav(true);
                }

                adaptador.notifyDataSetChanged();
            }
        });

        final ArrayList<MenuItem> listadoItems = new ArrayList<MenuItem>();
        listadoItems.add(new MenuItem(android.R.drawable.ic_menu_send,"Recibidos"));
        listadoItems.add(new MenuItem(android.R.drawable.ic_menu_send,"Propuestas"));
        listadoItems.add(new MenuItem(android.R.drawable.ic_menu_send,"Completados"));

        final MenuAdapter gridAdapter = new MenuAdapter(this, listadoItems);
        items.setAdapter(gridAdapter);

    }

}
