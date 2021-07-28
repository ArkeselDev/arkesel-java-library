package com.arkesel;

public class ContactObject {
    private String phoneNumber;
    private String firstname = "";
    private String lastname = "";
    private String company = "";
    private String email = "";
    private String username = "";

    public ContactObject(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ContactObject(String phoneNumber, String firstname, String lastname, String company, String email, String username) {
        this.phoneNumber = phoneNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.email = email;
        this.username = username;
    }

    @Override
    public String toString() {
        String data =  "{" +
                "\"phone_number\":\"" + phoneNumber + '"';
        if(!firstname.isEmpty()){
            data += ", \"first_name\":\"" + firstname + '"';
        }
        if(!lastname.isEmpty()){
            data += ", \"last_name\":\"" + lastname + '"';
        }
        if(!company.isEmpty()){
            data += ", \"company\":\"" + company + '"';
        }
        if(!email.isEmpty()){
            data += ", \"email_address\":\"" + email + '"';
        }
        if(!username.isEmpty()){
            data += ", \"user_name\":\"" + username + '"';
        }
        data += "}";
        return data;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
