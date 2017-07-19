package com.sejin.esc_contact_2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sejin.esc_contact_2017.adapter.ContactRcvAdapter;
import com.sejin.esc_contact_2017.data.DummyData;

public class ContactsActivity extends AppCompatActivity {

    /**
     * 리사이클러뷰: 각각의 Item들을 리스트로 만들어 놓은 형태임.
     * 즉, Item을 xml형태로 만들어 놓아야 함.
     * */
    RecyclerView rcvContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        rcvContacts=(RecyclerView)findViewById(R.id.contact_list);

        rcvContacts.setLayoutManager(new LinearLayoutManager(this));


    }


    @Override
    protected void onResume() {
        super.onResume();
        rcvContacts.setAdapter(new ContactRcvAdapter(DummyData.dummyList,this));
    }
}
