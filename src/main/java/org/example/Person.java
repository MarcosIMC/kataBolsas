package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Comprobar que se puedan meter dos bag de la misma categoria
// Poder añadir tantas bag como quiera (setup de forma dinámica)
// Una vez tener esto, comenzamos los test de organizar (MAGIC!!!)

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
        for (Item item: items){
            addItem(item);
        }
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

    public List<Category> getAllCagetory() {
        List<Category> allCategory = new ArrayList<>();
        this.inventory.forEach( (pack) -> {
            allCategory.add(pack.category());
        });
        return allCategory;
    }
}
