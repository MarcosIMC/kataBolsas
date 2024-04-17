package org.example;

import java.util.ArrayList;
import java.util.Collection;

public class Bag implements Pack{
    CategoryTypes categy = CategoryTypes.NONE;

    public Bag(CategoryTypes categy) {
        this.categy = categy;
    }
    public Bag() {}
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
        return items.size() >= 4;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
