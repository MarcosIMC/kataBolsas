package org.example;

import java.util.ArrayList;
import java.util.List;

//Añadir y mirar el reduce para el remove de la lista
//Ordenar los elementos del pack

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

    public String[] getBackpackItemsName() { return null;}

    public String[] getBagItemsName() { return null;}

    public void addItems(Item[] items) {
        for (Item item: items){
            addItem(item);
        }
    }

    public void doMagic() {
        ArrayList<Item> floor = new ArrayList<>();

        for (Pack pack: this.inventory){
            floor.addAll(pack.items());
            pack.items().clear();
        }

        for (Item item: floor){
            Pack currentBag = getPackBy(item.getCategory());

            if (currentBag != null){
                if (currentBag.items().size() < currentBag.maxCapacity()) {
                    currentBag.addItem(item);
                } else if (this.inventory.get(0).items().size() < this.inventory.get(0).maxCapacity()) {
                    this.inventory.get(0).addItem(item);
                }
            } else if (this.inventory.get(0).items().size() < this.inventory.get(0).maxCapacity()) {
                this.inventory.get(0).addItem(item);
            }
        }
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
