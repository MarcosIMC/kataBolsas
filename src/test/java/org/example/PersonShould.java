package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    private ArrayList<Category> obtainSetup() {
        ArrayList<Category> categories = new ArrayList<>();

        categories.add(Category.CLOTHES);
        categories.add(Category.HERB);
        categories.add(Category.METAL);
        categories.add(Category.WEAPON);

        return categories;
    }

    private ArrayList<Category> obtainSetup2() {
        ArrayList<Category> categories = new ArrayList<>();

        categories.add(Category.CLOTHES);
        categories.add(Category.CLOTHES);
        categories.add(Category.METAL);
        categories.add(Category.WEAPON);

        return categories;
    }

    @Test
    void AddOneItemItGoesToBackpack() {
        Person person = new Person(obtainSetup());
        Item item = new Item("iron");

        person.addItem(item);

        assertEquals(1, person.getPackBy(Category.BACKPACK).items().size());
    }
    @Test
    void DoNotAddMoreThanEightItemsToBackpack() {
        Person person = new Person(obtainSetup());
        Item item = new Item("iron");
        for (int i = 0; i < 10; i++) {
            person.addItem(item);
        }
        assertEquals(person.getPackBy(Category.BACKPACK).maxCapacity(),
                person.getPackBy(Category.BACKPACK).items().size());
    }
    @Test
    void AddOneItemItGoesToMetalBag() {
        Person person = new Person(obtainSetup());
        List<Category> allCategory = person.getAllCagetory();
        Item item = new Item("iron");
        for (int i = 0; i < 10; i++) {
            person.addItem(item);
        }
        assertEquals(2, person.getPackBy(allCategory.get(1)).items().size());
    }
    @Test
    void DoNotAddMoreThanFourItemsToMetalBag() {
        Person person = new Person(obtainSetup());
        List<Category> allCategory = person.getAllCagetory();
        Item item = new Item("iron");
        for (int i = 0; i < 15; i++) {
            person.addItem(item);
        }
        assertEquals(person.getPackBy(allCategory.get(1)).maxCapacity(),
                person.getPackBy(allCategory.get(1)).items().size());
    }

    @Test
    void fillAllPacks(){
        Person person = new Person(obtainSetup());
        List<Category> allCategory = person.getAllCagetory();
        Item item = new Item("iron");

        for (int i = 0; i < 24; i++) {
            person.addItem(item);
        }

        allCategory.forEach((category) ->{
            assertEquals(person.getPackBy(category).maxCapacity(),
                    person.getPackBy(category).items().size());
        });

    }

    @Test
    void addItemsWithTwoBagsSameCategory() {
        Person person = new Person(obtainSetup2());

        List<Category> allCategory = person.getAllCagetory();
        Item item = new Item("iron");

        for (int i = 0; i < 24; i++) {
            person.addItem(item);
        }

        allCategory.forEach((category) ->{
            assertEquals(person.getPackBy(category).maxCapacity(),
                    person.getPackBy(category).items().size());
        });

        assertEquals(4, person.getInventory().get(3).items().size());
    }
}
