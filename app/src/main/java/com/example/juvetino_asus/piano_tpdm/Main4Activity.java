package com.example.juvetino_asus.piano_tpdm;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Main4Activity extends AppCompatActivity {
    private SoundPool soundPool;
    Button A1,A_1,B1,C2,C_2,D2,D_2,E2,F2,F_2,G2,G_2,A2,A_2,B2,C3,C_3,D3,play,stop;
    Button[] black_keys,white_keys;
    Spinner spinner;
    EditText editText;
    Thread hilo;
    private int a1,a_1,b1,c2,c_2,d2,d_2,e2,f2,f_2,g2,g_2,a2,a_2,b2,c3,c_3,d3;
    String[] canciones={null,"E2-E2-F2-G2-G2-F2-E2-D2-C2-C2-D2-E2-E2-D2-D2-E2-E2-F2-G2-G2-F2-E2-D2-C2-C2-D2-E2-D2-C2-C2-D2-E2-C2-D2-E2-F2-E2-C2-D2-E2-F2-E2-D2-C2-D2-B1-E2-E2-F2-G2-G2-F2-E2-D2-C2-C2-D2-E2-D2-C2-C2",
    "C2-C2-G2-G2-A2-A2-G2-F2-F2-E2-E2-D2-D2-C2-G2-G2-F2-F2-E2-E2-D2-G2-G2-F2-F2-E2-E2-D2-C2-C2-G2-G2-A2-A2-G2-F2-F2-E2-E2-D2-D2-C2",
    "C2-D2-E2-C2-C2-D2-E2-C2-E2-F2-G2-E2-F2-G2-G2-A2-G2-F2-E2-C2-G2-A2-G2-F2-E2-C2-D2-A1-C2-D2-A1-C2",
    "D2-E2-G2-G2-G2-G2-G2-G2-G2-D2-E2-G2-G2-G2-G2-G2-G2-G2-D2-E2-G2-G2-G2-G2-G2-G2-G2-G2-G2-F#2-D2-E2-G2-G2-G2-G2-G2-G2-G2-D2-E2-G2-G2-G2-G2-G2-G2-G2-D2-E2-G2-G2-G2-G2-G2-G2-G2-G2-G2-F#2",
    "D2-D2-E2-D2-G2-F#2-D2-D2-E2-D2-A2-G2-D2-D2-D3-B2-G2-F#2-E2-C3-C3-B2-G2-A2-G2",
    "E2-D2-C2-D2-E2-E2-E2-D2-D2-D2-E2-G2-G2-E2-D2-C2-D2-E2-E2-E2-D2-D2-E2-D2-C2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            soundPool=new SoundPool.Builder().setMaxStreams(5).build();
        }else{
            soundPool=new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        }

        spinner=findViewById(R.id.spinner);
        editText=findViewById(R.id.edit_text);
        play=findViewById(R.id.button21);
        stop=findViewById(R.id.button20);
        hilo=new Thread();

        a1=soundPool.load(this,R.raw.a1,1);
        a_1=soundPool.load(this,R.raw.a_1,1);
        b1=soundPool.load(this,R.raw.b1,1);
        c2=soundPool.load(this,R.raw.c2,1);
        c_2=soundPool.load(this,R.raw.c_2,1);
        d2=soundPool.load(this,R.raw.d2,1);
        d_2=soundPool.load(this,R.raw.d_2,1);
        e2=soundPool.load(this,R.raw.e2,1);
        f2=soundPool.load(this,R.raw.f2,1);
        f_2=soundPool.load(this,R.raw.f_2,1);
        g2=soundPool.load(this,R.raw.g2,1);
        g_2=soundPool.load(this,R.raw.g_2,1);
        a2=soundPool.load(this,R.raw.a2,1);
        a_2=soundPool.load(this,R.raw.a_2,1);
        b2=soundPool.load(this,R.raw.b2,1);
        c3=soundPool.load(this,R.raw.c3,1);
        c_3=soundPool.load(this,R.raw.c_3,1);
        d3=soundPool.load(this,R.raw.d3,1);

        A1=findViewById(R.id.button);
        A_1=findViewById(R.id.button13);
        B1=findViewById(R.id.button2);
        C2=findViewById(R.id.button4);
        C_2=findViewById(R.id.button14);
        D2=findViewById(R.id.button5);
        D_2=findViewById(R.id.button12);
        E2=findViewById(R.id.button6);
        F2=findViewById(R.id.button7);
        F_2=findViewById(R.id.button16);
        G2=findViewById(R.id.button8);
        G_2=findViewById(R.id.button18);
        A2=findViewById(R.id.button3);
        A_2=findViewById(R.id.button19);
        B2=findViewById(R.id.button9);
        C3=findViewById(R.id.button11);
        C_3=findViewById(R.id.button15);
        D3=findViewById(R.id.button10);

        black_keys=new Button[]{A_1,C_2,D_2,F_2,G_2,A_2,C_3,};
        white_keys=new Button[]{A1,B1,C2,D2,E2,F2,G2,A2,B2,C3,D3};

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editText.setText(canciones[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (spinner.getSelectedItemPosition()){
                    case 0:
                        break;
                    case 1:
                        himno_alegria();
                        break;
                    case 2:
                        estrellita();
                        break;
                    case 3:
                        martinillo();
                        break;
                    case 4:
                        baby_shark();
                        break;
                    case 5:
                        happy_birthday();
                        break;
                    case 6:
                        mary_little_lamb();
                        break;
                }
                if(spinner.getSelectedItemPosition()!=0) {
                    play.setEnabled(false);
                    hilo.start();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hilo.interrupt();
                repintar();
                play.setEnabled(true);
            }
        });

        A1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(a1,1,1,0,0,1);
                    A1.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    A1.setBackgroundResource(R.drawable.button_border);
                }
                return true;
            }
        });

        A_1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(a_1,1,1,0,0,1);
                    A_1.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    A_1.setBackgroundColor(Color.rgb(0,0,0));
                }
                return true;
            }
        });

        B1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(b1,1,1,0,0,1);
                    B1.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    B1.setBackgroundResource(R.drawable.button_border);
                }
                return true;
            }
        });

        C2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(c2,1,1,0,0,1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    C2.setBackgroundResource(R.drawable.button_border);
                }
                return true;
            }
        });

        C_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(c_2,1,1,0,0,1);
                    C_2.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    C_2.setBackgroundColor(Color.rgb(0,0,0));
                }
                return true;
            }
        });

        D2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(d2,1,1,0,0,1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    D2.setBackgroundResource(R.drawable.button_border);
                }
                return true;
            }
        });

        D_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(d_2,1,1,0,0,1);
                    D_2.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    D_2.setBackgroundColor(Color.rgb(0,0,0));
                }
                return true;
            }
        });

        E2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(e2,1,1,0,0,1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    E2.setBackgroundResource(R.drawable.button_border);
                }
                return true;
            }
        });

        F2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(f2,1,1,0,0,1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    F2.setBackgroundResource(R.drawable.button_border);
                }
                return true;
            }
        });

        F_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(f_2,1,1,0,0,1);
                    F_2.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    F_2.setBackgroundColor(Color.rgb(0,0,0));
                }
                return true;
            }
        });

        G2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(g2,1,1,0,0,1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    G2.setBackgroundResource(R.drawable.button_border);
                }
                return true;
            }
        });

        G_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(g_2,1,1,0,0,1);
                    G_2.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    G_2.setBackgroundColor(Color.rgb(0,0,0));
                }
                return true;
            }
        });

        A2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(a2,1,1,0,0,1);
                    A2.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    A2.setBackgroundResource(R.drawable.button_border);
                }
                return true;
            }
        });

        A_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(a_2,1,1,0,0,1);
                    A_2.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    A_2.setBackgroundColor(Color.rgb(0,0,0));
                }
                return true;
            }
        });

        B2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(b2,1,1,0,0,1);
                    B2.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    B2.setBackgroundResource(R.drawable.button_border);
                }
                return true;
            }
        });

        C3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(c3,1,1,0,0,1);
                    C3.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    C3.setBackgroundResource(R.drawable.button_border);
                }
                return true;
            }
        });

        C_3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(c_3,1,1,0,0,1);
                    C_3.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    C_3.setBackgroundColor(Color.rgb(0,0,0));
                }
                return true;
            }
        });

        D3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    soundPool.play(d3,1,1,0,0,1);
                    D3.setBackgroundResource(R.drawable.button_pressed);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    D3.setBackgroundResource(R.drawable.button_border);
                }
                return true;
            }
        });
    }

    private void repintar(){
        for(int i=0;i<black_keys.length;i++){
            black_keys[i].setBackgroundColor(Color.rgb(0,0,0));
        }

        for(int i=0;i<white_keys.length;i++){
            white_keys[i].setBackgroundResource(R.drawable.button_border);
        }
    }

    private void himno_alegria(){
        hilo=new Thread(){
            public void run() {
                try {
                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(125);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(125);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(500);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(125);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(125);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(500);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(750);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(125);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(125);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(125);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(125);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(125);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(125);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(125);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(125);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(b1, 1, 1, 0, 0, 1);
                    B1.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    B1.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(500);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(125);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(125);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    C2.setBackgroundResource(R.drawable.button_border);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            play.setEnabled(true);
                        }
                    });
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
    }

    private void estrellita(){
        hilo=new Thread() {
            public void run() {
                try {
                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(a2, 1, 1, 0, 0, 1);
                    A2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    A2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(a2, 1, 1, 0, 0, 1);
                    A2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    A2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(500);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(500);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(500);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(500);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(a2, 1, 1, 0, 0, 1);
                    A2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    A2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(a2, 1, 1, 0, 0, 1);
                    A2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    A2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(500);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    C2.setBackgroundResource(R.drawable.button_border);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            play.setEnabled(true);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private void martinillo(){
        hilo=new Thread() {
            public void run() {
                try {
                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(500);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(500);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(125);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(125);

                    soundPool.play(a2, 1, 1, 0, 0, 1);
                    A2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(125);
                    A2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(125);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(125);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(125);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(125);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(125);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(125);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(125);

                    soundPool.play(a2, 1, 1, 0, 0, 1);
                    A2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(125);
                    A2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(125);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(125);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(125);

                    soundPool.play(f2, 1, 1, 0, 0, 1);
                    F2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(125);
                    F2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(125);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(a1, 1, 1, 0, 0, 1);
                    A1.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    A1.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(500);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(a1, 1, 1, 0, 0, 1);
                    A1.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(250);
                    A1.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(250);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    C2.setBackgroundResource(R.drawable.button_border);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            play.setEnabled(true);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private void baby_shark(){
        hilo=new Thread() {
            public void run() {
                try {
                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(320);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(320);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(290);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(290);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep((320/2)/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep((320/2)/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep((320/2)/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep((320/2)/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(320/2);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(320/2);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(290/2);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(290/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep((320/2)/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep((320/2)/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep((320/2)/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep((320/2)/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(320/2);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(320/2);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(290/2);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(290/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep((320/2)/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep((320/2)/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep((320/2)/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep((320/2)/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(320/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(320/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(320/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(320/2);

                    soundPool.play(f_2, 1, 1, 0, 0, 1);
                    F_2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    F_2.setBackgroundColor(Color.rgb(0,0,0));
                    Thread.sleep(720);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(320);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(320);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(290);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(290);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep((320/2)/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep((320/2)/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep((320/2)/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep((320/2)/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(320/2);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(320/2);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(290/2);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(290/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep((320/2)/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep((320/2)/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep((320/2)/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep((320/2)/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(320/2);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(320/2);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(290/2);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(290/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep((320/2)/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep((320/2)/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep((320/2)/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep((320/2)/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(320/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(320/2);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(320/2);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(320/2);

                    soundPool.play(f_2, 1, 1, 0, 0, 1);
                    F_2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(500);
                    F_2.setBackgroundColor(Color.rgb(0,0,0));

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            play.setEnabled(true);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private void happy_birthday(){
        hilo=new Thread() {
            public void run() {
                try {
                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(150);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(150);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(150);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(150);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300);

                    soundPool.play(f_2, 1, 1, 0, 0, 1);
                    F_2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(600);
                    F_2.setBackgroundColor(Color.rgb(0,0,0));
                    Thread.sleep(600);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(150);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(150);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(150);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(150);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300);

                    soundPool.play(a2, 1, 1, 0, 0, 1);
                    A2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300);
                    A2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(600);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(600);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(150);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(150);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(150);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(150);

                    soundPool.play(d3, 1, 1, 0, 0, 1);
                    D3.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300);
                    D3.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300);

                    soundPool.play(b2, 1, 1, 0, 0, 1);
                    B2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300);
                    B2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300);

                    soundPool.play(f_2, 1, 1, 0, 0, 1);
                    F_2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300);
                    F_2.setBackgroundColor(Color.rgb(0,0,0));
                    Thread.sleep(300);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(600);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(600);

                    soundPool.play(c3, 1, 1, 0, 0, 1);
                    C3.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(150);
                    C3.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(150);

                    soundPool.play(c3, 1, 1, 0, 0, 1);
                    C3.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(150);
                    C3.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(150);

                    soundPool.play(b2, 1, 1, 0, 0, 1);
                    B2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300);
                    B2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300);

                    soundPool.play(a2, 1, 1, 0, 0, 1);
                    A2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(300);
                    A2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(300);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(600);
                    G2.setBackgroundResource(R.drawable.button_border);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            play.setEnabled(true);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private void mary_little_lamb(){
        hilo=new Thread() {
            public void run() {
                try {
                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(400);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(400);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(400);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(400);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(g2, 1, 1, 0, 0, 1);
                    G2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(400);
                    G2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(400);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    C2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(400);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(400);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(e2, 1, 1, 0, 0, 1);
                    E2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    E2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(d2, 1, 1, 0, 0, 1);
                    D2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(200);
                    D2.setBackgroundResource(R.drawable.button_border);
                    Thread.sleep(200);

                    soundPool.play(c2, 1, 1, 0, 0, 1);
                    C2.setBackgroundResource(R.drawable.button_pressed);
                    Thread.sleep(400);
                    C2.setBackgroundResource(R.drawable.button_border);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            play.setEnabled(true);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
