package com.sejin.esc_contact_2017.data;

/**
 * Created by sejin on 2017. 7. 19..
 */

public class ContactData {


    private String name, phoneNum, mail;

    public ContactData(){}
    public ContactData(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public ContactData(String name, String phoneNum, String mail) {
        this.name = name;
        this.phoneNum = phoneNum;

        this.mail = mail;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getMail() {
        return mail;
    }


    public void setMail(String mail) {

        this.mail = mail;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (!name.equals(that.name)) return false;
        if (!phoneNum.equals(that.phoneNum)) return false;
        return mail != null ? mail.equals(that.mail) : that.mail == null;

    }

}
