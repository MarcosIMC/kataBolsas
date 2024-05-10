package org.example;

public class Item {
    private String name;
    private Category category;

    public Item(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
