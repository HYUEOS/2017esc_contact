package com.sejin.esc_contact_2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sejin.esc_contact_2017.data.ContactData;
import com.sejin.esc_contact_2017.data.DummyData;

public class EditActivity extends AppCompatActivity {

    private int position;
    private ContactData contactData;
    private ImageButton  btnSave;
    private EditText etName, etMail, etPhoneNum;
    private TextView tvTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        position = getIntent().getIntExtra("position", -1);

        btnSave=(ImageButton)findViewById(R.id.edit_save_btn);

        etName = (EditText) findViewById(R.id.edit_name);
        etMail = (EditText) findViewById(R.id.edit_mail);
        etPhoneNum = (EditText) findViewById(R.id.edit_phone_num);
        tvTitle= (TextView) findViewById(R.id.edit_title);


        //수정하는경우
        if (position > -1) {
            tvTitle.setText("연락처 수정");
            contactData = DummyData.dummyList.get(position);
            etName.setText(contactData.getName());
            etMail.setText(contactData.getMail());
            etPhoneNum.setText(contactData.getPhoneNum());
        }else{
            contactData= new ContactData();
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                if (position == -1) DummyData.dummyList.add(contactData);
                finish();
            }
        });


    }


    private void saveData(){
        contactData.setName(etName.getText().toString());
        contactData.setPhoneNum(etPhoneNum.getText().toString());
        contactData.setMail(etMail.getText().toString());
    }


}
