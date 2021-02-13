package com.example.daniel.kidgraphy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        recibeResultados();
    }
    @Override
    public void onBackPressed(){

    }

    public void recibeResultados(){
        Bundle extras= getIntent().getExtras();
        int errores=extras.getInt("errores");
        TextView errorestotales= (TextView)findViewById(R.id.aciertos);
        errorestotales.setText(10-errores+"/10");
        TextView sg= (TextView)findViewById(R.id.sugerencia);
        TextView mv= (TextView)findViewById(R.id.mtv);
        if(errores==0){
            mv.setText("PERFECTO");
            sg.setText("¡Excelente Desempeño!.\nEstas enfocado en lo que realizas.\nPresentas una alta capacidad de relacionar tu entorno con tu respuesta\nDominas y presentas una buena concentración en las actividades que realizas\n¡Sigue asi!");
        }
        if(errores<3&&errores>0)
        {
            mv.setText("FELICIDADES");
            sg.setText("¡Excelente Desempeño!.\nEstas enfocado en lo que realizas.\nPresentas una alta capacidad de relacionar tu entorno con tu respuesta\nSigue así y no dejes de practicar =)");
        }
        if(errores<6&&errores>2)
        {
            mv.setText("BUEN TRABAJO");
            sg.setText("¡Muy bien!.\nNecesitas practicar un poco más ;)\n Tu capacidad de relacionar imagenes con palabras es buena.\nPero debes practicar mas pues no esta desarrollada a toda su capacidad," +
                    "debido a un deficit de atención o una posible dificultad de retención de información\n");
        }
        if(errores>5&&errores<8)
        {
            mv.setText("NECESITAS MÁS PRÁCTICA");
            sg.setText("Necesitas un poco mas de práctica ;).\nHay que practicar para mejorar los resultados.\nPor ahora hay que enfocarnos en mejorar los aciertos y no el tiempo de respuesta.\nPresentas una falta de interes en la actividad " +
                    "\nTe recomendamos practicar en el modo de juego.");
        }
        if(errores>7&&errores<10)
        {
            mv.setText("TENEMOS PROBLEMAS");
            sg.setText("Necesitas practicar más ;).\nSe presenta un claro deficit de atención en lo que escribes o lo que ves.\nPor ahora hay que enfocarnos en mejorar los aciertos y no el tiempo de respuesta.\nTe recomendamos practicar en el modo de juego." +
                    "\nEs recomendable que practiques en compañia de un adulto ;)");
        }
        if(errores==10){
            mv.setText("CONSIGAMOS AYUDA");
            sg.setText("A partir de ahora es necesario que practiques en compañia de un adulto ;).\nSe presenta un claro deficit de atención en lo que escribes o lo que ves.\nAdemás se te dificulta relacionar las imágenes con palabras,\nposiblemente porque apenas estas aprendiendo a escribir ;).\nTe recomendamos practicar en el modo de juego." +
                    "\nNecesitas practicar más, tómate tu tiempo ;)");
        }
    }

    public void sig(View view) {
        Intent next= new Intent ( this,MainActivity.class);
        this.finish();
        startActivity(next);
    }
}
