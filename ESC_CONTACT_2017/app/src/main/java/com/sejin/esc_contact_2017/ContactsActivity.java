package com.sejin.esc_contact_2017;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.sejin.esc_contact_2017.adapter.ContactRcvAdapter;
import com.sejin.esc_contact_2017.data.DummyData;

import static java.security.AccessController.getContext;

public class ContactsActivity extends AppCompatActivity {

    /**
     * 리사이클러뷰: 각각의 Item들을 리스트로 만들어 놓은 형태임.
     * 즉, Item을 xml형태로 만들어 놓아야 함.
     * */

    RecyclerView rcvContacts;
    ImageButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        rcvContacts=(RecyclerView)findViewById(R.id.contact_list);
        rcvContacts.setLayoutManager(new LinearLayoutManager(this));

        btnAdd=(ImageButton) findViewById(R.id.contact_add_btn);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent add = new Intent(ContactsActivity.this, EditActivity.class);
                add.putExtra("position", -1);
                startActivity(add);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        rcvContacts.setAdapter(new ContactRcvAdapter(DummyData.dummyList,this));
    }
}
