package com.sejin.esc_contact_2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sejin.esc_contact_2017.R;
import com.sejin.esc_contact_2017.data.ContactData;
import com.sejin.esc_contact_2017.data.DummyData;

public class DetailActivity extends AppCompatActivity {

    private ImageButton backBtn, editBtn, callBtn, msgBtn, mailBtn, shareBtn, deleteBtn;
    private TextView name,phoneNum,mail;
    private ContactData contactData;

    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        editBtn = (ImageButton)findViewById(R.id.detail_edit_btn);
        callBtn = (ImageButton)findViewById(R.id.detail_call_btn);
        msgBtn = (ImageButton)findViewById(R.id.detail_message_btn);
        mailBtn = (ImageButton)findViewById(R.id.detail_mail_btn);
        shareBtn = (ImageButton)findViewById(R.id.detail_share_btn);
        deleteBtn = (ImageButton)findViewById(R.id.detail_delete_btn);

        name = (TextView)findViewById(R.id.detail_name);
        phoneNum = (TextView)findViewById(R.id.detail_phone_num);
        mail = (TextView)findViewById(R.id.detail_mail);



    }

    @Override
    protected void onResume() {
        super.onResume();

        setData();

    }

    private void setData(){
        position= getIntent().getIntExtra("position",-1);

        contactData= DummyData.dummyList.get(position);
        name.setText(contactData.getName());
        phoneNum.setText(contactData.getPhoneNum());
        mail.setText(contactData.getEmail());

    }
}
