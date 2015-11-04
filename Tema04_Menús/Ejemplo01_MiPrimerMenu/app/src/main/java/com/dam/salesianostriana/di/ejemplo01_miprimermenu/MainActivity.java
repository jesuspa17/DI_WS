package com.dam.salesianostriana.di.ejemplo01_miprimermenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        String mensaje = "";
        //noinspection SimplifiableIfStatement
        switch(id) {
            case R.id.action_salir:
                mensaje = "Salir...";
                break;
            case R.id.action_configuration:
                mensaje = "Configurar...";
                break;
            case R.id.action_nueva_pestanya_incógnito:
                mensaje = "Nueva pestaña...";
                break;
            case R.id.action_search:
                mensaje = "Buscar...";
                break;
        }

        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
