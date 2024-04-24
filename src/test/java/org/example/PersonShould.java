package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonShould {
    //-add item to backpack
    //-add item to bag
    //-volcar los items a otro sitio
    //-delete items
    //-organize (lanza hechizo)

    @Test
    void AddOneItemItGoesToBackback() {
        Person person = new Person();
        Item item = new Item("iron");

        person.addItem(item);

        assertEquals(1, person.getBackpack().size());
    }
}
