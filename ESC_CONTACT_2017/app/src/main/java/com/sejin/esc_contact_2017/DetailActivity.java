package com.sejin.esc_contact_2017;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sejin.esc_contact_2017.data.ContactData;
import com.sejin.esc_contact_2017.data.DummyData;

public class DetailActivity extends AppCompatActivity {

    private ImageButton editBtn, callBtn, msgBtn, mailBtn,  deleteBtn;
    private TextView name, phoneNum, mail;
    private ContactData contactData;

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        editBtn = (ImageButton) findViewById(R.id.detail_edit_btn);
        callBtn = (ImageButton) findViewById(R.id.detail_call_btn);
        msgBtn = (ImageButton) findViewById(R.id.detail_message_btn);
        mailBtn = (ImageButton) findViewById(R.id.detail_mail_btn);
        deleteBtn = (ImageButton) findViewById(R.id.detail_delete_btn);

        name = (TextView) findViewById(R.id.detail_name);
        phoneNum = (TextView) findViewById(R.id.detail_phone_num);
        mail = (TextView) findViewById(R.id.detail_mail);


        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, EditActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

        /***********************
         * TODO call,message,mail 기능 만드세요 메일 기능은 봐서 그냥 뺴야지
         * *********************/

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder dialog = new AlertDialog.Builder(DetailActivity.this);

                dialog.setMessage("정말로 삭제하시겠습니까?");
                dialog.setCancelable(true);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DummyData.dummyList.remove(position);
                        finish();

                    }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        setData();

    }

    private void setData() {
        position = getIntent().getIntExtra("position", -1);

        contactData = DummyData.dummyList.get(position);
        name.setText(contactData.getName());
        phoneNum.setText(contactData.getPhoneNum());
        mail.setText(contactData.getMail());


    }
}
