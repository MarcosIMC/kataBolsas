package org.example;

import java.util.*;

public class Person {
    Backpack backpack;
    ArrayList<Bag> bags = new ArrayList<>();
    //Bag metalBag = new Bag(CategoryTypes.METALS);
    //Bag herbBag = new Bag(CategoryTypes.HERBS);
    //Bag noCategoryBag1 = new Bag(CategoryTypes.NONE);
    //Bag noCategoryBag2 = new Bag(CategoryTypes.NONE);
    public Person() {
        this.backpack = new Backpack();
        for (int i = 0 ; i < 2 ; i ++) {
            this.bags.add(new Bag());
        }

        this.bags.add(new Bag(CategoryTypes.METALS));
        this.bags.add(new Bag(CategoryTypes.HERBS));
    }
    public void addItem (Item item) {
        if (!this.backpack.isFull()) {
            this.backpack.addItem(item);
        } else {
            for ( Bag bag: this.bags ) {
                if(!bag.isFull()) {
                    bag.addItem(item);
                    break;
                }
            }
        }

    }
    public void organize() {
        ArrayList<Item> floor = putItemsOnFloor();
        clearPack();
        organizeByCategory(floor);
        organizeAlphabetically();

        if (!floor.isEmpty()) {
            floor.clear();
        }
    }

    private ArrayList<Item> putItemsOnFloor() {
        ArrayList<Item> floor = new ArrayList<>(this.backpack.items());
        for (Bag bag: this.bags) {
            floor.addAll(bag.items());
        }
        return floor;
    }

    void clearPack() {
        this.backpack.items().clear();
        for (Bag bag: this.bags) {
            bag.items().clear();
        }
    }

    private void organizeByCategory(ArrayList<Item> floor) {
        for (Item item : floor) {
            Bag bag = searchBag(item.category());
            if (bag == null) {
                if(!this.backpack.isFull()) {
                    this.backpack.addItem(item);
                }
            }else {
                if (item.category() == CategoryTypes.METALS && bag.category == CategoryTypes.METALS && !bag.isFull()) {
                    bag.addItem(item);
                } else if (item.category() == CategoryTypes.HERBS && bag.category == CategoryTypes.HERBS && !bag.isFull()) {
                    bag.addItem(item);
                } else {
                    bag.addItem(item);
                }
            }
        }
    }

    private Bag searchBag(CategoryTypes category) {
        for (Bag bag: this.bags) {
            if (bag.category == category && !bag.isFull()) return bag;
        }
        return null;
    }

    public void organizeAlphabetically() {
        this.backpack.items().sort(Comparator.comparing(Item::name));
        for (Bag bag: this.bags){
            bag.items().sort(Comparator.comparing(Item::name));
        }

    }
}
