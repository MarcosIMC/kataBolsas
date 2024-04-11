package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BagTest {
    private Item item = new Item("iron", "metal");
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
}
