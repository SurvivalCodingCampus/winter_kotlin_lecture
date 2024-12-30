package com.survivalcoding.day08;

import java.util.Objects;

public class Item {
    private int value;
    private String name;

    public Item(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public Item(int value) {
        this.value = value;
    }

    public Item(String name) {
        this.name = name;
    }

    public Item() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return value == item.value && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, name);
    }

}
