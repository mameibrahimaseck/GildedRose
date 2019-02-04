package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {

        GildedRose app = getGiledRoseInstance("foo",0,0);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void conjured(){
        GildedRose app =  getGiledRoseInstance("Conjured Mana Cake", 3, 5);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void sulfuras(){
        GildedRose app =  getGiledRoseInstance("Sulfuras, Hand of Ragnaros", 8, 25);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(8, app.items[0].sellIn);
        assertEquals(26, app.items[0].quality);
    }

    private GildedRose getGiledRoseInstance(String name, int sellIn, int quality){
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        return app;
    }

}
