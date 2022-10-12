package com.gildedrose.item;

public class Sulfuras extends AbstractItem{
    public Sulfuras(int sellIn) {
        super(new Item("Sulfuras, Hand of Ragnaros", sellIn, 80));
    }

    @Override
    public void updateQuality() {
    }
}
