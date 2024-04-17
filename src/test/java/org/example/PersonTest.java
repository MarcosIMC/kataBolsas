package org.example;
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
    @Test
    void add_item_in_backpack_when_is_space() {
        Person durance = new Person();
        Item item = new Item("iron", CategoryTypes.METALS);
        durance.addItem(item);
        assertEquals(1, durance.backpack.items().size());
    }
    @Test
    void add_item_in_bag_when_backpack_full() {
        Person durance = new Person();
        Item item = new Item("iron", CategoryTypes.METALS);
        for (int i = 0; i < 10; i ++) {
            durance.addItem(item);
        }
        assertEquals(8, durance.backpack.items().size());
        assertEquals(2,durance.bags.get(0).items().size());
    }
    @Test
    void add_item_in_2nd_bag_when_1st_bag_full() {
        Person durance = new Person();
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
Person durance = new Person();
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0 ; i < 8; i ++) { items.add(new Item("Iron", CategoryTypes.METALS));}
        for (int i = 0 ; i < 2; i ++) { items.add(new Item("Marigold", CategoryTypes.HERBS));}
        for (int i = 0 ; i < 2; i ++) { items.add(new Item("Silk", CategoryTypes.CLOTHES));}
        for (int i = 0 ; i < 4; i ++) { items.add(new Item("Axe", CategoryTypes.WEAPONS));}
        for (int i = 0 ; i < 4; i ++) { items.add(new Item("Strawberry", CategoryTypes.NONE));}
        for (Item item: items ) {
            durance.addItem(item);
        }
        durance.organize();
        assertEquals(8, durance.backpack.items().size());
        assertEquals(4, durance.bags.get(0).items().size());
        assertEquals(2, durance.bags.get(1).items().size());
        for (Bag bag: durance.bags ) {
            for (Item item: bag.items() ) {
                switch (bag.categy) {
                    case METALS -> {
                        assertEquals(bag.categy, item.category());
                        assertEquals(4, bag.items().size());
                    }
                    case HERBS -> {
                        assertEquals(bag.categy, item.category());
                        assertEquals(2, bag.items().size());
                    }
                }
            }
        }
    }
    }

