package org.example;

import java.util.ArrayList;

public class Backpack {
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        if(!isFull()) {
            this.items.add(item);
        }
    }

    public ArrayList<Item> items() {
        return items;
    }

    public boolean isFull() {
        return items.size() >= 8;
    }
}
