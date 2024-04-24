package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Person {
    private List<Item> backpack = new ArrayList<>();
    public void addItem(Item item) {
        backpack.add(item);

    }

    public List<Item> getBackpack() { return this.backpack;
    }
    public String[] getBackpackItemsName() { return null;}

    public String[] getBagItemsName() { return null;}

    public void addItems(Item[] items) {
    }

    public void organize() {
    }

    public List<Item> getMetalBag() { return null;}
}
