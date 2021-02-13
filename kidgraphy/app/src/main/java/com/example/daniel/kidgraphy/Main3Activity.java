package com.example.daniel.kidgraphy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Main3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        recibirDatos();
    }

    @Override
    public void onBackPressed(){

    }

    public void recibirDatos(){
        int [] estados={R.drawable.correcto,R.drawable.incorrecto};
        Bundle extras= getIntent().getExtras();
        String pal= extras.getString("palabra");
        String sil= extras.getString("silabas");
        TextView Npalabra= (TextView)findViewById(R.id.palabra);
        Npalabra.setText(pal.toUpperCase());
        TextView sila= (TextView)findViewById(R.id.silabas);
        sila.setText(sil.toUpperCase());
        String estado= extras.getString("estado");
            ImageView ImEst = (ImageView) findViewById(R.id.resultadoimg);
            if (estado.equals("valido")) {
                ImEst.setImageResource(estados[0]);
            } else {
                ImEst.setImageResource(estados[1]);
            }
    }
    public void sig(View view) {
        Bundle extras= getIntent().getExtras();
        int triv=extras.getInt("trivia");
        int err=extras.getInt("errores");
        ArrayList <Integer> imgs=(ArrayList <Integer>)extras.getSerializable("imgs");
        String sig= extras.getString("sig");
        if(sig.equals("main2")) {
            if (triv < 10) {
                Intent siguiente = new Intent(this, Main2Activity.class);
                siguiente.putExtra("errores", err);
                siguiente.putExtra("trivia", triv);
                siguiente.putExtra("inicio", "iniciado");
                siguiente.putExtra("imgs",imgs);
                this.finish();
                startActivity(siguiente);
            } else {
                Intent next = new Intent(this, Main4Activity.class);
                next.putExtra("errores", err);
                this.finish();
                startActivity(next);
            }
        }
        else if(sig.equals("main5")){
            if (triv < 10) {
                Intent siguiente = new Intent(this, Main5Activity.class);
                siguiente.putExtra("errores", err);
                siguiente.putExtra("trivia", triv);
                siguiente.putExtra("inicio", "iniciado");
                siguiente.putExtra("imgs",imgs);
                this.finish();
                startActivity(siguiente);
            } else {
                Intent next = new Intent(this, Main4Activity.class);
                next.putExtra("errores", err);
                this.finish();
                startActivity(next);
            }
        }
        else{
            if (triv < 10) {
                Intent siguiente = new Intent(this, Main6Activity.class);
                siguiente.putExtra("errores", err);
                siguiente.putExtra("trivia", triv);
                siguiente.putExtra("inicio", "iniciado");
                siguiente.putExtra("imgs",imgs);
                this.finish();
                startActivity(siguiente);
            } else {
                Intent next = new Intent(this, Main4Activity.class);
                next.putExtra("errores", err);
                this.finish();
                startActivity(next);
            }
        }
    }
}
