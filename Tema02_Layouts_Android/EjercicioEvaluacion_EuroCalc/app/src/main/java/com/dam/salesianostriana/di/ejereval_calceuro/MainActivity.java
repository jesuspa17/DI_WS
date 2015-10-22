package com.dam.salesianostriana.di.ejereval_calceuro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText numeros_convertir;
    Button btn_uno;
    Button btn_dos;
    Button btn_tres;
    Button btn_cuatro;
    Button btn_cinco;
    Button btn_seis;
    Button btn_siete;
    Button btn_ocho;
    Button btn_nueve;
    Button btn_clear;
    Button btn_cero;
    Button btn_coma;

    Button euroToPta;
    Button ptaToEuro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numeros_convertir = (EditText) findViewById(R.id.edit_numeros);
        btn_uno = (Button) findViewById(R.id.btn_uno);
        btn_dos = (Button) findViewById(R.id.btn_dos);
        btn_tres = (Button) findViewById(R.id.btn_tres);
        btn_cuatro = (Button) findViewById(R.id.btn_cuatro);
        btn_cinco = (Button) findViewById(R.id.btn_cinco);
        btn_seis = (Button) findViewById(R.id.btn_seis);
        btn_siete = (Button) findViewById(R.id.btn_siete);
        btn_ocho = (Button) findViewById(R.id.btn_ocho);
        btn_nueve = (Button) findViewById(R.id.btn_nueve);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_cero = (Button) findViewById(R.id.btn_cero);
        btn_coma = (Button) findViewById(R.id.btn_coma);

        euroToPta = (Button) findViewById(R.id.btn_eurToPta);
        ptaToEuro = (Button) findViewById(R.id.btn_ptoToEur);


        btn_uno.setOnClickListener(this);
        btn_dos.setOnClickListener(this);
        btn_tres.setOnClickListener(this);
        btn_cuatro.setOnClickListener(this);
        btn_cinco.setOnClickListener(this);
        btn_seis.setOnClickListener(this);
        btn_siete.setOnClickListener(this);
        btn_ocho.setOnClickListener(this);
        btn_nueve.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_cero.setOnClickListener(this);
        btn_coma.setOnClickListener(this);
        euroToPta.setOnClickListener(this);
        ptaToEuro.setOnClickListener(this);


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
        String num = String.valueOf(numeros_convertir.getText());

        int id = v.getId();

        StringBuffer txt = new StringBuffer(num);

        switch (id) {
            case R.id.btn_cero:
                numeros_convertir.setText(txt.append(btn_cero.getText().toString()));
                break;
            case R.id.btn_uno:
                numeros_convertir.setText(txt.append(btn_uno.getText().toString()));
                break;
            case R.id.btn_dos:
                numeros_convertir.setText(txt.append(btn_dos.getText().toString()));
                break;
            case R.id.btn_tres:
                numeros_convertir.setText(txt.append(btn_tres.getText().toString()));
                break;
            case R.id.btn_cuatro:
                numeros_convertir.setText(txt.append(btn_cuatro.getText().toString()));
                break;
            case R.id.btn_cinco:
                numeros_convertir.setText(txt.append(btn_cinco.getText().toString()));
                break;
            case R.id.btn_seis:
                numeros_convertir.setText(txt.append(btn_seis.getText().toString()));
                break;
            case R.id.btn_siete:
                numeros_convertir.setText(txt.append(btn_siete.getText().toString()));
                break;
            case R.id.btn_ocho:
                numeros_convertir.setText(txt.append(btn_ocho.getText().toString()));
                break;
            case R.id.btn_nueve:
                numeros_convertir.setText(txt.append(btn_nueve.getText().toString()));
                break;
            case R.id.btn_clear:
                if(numeros_convertir.getText().toString().isEmpty()){
                    Toast.makeText(this,"No puede borrar más", Toast.LENGTH_LONG).show();
                }else {
                    this.borrarNumero(numeros_convertir, numeros_convertir.getText().toString());
                }
                break;
            case R.id.btn_coma:
                if(numeros_convertir.getText().toString().contains(".")){
                    Toast.makeText(this,"No puede meter más comas", Toast.LENGTH_LONG).show();
                }else {
                    numeros_convertir.setText(txt.append(btn_coma.getText().toString()));
                }
                break;
            case R.id.btn_eurToPta:

                if(numeros_convertir.getText().toString().equalsIgnoreCase(".") || numeros_convertir.getText().toString().isEmpty()){
                    Toast.makeText(this,"Cifra no válida", Toast.LENGTH_LONG).show();
                }else{
                    numeros_convertir.setText(this.convertirEuroToPta(Double.parseDouble(numeros_convertir.getText().toString())));
                }



                break;

            case R.id.btn_ptoToEur:
                if(numeros_convertir.getText().toString().equalsIgnoreCase(".") || numeros_convertir.getText().toString().isEmpty()){
                    Toast.makeText(this,"Cifra no válida", Toast.LENGTH_LONG).show();
                }else {

                    numeros_convertir.setText(this.convertirPtaToEuro(Double.parseDouble(numeros_convertir.getText().toString())));
                }

                break;

        }



    }

    final double pesetas = 166.386;

    public void borrarNumero(TextView v, String cadena){
        String cadena_nueva= "";
        cadena_nueva = cadena.substring(0, cadena.length()-1);
        v.setText(cadena_nueva);

    }
    public String convertirPtaToEuro(double cant){
        double pesetas = 166.386;
        double total_euros = cant / pesetas;
        return String.valueOf(total_euros);
    }

    public String convertirEuroToPta(double cant){
        double total_pesetas = pesetas *cant;
        return String.valueOf(total_pesetas);
    }
}
