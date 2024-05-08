package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Clase abstracta Pack  , con atributos (category, maxCapacity, lista items)
// clase hija Backpack hereda de Pack
// Calse hija Bag hereda de Pack
// Enum de categorias>> backpack, metal, ...
// Person atributo > inventario List de Pack

public class Person {
    private List<Item> backpack = new ArrayList<>();
    private List<Item> metalBag = new ArrayList<>();
    public void addItem(Item item) {

        if(backpack.size() < 8) backpack.add(item);
        else if(metalBag.size() < 4) metalBag.add(item);
    }

    public List<Item> getBackpack() { return this.backpack;
    }
    public String[] getBackpackItemsName() { return null;}

    public String[] getBagItemsName() { return null;}

    public void addItems(Item[] items) {
    }

    public void organize() {
    }

    public List<Item> getMetalBag() { return this.metalBag;}
}
