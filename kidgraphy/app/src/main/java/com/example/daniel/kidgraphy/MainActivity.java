package com.example.daniel.kidgraphy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void onBackPressed(){

    }

    public void iniciarapp(View view) {
        Intent siguiente= new Intent ( this,Main2Activity.class);
        siguiente.putExtra("inicio","iniciar");
        this.finish();
        startActivity(siguiente);
    }
    public void contraR(View view) {
        Intent siguiente= new Intent ( this,Main5Activity.class);
        siguiente.putExtra("inicio","iniciar");
        this.finish();
        startActivity(siguiente);
    }
    public void multiple(View view) {
        Intent siguiente= new Intent ( this,Main6Activity.class);
        siguiente.putExtra("inicio","iniciar");
        this.finish();
        startActivity(siguiente);
    }
}
