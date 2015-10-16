package com.salesianostriana.dam.di.jesuspallares_ejerevaldi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText usuario;
    EditText contrasenya;

    CheckBox terminos;
    Button entrar;

    String nombre;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = "admin";
        pass = "1234";

        usuario = (EditText) findViewById(R.id.editUsuario);
        contrasenya = (EditText) findViewById(R.id.editPassword);
        terminos  = (CheckBox) findViewById(R.id.cb_terminos);
        entrar = (Button) findViewById(R.id.btn_login);

        entrar.setOnClickListener(this);



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
        int id = v.getId();

        if(id == R.id.btn_login){
            if(usuario.getText().toString().equalsIgnoreCase(nombre) && contrasenya.getText().toString().equals(pass) && terminos.isChecked()){
                Toast.makeText(this, "Usuario logeado correctamente", Toast.LENGTH_SHORT).show();
            }else if(usuario.getText().toString().isEmpty() || contrasenya.getText().toString().isEmpty()){
                Toast.makeText(this, "Rellene campos del formulario", Toast.LENGTH_SHORT).show();
            }else if(usuario.getText().toString().equalsIgnoreCase(nombre) && contrasenya.getText().toString().equals(pass) && !terminos.isChecked()){
                Toast.makeText(this, "Debe aceptar terminos y condiciones", Toast.LENGTH_SHORT).show();
            }else if((!usuario.getText().toString().equalsIgnoreCase(nombre) || !contrasenya.getText().toString().equals(pass)) && terminos.isChecked()){
                Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
