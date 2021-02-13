package com.example.daniel.kidgraphy;

import java.util.ArrayList;
import java.util.Collections;

public class Diccionario {
    private ArrayList<String> palabras=new ArrayList<String>();
    private ArrayList<String> silabas=new ArrayList<String>();
    private ArrayList<String> pistas=new ArrayList<String>();
    public Diccionario() {
        Collections.addAll(palabras,"perro","gato","oso","jirafa","elefante","piña","vaca","pato","naranja","plátano","manzana",
                "duende","pastel","loro","reloj","helado","espada","caracol");
        Collections.addAll(silabas,"pe - rro","ga - to","o - so","ji - ra - fa","e - le- fan - te","pi - ña","va - ca","pa - to",
                "na - ran - ja","plá - ta - no","man - za - na","duen - de","pas - tel","lo - ro", "re - loj","he - la - do",
                "es - pa - da","ca - ra - col");
        Collections.addAll(pistas,"p*r*o","g*t*","*s*","*ir*f*","*le*a*t*","p**a","*a*a","p*t*","*a*ra**a","p*a***o","m*n***a","*u*n**",
                "p**t*l","*or*","re*o*","*el**o","e**a*a","ca**c**");
    }

    public String getPalabra(int posicion){
        return palabras.get(posicion);
    }

    public String getSilaba(int posicion){
        return silabas.get(posicion);
    }

    public String getPista(int posicion){
        return pistas.get(posicion);
    }
}
