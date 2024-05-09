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
    private BackPack backpack = new BackPack();
    private Bag metalBag = new Bag(Category.METAL);
    public void addItem(Item item) {

        if( backpack.items().size() < backpack.maxCapacity()) backpack.addItem(item);
        else if(metalBag.items().size() < metalBag.maxCapacity()) metalBag.addItem(item);
    }

    public BackPack getBackpack() { return this.backpack;
    }
    public String[] getBackpackItemsName() { return null;}

    public String[] getBagItemsName() { return null;}

    public void addItems(Item[] items) {
    }

    public void organize() {
    }

    public Bag getMetalBag() { return this.metalBag;}
}
