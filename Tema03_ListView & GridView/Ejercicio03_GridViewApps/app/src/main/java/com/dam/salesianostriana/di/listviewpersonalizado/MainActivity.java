package com.dam.salesianostriana.di.listviewpersonalizado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

/**
 Listview personalizado - 23/10/2015

     En este ejercicio se pretende que el alumno diseñe e implemente un ListView personalizado,
     basándose en el ejemplo expuesto en clase y que puede encontrarse en GitHub: "ListViewCustom_ListaClase"
     https://github.com/camposmiguel/di/tree/master/03_Listas/02_ListViewCustom_ListaClase

     Queda a la elección del alumno elegir la temática del ListView (un poco de originalidad no estaría mal)
     y los iconos que utilizará para cada elemento de la lista.

     AMPLIACIÓN: implentar cebreado en el fondo de cada elemento. De manera que los elemento del ListView
     que ocupen una posición par tengan un color de fondo y los que ocupen una posición impar otro color de fondo.

     IMPORTANTE: Entregar el ejercicio en un fichero comprimido, cuyo nombre debe ser apellido1_apellido2_nombre.zip,
     en el que se incluya el proyecto implementado.
 */

public class MainActivity extends AppCompatActivity {
    //Lista a rellenar.
    private GridView listaToros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se rescata del Layout.
        listaToros = (GridView)findViewById(R.id.listView);

        //Se crea una lista de pruebas, en un futuro, llenaremos la lista con elementos
        //obtenidos de una Base de Datos.
        final ArrayList<App> listadoApps = new ArrayList<App>();
        listadoApps.add(new App(R.drawable.twitter,"Twitter"));
        listadoApps.add(new App(R.drawable.facebook,"Facebook"));
        listadoApps.add(new App(R.drawable.instagram,"Instagram"));
        listadoApps.add(new App(R.drawable.steam,"Steam"));
        listadoApps.add(new App(R.drawable.whatsapp,"WhatsApp"));
        listadoApps.add(new App(R.drawable.youtube,"Youtube"));
        listadoApps.add(new App(R.drawable.playstore,"Play Store"));
        listadoApps.add(new App(R.drawable.skype,"Skype"));


        //Se da diseño a cada elemento de la lista creada anteriormente, con la clase Adapter diseñada.
        final AppAdapter adaptador = new AppAdapter(this, listadoApps);
        listaToros.setAdapter(adaptador);

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
