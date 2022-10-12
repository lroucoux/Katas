package com.gildedrose.item;

public class Conjured extends AbstractItem {
    public Conjured(int sellIn, int quality) {
        super(new Item("Conjured", sellIn, quality));
    }

    @Override
    public void updateQuality() {
        this.item.quality = this.item.quality - 2;
        this.item.sellIn--;
    }
}
