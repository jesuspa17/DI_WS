package com.salesianostriana.dam.di.mydial;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView textViewNumTlf;
    private String telefono;
    private Button uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero, almoadilla, asterisco;
    private ImageButton sms, llamar, borrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Rescatamos los elementos de la UI
        uno = (Button) findViewById(R.id.btn_uno);
        dos = (Button) findViewById(R.id.btn_dos);
        tres = (Button) findViewById(R.id.btn_tres);
        cuatro = (Button) findViewById(R.id.btn_cuatro);
        cinco = (Button) findViewById(R.id.btn_cinco);
        seis = (Button) findViewById(R.id.btn_seis);
        siete = (Button) findViewById(R.id.btn_siete);
        ocho = (Button) findViewById(R.id.btn_ocho);
        nueve = (Button) findViewById(R.id.btn_nueve);
        cero = (Button) findViewById(R.id.btn_cero);
        almoadilla = (Button) findViewById(R.id.btn_almoadilla);
        asterisco = (Button) findViewById(R.id.btn_asterisco);


        sms = (ImageButton) findViewById(R.id.btn_send);
        llamar = (ImageButton) findViewById(R.id.btn_llamar);
        borrar = (ImageButton) findViewById(R.id.btn_borrar);

        textViewNumTlf = (TextView) findViewById(R.id.textViewNumTlf);

        Uri data = getIntent().getData();
        if (data != null && ("tel".equals(data.getScheme()))) {
            telefono = PhoneNumberUtils.getNumberFromIntent(getIntent(), this);
        }

        cero.setOnClickListener(this);
        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        siete.setOnClickListener(this);
        ocho.setOnClickListener(this);
        nueve.setOnClickListener(this);


        sms.setOnClickListener(this);
        llamar.setOnClickListener(this);
        borrar.setOnClickListener(this);
        almoadilla.setOnClickListener(this);
        asterisco.setOnClickListener(this);




        textViewNumTlf.setText(telefono);
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

    public void borrarNumero(TextView v, String cadena){
        String cadena_nueva= "";
        cadena_nueva = cadena.substring(0, cadena.length()-1);
        v.setText(cadena_nueva);

    }
    boolean llamando = true;
    @Override
    public void onClick(View v) {
        String num = String.valueOf(textViewNumTlf.getText());

        int id = v.getId();

        StringBuffer txt = new StringBuffer(num);

        switch (id){
            case R.id.btn_cero:
                textViewNumTlf.setText(txt.append(cero.getText().toString()));
                break;
            case R.id.btn_uno:
                textViewNumTlf.setText(txt.append(uno.getText().toString()));
                break;
            case R.id.btn_dos:
                textViewNumTlf.setText(txt.append(dos.getText().toString()));
                break;
            case R.id.btn_tres:
                textViewNumTlf.setText(txt.append(tres.getText().toString()));
                break;
            case R.id.btn_cuatro:
                textViewNumTlf.setText(txt.append(cuatro.getText().toString()));
                break;
            case R.id.btn_cinco:
                textViewNumTlf.setText(txt.append(cinco.getText().toString()));
                break;
            case R.id.btn_seis:
                textViewNumTlf.setText(txt.append(seis.getText().toString()));
                break;
            case R.id.btn_siete:
                textViewNumTlf.setText(txt.append(siete.getText().toString()));
                break;
            case R.id.btn_ocho:
                textViewNumTlf.setText(txt.append(ocho.getText().toString()));
                break;
            case R.id.btn_nueve:
                textViewNumTlf.setText(txt.append(nueve.getText().toString()));
                break;
            case R.id.btn_asterisco:
                textViewNumTlf.setText(txt.append(asterisco.getText().toString()));
                break;
            case R.id.btn_almoadilla:
                textViewNumTlf.setText(txt.append(almoadilla.getText().toString()));
                break;
            case R.id.btn_borrar:
                if(txt.toString().isEmpty()){

                }else{
                    borrarNumero(textViewNumTlf,num);
                }
                break;
            case R.id.btn_llamar:

                /*Uri number = Uri.parse("tel:"+num);
                Intent callIntent = new Intent(Intent.ACTION_CALL, number);
                startActivity(callIntent);
                */
                if(num.isEmpty()){

                }else{
                    if(llamando){
                        llamar.setImageResource(R.drawable.colgado);
                        Toast.makeText(this, "LLamando...",Toast.LENGTH_SHORT).show();
                        llamando = false;
                    }else{
                        llamar.setImageResource(R.drawable.llamada);
                        Toast.makeText(this, "LLamada finalizada",Toast.LENGTH_SHORT).show();
                        llamando = true;

                    }

                }

                break;
            case R.id.btn_send:

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, "Mensaje para " + num);
                startActivity(i);

                break;




        }




    }
}
