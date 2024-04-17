package org.example;

import java.util.ArrayList;

public class Backpack implements Pack{
    private final ArrayList<Item> items = new ArrayList<>();
    // Duran va comprobar si está lleno. Estó se repite. Debemos quitarlo.
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

    public void removeItem(Item item) {
        items.remove(item);
    }
}
