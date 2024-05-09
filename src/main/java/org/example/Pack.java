package org.example;

import java.util.ArrayList;

public class Pack {
    private Category category;
    private int maxCapacity;
    private ArrayList<Item> items;

    public Pack(Category category, int maxCapacity) {
        this.category = category;
        this.maxCapacity = maxCapacity;
        this.items = new ArrayList<>();
    }

    public Category category() {
        return category;
    }

    public int maxCapacity() {
        return maxCapacity;
    }

    public ArrayList<Item> items() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
}
