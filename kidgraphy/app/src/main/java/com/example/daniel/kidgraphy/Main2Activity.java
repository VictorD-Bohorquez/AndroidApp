package com.example.daniel.kidgraphy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class Main2Activity extends AppCompatActivity {

    private SelectorImg selector= new SelectorImg(this);
    private Validador valid = new Validador(this);
    private int pos;
    private int trivia;
    private int errores;
    private ArrayList <Integer> imgs;
    private boolean comp=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        recibeErrores();
        while(comp==false) {
            pos = selector.seleccionarimagen();
            if (imgs.contains(pos) == false) {
                imgs.add(pos);
                comp=true;
            }
        }
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
       if(valid.validarEntrada(pos)==1){
           siguiente.putExtra("estado","valido");
           siguiente.putExtra("palabra",valid.darPalabra(pos));
           siguiente.putExtra("silabas",valid.darSilaba(pos));
           siguiente.putExtra("trivia",trivia);
           siguiente.putExtra("errores",errores);
           siguiente.putExtra("imgs",imgs);
           siguiente.putExtra("sig","main2");
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
           siguiente.putExtra("sig","main2");
           startActivity(siguiente);
       }
    }

    public void DarPista(View view){
        valid.darPista(pos);
    }
}
