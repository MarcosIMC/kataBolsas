package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Person {
    private ArrayList<Pack> inventory = new ArrayList<>();

    public Person(ArrayList<Category> allCategories) {
        this.inventory.add(new BackPack());

        for (Category category : allCategories) {
            this.inventory.add(new Bag(category));
        }
    }
    public ArrayList<Pack> getInventory() {
        return this.inventory;
    }
    public void addItem(Item item) {

        for (Pack pack: this.inventory){
            if (pack.items().size() < pack.maxCapacity()){
                pack.addItem(item);
                break;
            }
        }
    }
    public List<String> getPackItemsName(Pack backPack) {
        return backPack.items().stream().map(Item::getName).toList();
    }
    public void addItems(Item[] items) {
        for (Item item: items){
            addItem(item);
        }
    }
    public void doMagic() {
        ArrayList<Item> allItems= collectAllItemsFromPacks();
        allItems.sort(Comparator.comparing(Item::getName));
        for (Item item: allItems){
            Pack currentBag = getPackBy(item.getCategory());

            if (existBag(currentBag) && hasBagSpace(currentBag)){
                currentBag.addItem(item);
            } else if (hasBagSpace(getPackBy(Category.BACKPACK))) {
                getPackBy(Category.BACKPACK).addItem(item);
            }
        }
    }
    private boolean existBag(Pack currentBag) {
        return currentBag != null;
    }
    private boolean hasBagSpace(Pack currentBag) {
        return currentBag.items().size() < currentBag.maxCapacity();
    }
    private ArrayList<Item> collectAllItemsFromPacks() {
        ArrayList<Item> floor = new ArrayList<>();

        for (Pack pack: this.inventory){
            floor.addAll(pack.items());
            pack.items().clear();
        }
        return floor;
    }
    public Pack getPackBy(Category category) {
        List<Pack> packObtained = this.inventory.stream()
                .filter((pack) -> pack.category() == category)
                .toList();

        if (!packObtained.isEmpty()) {
            return packObtained.get(0);
        }
        return null;
    }
    public List<Category> getAllCagetory() {
        List<Category> allCategory = new ArrayList<>();
        this.inventory.forEach( (pack) -> {
            allCategory.add(pack.category());
        });
        return allCategory;
    }
}
