package com.andrewbiesen.andrewvendorsjava;

/**
 * Created by matthew on 7/14/17.
 */

public class Vendor {

    public String business;

    public String website;

    public String contactNumber;

    public String group;

    public String email;

    public String specialty;

    Vendor(String business,String website, String contact, String group, String email, String specialty){
        this.business = business;
        this.website = website;
        this.contactNumber = contact;
        this.group = group;
        this.email = email;
        this.specialty = specialty;
    }


}
