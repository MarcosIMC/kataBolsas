package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BagTest {
    // Add new item
    // Check if is full
    // Try add item when backpack is full
    // Delete item
    private Item item = new Item("iron", CategoryTypes.METALS);
    @Test
    public void add_one_item_to_bag () {
        Bag bag = new Bag();
        bag.addItem(item);
        assertTrue(bag.items().contains(item));
    }
    @Test
    void check_if_bag_is_full_or_not() {
        Bag bag = new Bag();
        for (int iterator = 0; iterator < 3; iterator++) {
            bag.addItem(item);
        }
        assertFalse(bag.isFull());
        bag.addItem(item);
        assertTrue(bag.isFull());
    }
    @Test
    void add_item_if_have_space() {
        Bag bag = new Bag();
        for (int iterator = 0; iterator < 10; iterator++) {
            bag.addItem(item);
        }
        assertEquals(4, bag.items().size());
    }
    @Test
    void delete_item(){
        Bag bag = new Bag();
        bag.addItem(item);
        bag.addItem(item);
        bag.addItem(item);
        bag.removeItem(item);

        assertEquals(2, bag.items().size());
    }
}
