package com.arkesel.model;

import com.arkesel.model.ContactObject;

import java.util.ArrayList;
import java.util.List;

public class GroupObject {
    private String name;
    private List<ContactObject> contacts = new ArrayList<>();

    public GroupObject(String name){
        this.name = name;
    }

    public GroupObject(String name, List<ContactObject> contacts){
        this.name = name;
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        String data = "{" +
                "\"group_name\":\"" + name + '\"';
        if(!contacts.isEmpty()){
            data += ", \"contacts\":" + contacts.toString();
        }
        data += "}";
        return data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ContactObject> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactObject> contacts) {
        this.contacts = contacts;
    }
}
