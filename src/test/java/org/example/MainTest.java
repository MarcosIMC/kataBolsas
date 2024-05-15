package org.example;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    void executeMagic() {
        Person durance = new Person(new ArrayList<>(Arrays.asList(Category.METAL, Category.WEAPON, Category.NONE, Category.NONE)));
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
                new Item("Cherry Blossom", Category.HERB),
        };
        List<String> itemsInBackpack = List.of("Cherry Blossom", "Iron", "Leather", "Marigold", "Silk", "Wool");
        List<String> itemsInMetalBag = List.of("Copper", "Copper", "Copper", "Gold");

        durance.addItems(items);
        durance.doMagic();

        assertEquals(6, durance.getPackBy(Category.BACKPACK).items().size());
        assertEquals(4, durance.getPackBy(Category.METAL).items().size());
        assertEquals(itemsInBackpack, durance.getPackItemsName(durance.getPackBy(Category.BACKPACK)));
        assertEquals(itemsInMetalBag, durance.getPackItemsName(durance.getPackBy(Category.METAL)));
    }
}
