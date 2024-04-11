package org.example;

public class Item {
    private String name;
    private String category;

    public Item(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String name() {
        return name;
    }

    public String category() {
        return category;
    }
}
