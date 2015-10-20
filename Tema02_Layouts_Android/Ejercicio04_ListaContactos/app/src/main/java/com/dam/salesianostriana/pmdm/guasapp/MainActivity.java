package com.dam.salesianostriana.pmdm.guasapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    ImageButton btn_miguel, btn_jesus, btn_llamarMiguel, btn_llamarJesus;
    TextView tlf_miguel, tlf_jesus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_miguel = (ImageButton) findViewById(R.id.enviarMiguel);
        btn_jesus = (ImageButton) findViewById(R.id.enviarJesus);

        tlf_miguel = (TextView) findViewById(R.id.tlf_miguel);
        tlf_jesus = (TextView) findViewById(R.id.tlf_jesus);

        btn_llamarMiguel = (ImageButton) findViewById(R.id.btn_llamarMiguel);
        btn_llamarJesus = (ImageButton) findViewById(R.id.btn_llamarJesus);


        btn_miguel.setOnClickListener(this);
        btn_jesus.setOnClickListener(this);
        btn_llamarMiguel.setOnClickListener(this);
        btn_llamarJesus.setOnClickListener(this);
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

    public String obtenerNumero(View v) {
        String telefono = "";
        if (v.getId() == R.id.enviarMiguel ||v.getId() == R.id.btn_llamarMiguel ) {
            telefono = tlf_miguel.getText().toString();
            return telefono;
        } else if (v.getId() == R.id.enviarJesus || v.getId() == R.id.btn_llamarJesus ) {
            telefono = tlf_jesus.getText().toString();
            return telefono;
        }
        return "";
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.enviarMiguel || id == R.id.enviarJesus) {

            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT, "Mensaje para " + obtenerNumero(v));
            startActivity(i);

        } else if (id == R.id.btn_llamarJesus || id == R.id.btn_llamarMiguel) {

            Uri datos = Uri.parse("tel:" + obtenerNumero(v));
            Intent i = new Intent(Intent.ACTION_DIAL, datos);
            startActivity(i);

        }

    }
}
