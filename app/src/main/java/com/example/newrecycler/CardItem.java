package com.example.newrecycler;

public class CardItem {

    private final String id;
    private final String name;

    public CardItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
