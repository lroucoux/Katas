package com.gildedrose;

import com.gildedrose.item.AbstractItem;

class GildedRose {
    AbstractItem[] items;

    public GildedRose(AbstractItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (AbstractItem item : items) {
            item.updateQuality();
        }
    }
}
