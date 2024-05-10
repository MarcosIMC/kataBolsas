package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    void executeMagic() {
        Person durance = new Person(null);
        Item[] items = new Item[] {
                new Item("Leather", Category.CLOTHES),
                new Item("Iron", Category.METAL),
                new Item("Copper", Category.METAL),
                new Item("Marigold", Category.HERB),
                new Item("Wool", Category.CLOTHES),
                new Item("Gold", Category.METAL),
                new Item("Silk", Category.CLOTHES),
                new Item("Copper", Category.METAL),
                new Item("Copper", Category.METAL),
                new Item("Cherry Blosom", Category.HERB),
        };
        String[] itemsInBackpack = {"Cherry Blossom", "Iron", "Leather", "Marigold", "Silk", "Wool"};
        String[] itemsInMetalBag = {"Copper", "Copper", "Copper", "Gold"};

        durance.addItems(items);
        durance.doMagic();

        assertEquals(6, durance.getPackBy(Category.BACKPACK).items().size());
        assertEquals(4, durance.getPackBy(Category.METAL).items().size());
        assertArrayEquals(itemsInBackpack, durance.getBackpackItemsName());
        assertArrayEquals(itemsInMetalBag, durance.getBagItemsName());

    }
}
