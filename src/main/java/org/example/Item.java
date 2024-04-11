package org.example;

public class Item {
    private String name;
    private CategoryTypes category;

    public Item(String name, CategoryTypes category) {
        this.name = name;
        this.category = category;
    }

    public String name() {
        return name;
    }

    public CategoryTypes category() {
        return category;
    }
}
