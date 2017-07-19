package com.sejin.esc_contact_2017;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class DialActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnAsteroid, btn0, btnCrossHatch;

    TextView tvNumberPanel;

    ImageButton btnErase;

    private static final int MY_CALL_REQUESTCODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);
        /** 아 xml에서 버튼마다 온클릭 옵션에 다들  onClick 입력했습니다
         * 이후에 Dial Acttivity 에 OnClickListener 인터페이스를 이용해서 온클릭 함수 만들거예요.**/


        /** 형변환 해주는 이유형변환 해주는 이유 **/
        btn0 = (Button) findViewById(R.id.button0);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);

        btnAsteroid = (Button) findViewById(R.id.button_asteroid);
        btnCrossHatch = (Button) findViewById(R.id.button_Crosshatch);
        btnErase = (ImageButton) findViewById(R.id.eraseImgBtn);
        tvNumberPanel = (TextView) findViewById(R.id.numPanel);

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
        switch (v.getId()) {
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
                if (temp.length() > 0)
                    tvNumberPanel.setText(temp.substring(0, temp.length() - 1));
                break;
            case R.id.callImgBtn:

                Intent callIntent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + tvNumberPanel.getText().toString()));

                /** 유저한테 아직 허가를 받지 않은 경우에는, 퍼미션을 리퀘스트한다 그리고 동의를 받은 후에는 이 액티비티에 재정의된
                 * 콜백 메소드인 onRequestPermissionResult 메소드가 실행된다
                 * 동의는 한번만 받으면 되므로, 다음부터는 else문을 통해 바로 전화를 거는 액티비티를 실행할 수 있다.
                 * */
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            DialActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            MY_CALL_REQUESTCODE
                    );
                } else startActivity(callIntent);
                break;

            case R.id.nextActivityImgBtn:
                startActivity(new Intent(this, ContactsActivity.class));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_CALL_REQUESTCODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent callIntent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + tvNumberPanel.getText().toString()));
                    startActivity(callIntent);
                }
                else
                {

                }
                return;
            }
        }
    }
}
