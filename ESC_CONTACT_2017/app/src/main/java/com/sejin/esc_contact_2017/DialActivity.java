package com.sejin.esc_contact_2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class DialActivity extends AppCompatActivity  {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button btnAsteroid,btn0,btnCrossHatch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);
    /** 형변환 해주는 이유형변환 해주는 이유 **/
        btn0=(Button)findViewById(R.id.button0);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);
        btn5=(Button)findViewById(R.id.button5);
        btn6=(Button)findViewById(R.id.button6);
        btn7=(Button)findViewById(R.id.button7);
        btn8=(Button)findViewById(R.id.button8);
        btn9=(Button)findViewById(R.id.button9);
        btnAsteroid=(Button)findViewById(R.id.button_asteroid);
        btnCrossHatch=(Button)findViewById(R.id.button_Crosshatch);

    }





}
