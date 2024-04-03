package org.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BackpackTest {
    //Add new item
    //Check if is full
    //Try add item when backpack is full

    @Test
    @Description("Add one item to backpack")
    void addItem() {
        Backpack backpack = new Backpack();
        backpack.addItem("Iron");
        assertTrue(backpack.items().contains("Iron"));
    }

    @Test
    @Description("Check if backpack is full or not")
    void isFull() {
        Backpack backpack = new Backpack();

        for (int iterator = 0; iterator < 7; iterator++) {
            backpack.addItem("Iron");
        }
        assertFalse(backpack.isFull());
        backpack.addItem("Iron");
        assertTrue(backpack.isFull());
    }

    @Test
    @Description("Add item if backpack is not full")
    void addItemIfHaveSpace() {
        Backpack backpack = new Backpack();
        for (int iterator = 0; iterator < 10; iterator++) {
            backpack.addItem("Iron");
        }
        assertEquals(8, backpack.items().size());
    }
}
