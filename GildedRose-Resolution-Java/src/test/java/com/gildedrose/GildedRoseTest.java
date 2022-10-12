package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.gildedrose.item.AbstractItem;
import com.gildedrose.item.AgedBrie;
import com.gildedrose.item.Backstage;
import com.gildedrose.item.Conjured;
import com.gildedrose.item.Normal;
import com.gildedrose.item.Sulfuras;

class GildedRoseTest {

    @Nested
    class Quality {

        @Test
        void should_decrement_once_after_one_day() {
            AbstractItem[] items = new AbstractItem[]{new Normal("foo", 5, 4)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 1);
            assertEquals(3, app.items[0].getQuality());
        }

        @Test
        void should_never_be_negative() {
            AbstractItem[] items = new AbstractItem[]{new Normal("foo", 5, 4)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 10);
            assertEquals(0, app.items[0].getQuality());
        }

        @Test
        void should_decrement_twice_faster_when_sellIn_is_negative() {
            AbstractItem[] items = new AbstractItem[]{new Normal("foo", -1, 4)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 2);
            assertEquals(0, app.items[0].getQuality());

        }
    }

    @Nested
    class SellIn {
        @Test
        void should_decrement_once_after_one_day() {
            AbstractItem[] items = new AbstractItem[]{new Normal("foo", 5, 4)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 1);
            assertEquals(4, app.items[0].getSellIn());
        }
    }

    @Nested
    class AgedBrieTest {
        @Test
        void should_increment_quality_after_one_day() {
            AbstractItem[] items = new AbstractItem[]{new AgedBrie(15, 0)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 10);
            assertEquals(10, app.items[0].getQuality());
        }

        @Test
        void should_quality_never_be_more_than_50() {
            AbstractItem[] items = new AbstractItem[]{new AgedBrie(10, 45)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 10);
            assertEquals(50, app.items[0].getQuality());
        }
    }

    @Nested
    class SulfurasTest {
        @Test
        void should_never_decrement_quality() {
            AbstractItem[] items = new AbstractItem[]{new Sulfuras(10)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 10);
            assertEquals(80, app.items[0].getQuality());
        }

        @Test
        void should_never_decrement_sellIn() {
            AbstractItem[] items = new AbstractItem[]{new Sulfuras(10)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 10);
            assertEquals(10, app.items[0].getSellIn());
        }
    }

    @Nested
    class BackstagePassesTest {

        @Test
        void should_not_increment_quality_more_than_50() {
            AbstractItem[] items = new AbstractItem[]{new Backstage(20, 50)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 10);
            assertEquals(50, app.items[0].getQuality());
        }

        @Test
        void should_increment_quality_once_if_sellIn_is_more_than_10() {
            AbstractItem[] items = new AbstractItem[]{new Backstage(20, 0)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 10);
            assertEquals(10, app.items[0].getQuality());
        }

        @Test
        void should_increment_quality_twice_if_sellIn_is_between_10_and_6_inclus() {
            AbstractItem[] items = new AbstractItem[]{new Backstage(10, 0)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 5);
            assertEquals(10, app.items[0].getQuality());
        }

        @Test
        void should_not_increment_quality_twice_if_sellIn_is_between_10_and_6_inclus_and_quality_is_50() {
            AbstractItem[] items = new AbstractItem[]{new Backstage(10, 50)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 4);
            assertEquals(50, app.items[0].getQuality());
        }

        @Test
        void should_increment_quality_three_times_if_sellIn_is_equal_or_less_than_5() {
            AbstractItem[] items = new AbstractItem[]{new Backstage(5, 0)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 5);
            assertEquals(15, app.items[0].getQuality());
        }

        @Test
        void should_not_increment_quality_three_times_if_sellIn_is_equal_or_less_than_5_and_quality_is_50() {
            AbstractItem[] items = new AbstractItem[]{new Backstage(5, 50)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 5);
            assertEquals(50, app.items[0].getQuality());
        }

        @Test
        void should_quality_be_zero_when_sellIn_is_negative() {
            AbstractItem[] items = new AbstractItem[]{new Backstage(5, 10)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 10);
            assertEquals(0, app.items[0].getQuality());
        }
    }

    @Nested
    class ConjuredTest {
        @Test
        void should_decrement_quality_twice_after_one_day() {
            AbstractItem[] items = new AbstractItem[]{new Conjured(5, 10)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 1);
            assertEquals(8, app.items[0].getQuality());
        }

        @Test
        void should_decrement_sellIn_once_after_one_day() {
            AbstractItem[] items = new AbstractItem[]{new Conjured(5, 10)};
            GildedRose app = new GildedRose(items);
            updateQualityforNDays(app, 1);
            assertEquals(4, app.items[0].getSellIn());
        }
    }


    private static void updateQualityforNDays(GildedRose app, int days) {
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
    }

}
