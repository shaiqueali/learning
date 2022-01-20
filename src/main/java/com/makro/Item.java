package com.makro;

public class Item {
    private String type;
    private String name;

    public Item() {
    }

    public Item(String type, String name) {
        setType(type);
        setName(name);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
