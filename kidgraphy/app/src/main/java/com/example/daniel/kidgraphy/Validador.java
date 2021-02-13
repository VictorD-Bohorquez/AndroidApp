package com.example.daniel.kidgraphy;

import android.app.Activity;
import android.widget.EditText;

public class Validador {
    public Activity activity;
    private Diccionario diccionario;
    public Validador(Activity a) {
        this.activity=a;
        diccionario= new Diccionario();
    }

    public int validarEntrada(int posicion){
        EditText En= (EditText)this.activity.findViewById(R.id.entradaIm);
        String Entrada= (En.getText()).toString();
        Entrada= Entrada.toLowerCase();
        if(Entrada.equals(diccionario.getPalabra(posicion))){
            return 1;
        }
        else{
            return 0;
        }
    }

    public void darPista(int posicion){
        EditText Entrada= (EditText)this.activity.findViewById(R.id.entradaIm);
        Entrada.setText("");
        Entrada.setHint(diccionario.getPista(posicion));
    }

    public void darPista(int posicion, int a){
        EditText Entrada= (EditText)this.activity.findViewById(R.id.EntradaT);
        Entrada.setText("");
        Entrada.setHint(diccionario.getPista(posicion));
    }
    public int validarEntrada(int posicion, int a){
        EditText En= (EditText)this.activity.findViewById(R.id.EntradaT);
        String Entrada= (En.getText()).toString();
        Entrada= Entrada.toLowerCase();
        if(Entrada.equals(diccionario.getPalabra(posicion))){
            return 1;
        }
        else{
            return 0;
        }
    }
    public int validarEntrada(int posicion,String a){
        String Entrada= a;
        if(Entrada.equals(diccionario.getPalabra(posicion))){
            return 1;
        }
        else{
            return 0;
        }
    }


    public String darPalabra(int posicion){
        return diccionario.getPalabra(posicion);
    }
    public String darSilaba(int posicion){
        return diccionario.getSilaba(posicion);
    }
}
