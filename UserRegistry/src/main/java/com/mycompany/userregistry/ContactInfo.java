package com.mycompany.userregistry;

import java.io.Serializable;

/**
 * Контактная информация.
 * 
 * @author Vladimir
 */
public class ContactInfo implements Serializable {
    private String email;
    private String mobilePhoneNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", getEmail(), getMobilePhoneNumber());
    }
}
