package com.example.daniel.kidgraphy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Main6Activity extends AppCompatActivity {
    private SelectorImg selector= new SelectorImg(this);
    private Validador valid = new Validador(this);
    private int pos;
    private int trivia;
    private int errores;
    private ArrayList<Integer> imgs;
    private boolean comp=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        recibeErrores();
        while(comp==false) {
            pos = selector.seleccionarimagen("a");
            if (imgs.contains(pos) == false) {
                imgs.add(pos);
                comp=true;
            }
        }
        respuestas();
    }

    @Override
    public void onBackPressed(){

    }

    public void respuestas(){
        Button [] ar={findViewById(R.id.op1),findViewById(R.id.op2),findViewById(R.id.op3),findViewById(R.id.op4)};
        int good=(int)(Math.random() * 4);
        ar[good].setText(valid.darPalabra(pos));
        for(int i=0;i<4;i++){
            if(i!=good){
                int aleatorio=(int)(Math.random() * 18);
                ar[i].setText(valid.darPalabra(aleatorio));
            }
        }
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
    public void Validar1(View view){
        Button a= findViewById(R.id.op1);
        String entrada= (String)a.getText();
        Intent siguiente= new Intent ( this,Main3Activity.class);
        trivia++;
        if(valid.validarEntrada(pos,entrada)==1){
            siguiente.putExtra("estado","valido");
            siguiente.putExtra("palabra",valid.darPalabra(pos));
            siguiente.putExtra("silabas",valid.darSilaba(pos));
            siguiente.putExtra("trivia",trivia);
            siguiente.putExtra("errores",errores);
            siguiente.putExtra("imgs",imgs);
            siguiente.putExtra("sig","main6");
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
            siguiente.putExtra("sig","main6");
            startActivity(siguiente);
        }
    }
    public void Validar2(View view){
        Button a= findViewById(R.id.op2);
        String entrada= (String)a.getText();
        Intent siguiente= new Intent ( this,Main3Activity.class);
        trivia++;
        if(valid.validarEntrada(pos,entrada)==1){
            siguiente.putExtra("estado","valido");
            siguiente.putExtra("palabra",valid.darPalabra(pos));
            siguiente.putExtra("silabas",valid.darSilaba(pos));
            siguiente.putExtra("trivia",trivia);
            siguiente.putExtra("errores",errores);
            siguiente.putExtra("imgs",imgs);
            siguiente.putExtra("sig","main6");
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
            siguiente.putExtra("sig","main6");
            startActivity(siguiente);
        }
    }
    public void Validar3(View view){
        Button a= findViewById(R.id.op3);
        String entrada= (String)a.getText();
        Intent siguiente= new Intent ( this,Main3Activity.class);
        trivia++;
        if(valid.validarEntrada(pos,entrada)==1){
            siguiente.putExtra("estado","valido");
            siguiente.putExtra("palabra",valid.darPalabra(pos));
            siguiente.putExtra("silabas",valid.darSilaba(pos));
            siguiente.putExtra("trivia",trivia);
            siguiente.putExtra("errores",errores);
            siguiente.putExtra("imgs",imgs);
            siguiente.putExtra("sig","main6");
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
            siguiente.putExtra("sig","main6");
            startActivity(siguiente);
        }
    }
    public void Validar4(View view){
        Button a= findViewById(R.id.op4);
        String entrada= (String)a.getText();
        Intent siguiente= new Intent ( this,Main3Activity.class);
        trivia++;
        if(valid.validarEntrada(pos,entrada)==1){
            siguiente.putExtra("estado","valido");
            siguiente.putExtra("palabra",valid.darPalabra(pos));
            siguiente.putExtra("silabas",valid.darSilaba(pos));
            siguiente.putExtra("trivia",trivia);
            siguiente.putExtra("errores",errores);
            siguiente.putExtra("imgs",imgs);
            siguiente.putExtra("sig","main6");
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
            siguiente.putExtra("sig","main6");
            startActivity(siguiente);
        }
    }
}
