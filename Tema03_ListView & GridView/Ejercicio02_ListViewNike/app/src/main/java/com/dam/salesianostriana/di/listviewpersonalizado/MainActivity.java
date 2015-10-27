package com.dam.salesianostriana.di.listviewpersonalizado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

/**
 ListView personalizado: Nike - 26/10/2015
 */

public class MainActivity extends AppCompatActivity {
    //Lista a rellenar.
    private ListView listaGym;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se rescata del Layout.
        listaGym = (ListView)findViewById(R.id.listView);

        //Se crea una lista de pruebas, en un futuro, llenaremos la lista con elementos
        //obtenidos de una Base de Datos.
        final ArrayList<EjercicioGimnasio> listadoEjercicioGimnasios = new ArrayList<EjercicioGimnasio>();
        listadoEjercicioGimnasios.add(new EjercicioGimnasio(R.drawable.tim,"SWEAT + SHAPE",30));
        listadoEjercicioGimnasios.add(new EjercicioGimnasio(R.drawable.tim,"SLIM CHANCE",30));
        listadoEjercicioGimnasios.add(new EjercicioGimnasio(R.drawable.tim,"FIGHTER FIT",30));
        listadoEjercicioGimnasios.add(new EjercicioGimnasio(R.drawable.tim,"JUMP START",30));
        listadoEjercicioGimnasios.add(new EjercicioGimnasio(R.drawable.tim,"HURRICANE",45));
        listadoEjercicioGimnasios.add(new EjercicioGimnasio(R.drawable.tim,"CRUNCH + BURN",45));
        listadoEjercicioGimnasios.add(new EjercicioGimnasio(R.drawable.tim,"CARDIO SURJE",45));

        //Se da diseño a cada elemento de la lista creada anteriormente, con la clase Adapter diseñada.
        final GimnasioAdapter adaptador = new GimnasioAdapter(this, listadoEjercicioGimnasios);
        listaGym.setAdapter(adaptador);

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
}
