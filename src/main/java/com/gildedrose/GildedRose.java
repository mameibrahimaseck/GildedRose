package com.gildedrose;

import java.util.Arrays;
import java.util.List;

class GildedRose {

    Item[] items;

    /**
     * better to get this lists from a reference table so that it will be possible to add or delete item name without recompiling
     */
    List<String> itemsToIncrease = Arrays.asList("Aged Brie","Backstage passes to a TAFKAL80ETC concert","Sulfuras, Hand of Ragnaros");
    List<String> itemsToIncreaseTweece = Arrays.asList("Backstage passes to a TAFKAL80ETC concert");
    List<String> itemsToDecreaseTweece = Arrays.asList("Conjured Mana Cake");
    List<String> finalSellInItems = Arrays.asList("Sulfuras, Hand of Ragnaros");

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            computeItem(items[i]);

            if (!finalSellInItems.contains(items[i].name)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                handlePastSellin(items[i]);
            }
        }
    }

    private void computeItem(Item item) {
        if (!itemsToIncrease.contains(item.name)) {
            decreaseQuality(item);
        } else {
            increaseQuality(item);
            if (itemsToIncreaseTweece.contains(item.name)) {
                increaseBaseOnSellIn(item);
            }
        }
    }

    private void handlePastSellin(Item item) {
        if (!itemsToIncrease.contains(item.name)) {
            decreaseQuality(item);
        } else {
            increaseQuality(item);
        }
    }

    private void increaseBaseOnSellIn(Item item) {
        if (item.sellIn < 11) {
            increaseQuality(item);
        }

        if (item.sellIn < 6) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item){
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQuality(Item item){
        if (item.quality > 0) {
            item.quality = itemsToDecreaseTweece.contains(item.name) ? item.quality - 2 : item.quality - 1;
        }
    }
}