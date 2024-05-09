package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonShould {
    //-add item to backpack
    // add until 8 to backpack
    //-add item to bag
    // add until 4 to bag
    // fill all packs

    //-volcar los items a otro sitio
    //-delete items
    //-organize (lanza hechizo)

    @Test
    void AddOneItemItGoesToBackpack() {
        Person person = new Person();
        Item item = new Item("iron");

        person.addItem(item);

        assertEquals(1, person.getPackBy(Category.BACKPACK).items().size());
    }
    @Test
    void DoNotAddMoreThanEightItemsToBackpack() {
        Person person = new Person();
        Item item = new Item("iron");
        for (int i = 0; i < 10; i++) {
            person.addItem(item);
        }
        assertEquals(8, person.getPackBy(Category.BACKPACK).items().size());
    }
    @Test
    void AddOneItemItGoesToMetalBag() {
        Person person = new Person();
        Item item = new Item("iron");
        for (int i = 0; i < 10; i++) {
            person.addItem(item);
        }
        assertEquals(2, person.getPackBy(Category.METAL).items().size());
    }
    @Test
    void DoNotAddMoreThanFourItemsToMetalBag() {
        Person person = new Person();
        Item item = new Item("iron");
        for (int i = 0; i < 15; i++) {
            person.addItem(item);
        }
        assertEquals(4, person.getPackBy(Category.METAL).items().size());
    }

    @Test
    void fillAllPacks(){
        Person person = new Person();
        Item item = new Item("iron");
        for (int i = 0; i < 24; i++) {
            person.addItem(item);
        }
        //List<Category> allCategory =person.getAllCagetory(); // [Backpack, metal, herbs, weapon, clothes]
        assertEquals(8, person.getPackBy(Category.BACKPACK).items().size());
        assertEquals(4, person.getPackBy(Category.METAL).items().size());
        assertEquals(4, person.getPackBy(Category.HERB).items().size());
        assertEquals(4, person.getPackBy(Category.WEAPON).items().size());
        assertEquals(4, person.getPackBy(Category.CLOTHES).items().size());
    }
}
