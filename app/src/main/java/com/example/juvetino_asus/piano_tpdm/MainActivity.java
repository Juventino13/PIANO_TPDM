package com.example.juvetino_asus.piano_tpdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        acercadetButton();
        pianoButton();
        informacioButton();
        notasButton();

    }

    private void notasButton() {
        Button acercade= (Button) findViewById(R.id.infonotas);
        acercade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainActivity.this,Main3Activity.class));
            }
        });
    }

    private void informacioButton() {
        Button acercade= (Button) findViewById(R.id.infopiano);
        acercade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainActivity.this,Main2Activity.class));
            }
        });
    }


    private void pianoButton() {
        Button acercade= (Button) findViewById(R.id.piano);
        acercade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainActivity.this,Main4Activity.class));
            }
        });
    }



    private void acercadetButton() {
        Button acercade= (Button) findViewById(R.id.Acercade);
        acercade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent( MainActivity.this,Main5Activity.class));
            }
        });
    }

}
