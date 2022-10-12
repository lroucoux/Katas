package com.gildedrose.item;

public class Backstage extends AbstractItem {
    public Backstage(int sellIn, int quality) {
        super(new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality));
    }

    @Override
    public void updateQuality() {
        if (this.getQuality() < 50) {
            this.item.quality++;
        }

        if (this.item.sellIn < 11 && this.item.quality < 50) {
            this.item.quality++;
        }

        if (this.item.sellIn < 6 && this.item.quality < 50) {
            this.item.quality++;
        }

        this.item.sellIn--;

        if (this.item.sellIn < 0) {
            this.item.quality = 0;
        }
    }
}
