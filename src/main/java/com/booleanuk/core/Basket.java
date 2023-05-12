package com.booleanuk.core;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> items;
    private int capacity;
    private Inventory inventory;
    public Basket(){
        this.items = new ArrayList<>();
        this.capacity = 5; //default value?
        this.inventory = new Inventory();
    }

    public Basket(int capacity) {
        this.items = new ArrayList<>();
        this.inventory = new Inventory();
        setCapacity(capacity);
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void setCapacity(int capacity) {
        if(capacity<=0){
            System.out.println("Cannot change the basket capacity to something negative!");
        }else if(capacity<this.items.size()){
            System.out.println("Cannot change capacity to something smaller than the current number of items in the basket!");
        }else {
            this.capacity = capacity;
        }
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void addItem(Item item){
        if(this.items.size()>=capacity){
            System.out.println("Your basket is full!");
        }else if(!this.inventory.isValid(item)){
            System.out.println("Item is not valid");
        }else {
            this.items.add(item);
        }
    }
    public void addItem(String sku){
        for(Item item:this.inventory.getInventoryItems()){
            if(sku.equals(item.getSku())){
                System.out.println("Added the item");
                this.addItem(item);
                return;
            }
        }
        System.out.println("Invalid SKU");
    }


}
