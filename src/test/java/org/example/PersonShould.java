package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonShould {
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
        Item item = new Item("iron", Category.METAL);

        person.addItem(item);

        assertEquals(1, person.getPackBy(Category.BACKPACK).items().size());
    }
    @Test
    void DoNotAddMoreThanEightItemsToBackpack() {
        Person person = new Person(obtainSetup());
        Item item = new Item("iron", Category.METAL);
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
        Item item = new Item("iron", Category.METAL);
        for (int i = 0; i < 10; i++) {
            person.addItem(item);
        }
        assertEquals(2, person.getPackBy(allCategory.get(1)).items().size());
    }
    @Test
    void DoNotAddMoreThanFourItemsToMetalBag() {
        Person person = new Person(obtainSetup());
        List<Category> allCategory = person.getAllCagetory();
        Item item = new Item("iron", Category.METAL);
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
        Item item = new Item("iron", Category.METAL);

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
        Item item = new Item("iron", Category.METAL);

        for (int i = 0; i < 24; i++) {
            person.addItem(item);
        }

        allCategory.forEach((category) -> {
            assertEquals(person.getPackBy(category).maxCapacity(),
                    person.getPackBy(category).items().size());
        });
        assertEquals(4, person.getInventory().get(3).items().size());
    }
    @Test
    void organizeByCategoryAndAlphabetically() { //DO MAGIC!!!!
        List<String> itemsInBackpack = List.of("Cherry Blossom", "Iron", "Leather", "Marigold", "Silk", "Wool");
        List<String> itemsInMetalBag = List.of( "Copper", "Copper", "Copper", "Gold");
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(Category.METAL);
        Person person = new Person(categories);
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
        person.addItems(items);

        person.doMagic();

        assertEquals(6, person.getPackBy(Category.BACKPACK).items().size());
        assertEquals(4, person.getPackBy(Category.METAL).items().size());
        assertEquals(itemsInBackpack, person.getPackItemsName(person.getPackBy(Category.BACKPACK)));
        assertEquals(itemsInMetalBag, person.getPackItemsName(person.getPackBy(Category.METAL)));
    }
}
