package com.gildedrose.item;

public abstract class AbstractItem {

    protected Item item;

    public abstract void updateQuality();

    protected AbstractItem(Item item) {
        this.item = item;
    }

    public int getQuality() {
        return this.item.quality;
    }

    public int getSellIn() {
        return this.item.sellIn;
    }

    public String toString() {
        return item.toString();
    }
}
