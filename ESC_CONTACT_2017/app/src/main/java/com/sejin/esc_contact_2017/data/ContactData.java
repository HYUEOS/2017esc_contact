package com.sejin.esc_contact_2017.data;

/**
 * Created by sejin on 2017. 7. 19..
 */

public class ContactData {


    private String name, phoneNum, email;

    public ContactData(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public ContactData(String name, String phoneNum, String email) {
        this.name = name;
        this.phoneNum = phoneNum;

        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {

        this.email = email;
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
        return email != null ? email.equals(that.email) : that.email == null;

    }

}
