package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Clase abstracta Pack  , con atributos (category, maxCapacity, lista items)
// clase hija Backpack hereda de Pack
// Calse hija Bag hereda de Pack
// Enum de categorias>> backpack, metal, ...
// Person atributo > inventario List de Pack

public class Person {
    private ArrayList<Pack> inventory = new ArrayList<>();

    public Person() {
        this.inventory.add(new BackPack());
        this.inventory.add(new Bag(Category.METAL));
        this.inventory.add(new Bag(Category.HERB));
        this.inventory.add(new Bag(Category.WEAPON));
        this.inventory.add(new Bag(Category.CLOTHES));

    }

    public void addItem(Item item) {

        for (Pack pack: this.inventory){
            if (pack.items().size() < pack.maxCapacity()){
                pack.addItem(item);
                break;
            }
        }
        /*
        if( backpack.items().size() < backpack.maxCapacity()) backpack.addItem(item);
        else if(metalBag.items().size() < metalBag.maxCapacity()) metalBag.addItem(item);
        else if(herbBag.items().size() < herbBag.maxCapacity()) herbBag.addItem(item);
        else if(weaponBag.items().size() < weaponBag.maxCapacity()) weaponBag.addItem(item);
        else if(clothesBag.items().size() < clothesBag.maxCapacity()) clothesBag.addItem(item);
         */
    }

    public String[] getBackpackItemsName() { return null;}

    public String[] getBagItemsName() { return null;}

    public void addItems(Item[] items) {
    }

    public void organize() {
    }
/*
    public BackPack getBackpack() { return this.backpack;
    }

    public Bag getMetalBag() { return this.metalBag;}

    public Bag getHerbBag() {
        return herbBag;
    }

    public Bag getWeaponBag() {
        return weaponBag;
    }

    public Bag getClothesBag() {
        return clothesBag;
    }

 */

    public Pack getPackBy(Category category) {
        List<Pack> packObtained = this.inventory.stream()
                .filter((pack) -> pack.category() == category)
                .toList();
        return packObtained.get(0);
    }
}
