package com.salesianostriana.dam.di.butterknife;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    /**
     * La libreria ButterKnife está cargada el el archivo build.gradle(Module:app)
     */

    @Bind(R.id.txtHelloWorld)
    TextView holaMundo;

    @BindString(R.id.txtHelloWorld)
    String saludo;

    @Bind(R.id.btn_like)
    ImageButton bot;

    @Bind(R.drawable.ic_action_name)
    Drawable up;

    @Bind(R.drawable.ic_action_name2)
    Drawable down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vincular los binds a la interfaz.
        ButterKnife.bind(this);

        holaMundo.setText(getResources().getString(R.string.hello_world));

        holaMundo.setText(saludo);


        //Para un Toast tendría 3 formas de pasarle el String

        //1. De manera nativa, obteniendo un string:
        String stringSaludo = getResources().getString(R.string.hello_world);
        Toast.makeText(this, stringSaludo, Toast.LENGTH_SHORT).show();

        //2. De manera nativa pasando la referencia de un String (R.string.hello_world)
        Toast.makeText(this,R.string.hello_world, Toast.LENGTH_SHORT).show();

        //3. Con un ButtterKnife, pasandole la variable declarada con la anotacion @BindString

        Toast.makeText(this,saludo,Toast.LENGTH_SHORT).show();



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

    @OnClick(R.id.btn_like)
    public void submit(View view){
        ImageButton btn = (ImageButton) view;
        if(btn.getDrawable().equals(getDrawable(R.drawable.ic_action_name))){
            btn.setImageDrawable(getDrawable(R.drawable.ic_action_name2));

        }else{
            btn.setImageDrawable(getDrawable(R.drawable.ic_action_name));
        }

    }

}
