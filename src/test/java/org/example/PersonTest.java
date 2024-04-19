package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class PersonTest {

    // Meter un articulo en la mochila cuando hay espacio
    // Meter un articulo en primera bolsa si mochila llena
    // meter un articula en segunda bolsa si 1.era mochila llena
    // Organizar todito por categorias
    // Organizar alfabeticamente
    // ? gestión de organizar

    //Hay Que refactorizar <3

    Person durance = new Person();


    @BeforeEach
    void init(){
        durance = new Person();
    }


    @Test
    void add_item_in_backpack_when_is_space() {
        Item item = new Item("iron", CategoryTypes.METALS);
        durance.addItem(item);
        assertEquals(1, durance.backpack.items().size());
    }
    @Test
    void add_item_in_bag_when_backpack_full() {
        Item item = new Item("iron", CategoryTypes.METALS);
        for (int i = 0; i < 10; i ++) {
            durance.addItem(item);
        }
        assertEquals(8, durance.backpack.items().size());
        assertEquals(2,durance.bags.get(0).items().size());
    }
    @Test
    void add_item_in_2nd_bag_when_1st_bag_full() {
        Item item = new Item("iron", CategoryTypes.METALS);
        for (int i = 0; i < 13; i ++) {
            durance.addItem(item);
        }
        assertEquals(8, durance.backpack.items().size());
        assertEquals(4,durance.bags.get(0).items().size());
        assertEquals(1,durance.bags.get(1).items().size());
    }
    @Test
    void organize_by_category() {
        ArrayList<Item> items = initData();
        for (Item item: items ) {
            durance.addItem(item);
        }
        durance.organize();
        assertEquals(8, durance.backpack.items().size());
        assertEquals(4, durance.bags.get(2).items().size());
        assertEquals(2, durance.bags.get(3).items().size());
        assertEquals(4, durance.bags.get(0).items().size());
        assertEquals(2, durance.bags.get(1).items().size());

        for (Bag bag: durance.bags ) {
            for (Item item: bag.items() ) {
                switch (bag.categy) {
                    case METALS, HERBS -> assertEquals(bag.categy, item.category());
                }
            }
        }
    }
    @Test
    void organize_backpack_alphabetically(){
        for (int i = 0 ; i < 2; i ++) { durance.addItem(new Item("Iron", CategoryTypes.METALS));}
        for (int i = 0 ; i < 2; i ++) { durance.addItem(new Item("Marigold", CategoryTypes.HERBS));}
        durance.addItem(new Item("Silk", CategoryTypes.CLOTHES));
        durance.addItem(new Item("Axe", CategoryTypes.WEAPONS));
        durance.organizeAlphabetically();
        String[] itemsNameExpect = {"Axe", "Iron", "Iron", "Marigold", "Marigold","Silk"};
        int count = 0;
        for (Item item: durance.backpack.items()){
            assertEquals(item.name(),itemsNameExpect[count]);
            count++;
        }
    }

    @Test
    void organize_first_bags_alphabetically(){
        for (int i = 0 ; i < 8; i ++) { durance.addItem(new Item("Iron", CategoryTypes.METALS));}
        for (int i = 0 ; i < 2; i ++) { durance.addItem(new Item("Marigold", CategoryTypes.HERBS));}
        durance.addItem(new Item("Silk", CategoryTypes.CLOTHES));
        durance.addItem(new Item("Axe", CategoryTypes.WEAPONS));

        durance.organizeAlphabetically();
        String[] itemsNameExpectBagOne = {"Axe", "Marigold", "Marigold","Silk"};
        int count = 0;
        for (Item item: durance.bags.get(0).items()){
            assertEquals(item.name(),itemsNameExpectBagOne[count]);
            count++;
        }
    }
    @Test
    void organize_bags_alphabetically(){
        for (int i = 0 ; i < 8; i ++) { durance.addItem(new Item("Iron", CategoryTypes.METALS));}
        for (int i = 0 ; i < 4; i ++) { durance.addItem(new Item("Marigold", CategoryTypes.HERBS));}
        durance.addItem(new Item("Silk", CategoryTypes.CLOTHES));
        durance.addItem(new Item("Axe", CategoryTypes.WEAPONS));
        durance.addItem(new Item("Marigold", CategoryTypes.HERBS));
        durance.addItem(new Item("Axe", CategoryTypes.WEAPONS));

        durance.organizeAlphabetically();
        String[] itemsNameExpectBagTwo = {"Axe","Axe", "Marigold", "Silk"};
        int count = 0;
        for (Item item: durance.bags.get(1).items()){
            assertEquals(item.name(),itemsNameExpectBagTwo[count]);
            count++;
        }
    }


    private ArrayList<Item> initData() {
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0 ; i < 8; i ++) { items.add(new Item("Iron", CategoryTypes.METALS));}
        for (int i = 0 ; i < 2; i ++) { items.add(new Item("Marigold", CategoryTypes.HERBS));}
        for (int i = 0 ; i < 2; i ++) { items.add(new Item("Silk", CategoryTypes.CLOTHES));}
        for (int i = 0 ; i < 4; i ++) { items.add(new Item("Axe", CategoryTypes.WEAPONS));}
        for (int i = 0 ; i < 4; i ++) { items.add(new Item("Strawberry", CategoryTypes.NONE));}

        return items;
    }
}

