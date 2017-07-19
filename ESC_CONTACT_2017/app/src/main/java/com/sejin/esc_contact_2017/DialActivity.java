package com.sejin.esc_contact_2017;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class DialActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button btnAsteroid,btn0,btnCrossHatch;

    TextView tvNumberPanel;

    ImageButton btnErase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);
        /** 아 xml에서 버튼마다 온클릭 옵션에 다들  onClick 입력했습니다
         * 이후에 Dial Acttivity 에 OnClickListener 인터페이스를 이용해서 온클릭 함수 만들거예요.**/



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
        btnErase=(ImageButton)findViewById(R.id.eraseImgBtn);
        tvNumberPanel=(TextView)findViewById(R.id.numPanel);

        btnErase.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvNumberPanel.setText(null);
                return false;
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button0:
                tvNumberPanel.append("0");
                break;
            /**  case문 오른쪽에는 상수가 와야해서 getId() 를 사용할 수 없어요.
             * 빨간줄에 커서 가져다 대면 에러메세지 뜨는데 에러메세지 읽는법 알려주세요 **/
            //case btn1.getId():
            case R.id.button1:
                tvNumberPanel.append("1");
                break;
            case R.id.button2:
                tvNumberPanel.append("2");
                break;
            case R.id.button3:
                tvNumberPanel.append("3");
                break;
            case R.id.button4:
                tvNumberPanel.append("4");
                break;
            case R.id.button5:
                tvNumberPanel.append("5");
                break;
            case R.id.button6:
                tvNumberPanel.append("6");
                break;
            case R.id.button7:
                tvNumberPanel.append("7");
                break;
            case R.id.button8:
                tvNumberPanel.append("8");
                break;
            case R.id.button9:
                tvNumberPanel.append("9");
                break;
            case R.id.button_asteroid:
                tvNumberPanel.append("*");
                break;
            case R.id.button_Crosshatch:
                tvNumberPanel.append("#");
                break;
            case R.id.eraseImgBtn:
                String temp = tvNumberPanel.getText().toString();
                if (temp.length()> 0) tvNumberPanel.setText(temp.substring(0,temp.length()-1));
                break;
//            case R.id.nextActivityImgBtn:

        }
    }
}
