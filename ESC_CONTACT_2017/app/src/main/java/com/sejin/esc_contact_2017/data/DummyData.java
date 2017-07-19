package com.sejin.esc_contact_2017.data;

import java.util.ArrayList;

/**
 * Created by sejin on 2017. 7. 19..
 */

public class DummyData {

    public static ContactData myData= new ContactData("세지니","01029109704");

    public static ArrayList<ContactData> dummyList = new ArrayList<ContactData>(){
        {
            add(new ContactData ("김나현","01044444444"));
            add(new ContactData ("홍기범","01000000000"));
            add(new ContactData ("정원규(털)","01033211362"));
        }


    };



}
