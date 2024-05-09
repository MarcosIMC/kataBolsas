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

        assertEquals(1, person.getBackpack().items().size());
    }
    @Test
    void DoNotAddMoreThanEightItemsToBackpack() {
        Person person = new Person();
        Item item = new Item("iron");
        for (int i = 0; i < 10; i++) {
            person.addItem(item);
        }
        assertEquals(8, person.getBackpack().items().size());
    }
    @Test
    void AddOneItemItGoesToMetalBag() {
        Person person = new Person();
        Item item = new Item("iron");
        for (int i = 0; i < 10; i++) {
            person.addItem(item);
        }
        assertEquals(2, person.getMetalBag().items().size());
    }
    @Test
    void DoNotAddMoreThanFourItemsToMetalBag() {
        Person person = new Person();
        Item item = new Item("iron");
        for (int i = 0; i < 15; i++) {
            person.addItem(item);
        }
        assertEquals(4, person.getMetalBag().items().size());
    }
}
