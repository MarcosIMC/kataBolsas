package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    void executeMagic() {
        Person durance = new Person();
        Item[] items = new Item[] {
                new Item("Leather"),
                new Item("Iron"),
                new Item("Copper"),
                new Item("Marigold"),
                new Item("Wool"),
                new Item("Gold"),
                new Item("Solk"),
                new Item("Copper"),
                new Item("Copper"),
                new Item("Cherry Blosom"),
        };
        String[] itemsInBackpack = {"Cherry Blossom", "Iron", "Leather", "Marigold", "Silk", "Wool"};
        String[] itemsInMetalBag = {"Copper", "Copper", "Copper", "Gold"};

        durance.addItems(items);
        durance.organize();

        assertEquals(6, durance.getBackpack().items().size());
        assertEquals(4, durance.getMetalBag().items().size());
        assertArrayEquals(itemsInBackpack, durance.getBackpackItemsName());
        assertArrayEquals(itemsInMetalBag, durance.getBagItemsName());

    }
}
