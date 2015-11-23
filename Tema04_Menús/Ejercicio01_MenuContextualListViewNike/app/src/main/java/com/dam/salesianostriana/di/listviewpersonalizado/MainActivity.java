package com.dam.salesianostriana.di.listviewpersonalizado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Entregar un proyecto que contenga un ListView con un Adaptador personalizado
 * y que tenga asociado un menú contextual Flotante. El menú deberá tener 2 acciones:

 Editar: mostrar un Toast, indicando el nombre del elemento a Editar.
 Compartir: al hacer clic en esta opción deberá lanzarse la acción de compartir
 el nombre del elemento seleccionado en la red social que elija el usuario. Deberá hacerse con un Intent implícito.

 */

public class MainActivity extends AppCompatActivity {
    //Lista a rellenar.
    private ListView listaGym;
    ArrayList<EjercicioGimnasio> listadoEjercicioGimnasios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se rescata del Layout.
        listaGym = (ListView)findViewById(R.id.listView);

        //Se crea una lista de pruebas, en un futuro, llenaremos la lista con elementos
        //obtenidos de una Base de Datos.
        listadoEjercicioGimnasios = new ArrayList<EjercicioGimnasio>();
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

        registerForContextMenu(listaGym);

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
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);

        AdapterView.AdapterContextMenuInfo info;
        try {
            info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        } catch (ClassCastException e) {

            Log.e("TAG", "bad menuInfo", e);
            return;
        }
        String ejercicioSeleccionado = listadoEjercicioGimnasios.get(info.position).getNombre_ejercicio();
        menu.setHeaderTitle(ejercicioSeleccionado);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String ejercicioSeleccionado = listadoEjercicioGimnasios.get(info.position).getNombre_ejercicio();
        switch (item.getItemId()){
            case R.id.compartir:

                Intent share = new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT, ejercicioSeleccionado);
                share.setType("text/plain");
                startActivity(share);

                return true;
            case R.id.seleccionar:
                Toast.makeText(MainActivity.this,"Seleccionado " +ejercicioSeleccionado,Toast.LENGTH_SHORT).show();

                return true;
            default:
                return super.onContextItemSelected(item);

        }


    }
}
