package com.dam.salesianostriana.di.listviewllamadas;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

/**
 *
 ListView personalizado: Gestión de Llamadas App - 27/10/2015

 */

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Llamada> llamadas = new ArrayList<Llamada>();
        llamadas.add(new Llamada(955718480,"10:30pm","Feb 23","2m 2s","realizada"));
        llamadas.add(new Llamada(664595724,"11:55pm","Abr 12","5m 5s","recibida"));
        llamadas.add(new Llamada(629885871,"8:30pm","Sep 05","0m 0s","perdida"));
        LlamadaAdapter adaptador = new LlamadaAdapter(this, llamadas);

        getListView().setAdapter(adaptador);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

    }
}
