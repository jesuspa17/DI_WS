package com.dam.salesianostriana.di.ejerciciospinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spi_equipos;

    Spinner spi_equipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spi_equipos = (Spinner) findViewById(R.id.spi_equipos);
        spi_equipo = (Spinner) findViewById(R.id.spi_equipo);

        this.darFormatoSpinner(spi_equipos, R.array.equipo);

        //evento al spinner
        spi_equipos.setOnItemSelectedListener(this);


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


   public void darFormatoSpinner(Spinner s, int array){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String seleccionado = (String) spi_equipos.getSelectedItem();

        if(seleccionado.equalsIgnoreCase("Real Madrid")){
            this.darFormatoSpinner(spi_equipo, R.array.real_madrid);

        }else if(seleccionado.equalsIgnoreCase("Barcelona")){

            this.darFormatoSpinner(spi_equipo, R.array.barcelona);

        }else if(seleccionado.equalsIgnoreCase("Betis")){
            this.darFormatoSpinner(spi_equipo, R.array.betis);

        }

        Toast.makeText(this, "Se ha seleccionado: "+seleccionado,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
