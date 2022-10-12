package com.gildedrose.item;

public class Normal extends AbstractItem {

    public Normal(String name, int sellIn, int quality) {
        super(new Item(name, sellIn, quality));
    }

    @Override
    public void updateQuality() {
        if (this.item.quality > 0) {
            this.item.quality = this.item.quality - 1;
        }

        this.item.sellIn--;

        if(this.item.sellIn < 0) {
            if (this.item.quality > 0) {
                this.item.quality = this.item.quality - 1;
            }
        }
    }
}
