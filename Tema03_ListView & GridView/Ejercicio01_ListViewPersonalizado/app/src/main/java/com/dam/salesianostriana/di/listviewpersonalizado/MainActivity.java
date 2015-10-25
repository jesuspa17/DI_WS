package com.dam.salesianostriana.di.listviewpersonalizado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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
    private ListView listaToros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se rescata del Layout.
        listaToros = (ListView)findViewById(R.id.listView);

        //Se crea una lista de pruebas, en un futuro, llenaremos la lista con elementos
        //obtenidos de una Base de Datos.
        final ArrayList<Toro> listadoToros = new ArrayList<Toro>();
        listadoToros.add(new Toro(R.drawable.toro1,"Atrevido",500, "Pinto Barreiro", false));
        listadoToros.add(new Toro(R.drawable.toro2,"Pañolero",550, "Miura", true));
        listadoToros.add(new Toro(R.drawable.toro3,"Sedoso",600, "Álvaro Domeq", true));
        listadoToros.add(new Toro(R.drawable.toro4,"Avispado",535, "MJE Pallares", false));

        //Se da diseño a cada elemento de la lista creada anteriormente, con la clase Adapter diseñada.
        final ToroAdapter adaptador = new ToroAdapter(this,listadoToros);
        listaToros.setAdapter(adaptador);

        //Esto es para que cambie el icono de la lista. En este caso será de Vendido a No vendido.
        //Aquí se hace una cosa muy sencilla, pero podría implementarse otra cosa mas potente como que
        //al pulsar sobre algún elemento, nos lleve a otro Activity donde salieran los datos de cada elemento
        //más detallados.
        listaToros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //obtiene la posición del elemento que hemos seleccionado de la lista.
                Toro toroSeleccionado = listadoToros.get(position);
                if (toroSeleccionado.isVendido()) {
                    toroSeleccionado.setVendido(false);
                } else {
                    toroSeleccionado.setVendido(true);
                }
                //actualiza la lista.
                adaptador.notifyDataSetChanged();
            }
        });
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
