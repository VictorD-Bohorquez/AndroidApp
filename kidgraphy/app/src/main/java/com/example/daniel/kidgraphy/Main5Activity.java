package com.example.daniel.kidgraphy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class Main5Activity extends AppCompatActivity {
    private SelectorImg selector= new SelectorImg(this);
    private Validador valid = new Validador(this);
    private int pos;
    private int trivia;
    private int errores;
    private int contador=0;
    private boolean comp=false;
    private ArrayList<Integer> imgs;

    Handler handler=new Handler();
    Runnable runnable= new Runnable() {
    @Override
    public void run() {
        ProgressBar progreso=(ProgressBar) findViewById(R.id.Pcontador);
        metodotimer(progreso);
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        recibeErrores();
        while(comp==false) {
            pos = selector.seleccionarimagen(1);
            if (imgs.contains(pos) == false) {
                imgs.add(pos);
                comp=true;
            }
        }
        runnable.run();
    }
    @Override
    public void onBackPressed(){

    }
    public void recibeErrores(){
        Bundle extras= getIntent().getExtras();
        if(extras.getString("inicio").equals("iniciar"))
        {
            errores=0;
            trivia=0;
            imgs= new ArrayList<Integer>();
        }
        else {
            errores = extras.getInt("errores");
            trivia = extras.getInt("trivia");
            imgs=(ArrayList <Integer>)extras.getSerializable("imgs");
        }
    }
    public void Validar(View view){
        Intent siguiente= new Intent ( this,Main3Activity.class);
        trivia++;
        if(valid.validarEntrada(pos,2)==1){
            siguiente.putExtra("estado","valido");
            siguiente.putExtra("palabra",valid.darPalabra(pos));
            siguiente.putExtra("silabas",valid.darSilaba(pos));
            siguiente.putExtra("trivia",trivia);
            siguiente.putExtra("errores",errores);
            siguiente.putExtra("imgs",imgs);
            siguiente.putExtra("sig","main5");
            handler.removeCallbacks(runnable);
            this.finish();
            startActivity(siguiente);
        }
        else{
            errores++;
            siguiente.putExtra("estado","error");
            siguiente.putExtra("palabra",valid.darPalabra(pos));
            siguiente.putExtra("silabas",valid.darSilaba(pos));
            siguiente.putExtra("trivia",trivia);
            siguiente.putExtra("errores",errores);
            siguiente.putExtra("imgs",imgs);
            siguiente.putExtra("sig","main5");
            handler.removeCallbacks(runnable);
            this.finish();
            startActivity(siguiente);
        }
    }
    public void metodotimer(ProgressBar pro){
    contador++;
    pro.setProgress(100-contador*10);
    if(contador==10){
        Intent siguiente= new Intent ( this,Main3Activity.class);
        trivia++;
        errores++;
        siguiente.putExtra("estado","error");
        siguiente.putExtra("palabra",valid.darPalabra(pos));
        siguiente.putExtra("silabas",valid.darSilaba(pos));
        siguiente.putExtra("trivia",trivia);
        siguiente.putExtra("errores",errores);
        siguiente.putExtra("sig","main5");
        this.finish();
        handler.removeCallbacks(runnable);
        startActivity(siguiente);
    }
        handler.postDelayed(runnable,1000);
    }
    public void DarPista(View view){
        valid.darPista(pos,2);
    }
}


