package com.salesianostriana.di.ejercicio03_toastmejorado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button send;
    private EditText name;
    private EditText edad;
    private TextView textEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Rescato el botón enviar y el editText de nombre
        send = (Button) findViewById(R.id.button_send);
        name = (EditText) findViewById(R.id.editTextName);
        edad = (EditText) findViewById(R.id.editTextEdad);
        textEdad = (TextView) findViewById(R.id.textViewEdad);

        //asocio al botón el evento OnClickListener
        //que tengo asociado en esta clase.
        send.setOnClickListener(this);

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
    public void onClick(View v) {
        String cadena = name.getText().toString();

     

        if (cadena.isEmpty()) {

        } else {
            Toast.makeText(this, "Encantado de conocerte, " + cadena, Toast.LENGTH_SHORT).show();
        }

        if (edad.getText().toString().isEmpty()) {

        } else {

            int miEdad = Integer.parseInt(edad.getText().toString());
            if (miEdad >= 35) {
                Toast.makeText(this, "Qué puretilla", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Eres un Yogurín", Toast.LENGTH_SHORT).show();
            }
        }

    }


}

