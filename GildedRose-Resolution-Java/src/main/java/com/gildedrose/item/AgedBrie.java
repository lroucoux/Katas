package com.gildedrose.item;

public class AgedBrie extends AbstractItem {

    public AgedBrie(int sellIn, int quality) {
        super(new Item("Aged Brie", sellIn, quality));
    }

    @Override
    public void updateQuality() {
        if (this.getQuality() < 50) {
            this.item.quality++;
        }
        this.item.sellIn--;

    }
}
