package com.example.daniel.kidgraphy;

import android.app.Activity;
import android.widget.ImageView;

import java.util.Random;

public class SelectorImg {
    private int [] imagenes ={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7,
            R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a11,R.drawable.a12,R.drawable.a13,R.drawable.a14,R.drawable.a15,
            R.drawable.a16,R.drawable.a17,R.drawable.a18};
    public Activity activity;
    public SelectorImg(Activity a){
        this.activity=a;

    }
    public int seleccionarimagen() {
        ImageView imagenEn=(ImageView)this.activity.findViewById(R.id.imageE);
        // Random numero= new Random();
        int posicion=(int)(Math.random() * 18);
        imagenEn.setImageResource(imagenes[posicion]);
        return posicion;
    }
    public int seleccionarimagen(int a) {
        ImageView imagenEn=(ImageView)this.activity.findViewById(R.id.imageT);
        // Random numero= new Random();
        int posicion=(int)(Math.random() * 18);
        imagenEn.setImageResource(imagenes[posicion]);
        return posicion;
    }
    public int seleccionarimagen(String a) {
        ImageView imagenEn=(ImageView)this.activity.findViewById(R.id.imageM);
        // Random numero= new Random();
        int posicion=(int)(Math.random() * 18);
        imagenEn.setImageResource(imagenes[posicion]);
        return posicion;
    }
}
