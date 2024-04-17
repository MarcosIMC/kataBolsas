package org.example;

import java.util.ArrayList;

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
    }
}
