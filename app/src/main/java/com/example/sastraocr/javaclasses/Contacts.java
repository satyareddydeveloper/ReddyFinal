package com.example.sastraocr.javaclasses;

public class Contacts {
    int id;

    public int getId() {
        return id;

    }

    public Contacts(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Contacts(String name) {
        this.name = name;
    }

    String name;

}
