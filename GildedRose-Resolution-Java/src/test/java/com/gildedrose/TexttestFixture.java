package com.gildedrose;

import com.gildedrose.item.AbstractItem;
import com.gildedrose.item.AgedBrie;
import com.gildedrose.item.Backstage;
import com.gildedrose.item.Conjured;
import com.gildedrose.item.Normal;
import com.gildedrose.item.Sulfuras;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        AbstractItem[] items = new AbstractItem[]{
            new Normal("+5 Dexterity Vest", 10, 20), //
            new AgedBrie(2, 0), //
            new Normal("Elixir of the Mongoose", 5, 7), //
            new Sulfuras(0), //
            new Sulfuras(-1),
            new Backstage(15, 20),
            new Backstage(10, 49),
            new Backstage(5, 49),
            // this conjured item does not work properly yet
            new Conjured(3, 6)};

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (AbstractItem item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
