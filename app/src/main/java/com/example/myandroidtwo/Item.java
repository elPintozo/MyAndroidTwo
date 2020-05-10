package com.example.myandroidtwo;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Item {
    private int id;
    private String name;
    private Boolean stock;

    public Item(int id, String name, Boolean stock){
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getStock() {
        return stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStock(Boolean stock) {
        this.stock = stock;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }

    public static ArrayList<Item> getItems(){
        ArrayList<Item> items =  new ArrayList<>();
        items.add(new Item(1, "producto 1", true));
        items.add(new Item(2, "producto 2", false));
        items.add(new Item(3, "producto 3", true));
        items.add(new Item(4, "producto 4", false));
        items.add(new Item(5, "producto 5", true));
        items.add(new Item(6, "producto 6", false));
        items.add(new Item(7, "producto 7", true));
        items.add(new Item(8, "producto 8", false));
        items.add(new Item(9, "producto 9", true));
        items.add(new Item(10, "producto 10", false));

        return items;
    }
}
