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
            if (item.category() == CategoryTypes.METALS && !this.bags.get(2).isFull()) {
                this.bags.get(2).addItem(item);
            } else if (item.category() == CategoryTypes.HERBS && !this.bags.get(3).isFull()) {
                this.bags.get(3).addItem(item);
            } else if (!this.backpack.isFull()){
                this.backpack.addItem(item);
            } else if (!this.bags.get(0).isFull()) {
                this.bags.get(0).addItem(item);
            } else if (!this.bags.get(1).isFull()) {
                this.bags.get(1).addItem(item);
            }
        }
    }

    public void organizeAlphabetically() {
        this.backpack.items().sort(Comparator.comparing(Item::name));
        for (Bag bag: this.bags){
            bag.items().sort(Comparator.comparing(Item::name));
        }

    }
}
