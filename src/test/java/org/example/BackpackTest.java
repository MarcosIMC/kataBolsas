package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BackpackTest {
    // Add new item
    // Check if is full
    // Try add item when backpack is full
    // Delete item
    private final Item item = new Item("iron", CategoryTypes.METALS);

    @Test
    public void add_one_item_to_backpack () {
        Backpack backpack = new Backpack();
        backpack.addItem(item);
        assertTrue(backpack.items().contains(item));
    }
    @Test
    void check_if_backpack_is_full_or_not() {
        Backpack backpack = new Backpack();

        for (int iterator = 0; iterator < 7; iterator++) {
            backpack.addItem(item);
        }
        assertFalse(backpack.isFull());
        backpack.addItem(item);
        assertTrue(backpack.isFull());
    }
    @Test
    void add_item_if_have_space() {
        Backpack backpack = new Backpack();
        for (int iterator = 0; iterator < 10; iterator++) {
            backpack.addItem(item);
        }
        assertEquals(8, backpack.items().size());
    }
    @Test
    void delete_item(){
        Backpack backpack = new Backpack();
        backpack.addItem(item);
        backpack.addItem(item);
        backpack.addItem(item);
        backpack.removeItem(item);

        assertEquals(2, backpack.items().size());
    }
}
