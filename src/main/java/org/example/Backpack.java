package org.example;

import java.util.ArrayList;

public class Backpack {

    private ArrayList<String> items = new ArrayList<String>();

    public void addItem(String item) {
        if(!isFull()) {
            this.items.add(item);
        }
    }

    public ArrayList<String> items() {
        return items;
    }

    public boolean isFull() {
        return items.size() >= 8;
    }
}
