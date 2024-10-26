package org.labs.Tasks.Task8;

import java.util.Objects;
import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class ShopItem {
    private final String name;
    private final double price;
    private final int quantity;

    public ShopItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ShopItem{name='" + name + "', price=" + price + ", quantity=" + quantity + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ShopItem item = (ShopItem) obj;

        return Double.compare(item.price, price) == 0 && quantity == item.quantity && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }

    public static void main(String[] args) {
        String[] itemNames = {"книга", "ручка", "линейка", "пенал"};
        double[] itemPrices = {15.0, 25.0, 35.0, 45.0};
        int[] itemQuantities = {5, 10, 15, 20};
        Random random = new Random();

        ShopItem[] inventory = new ShopItem[100];

        List<ShopItem> predefinedItems = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String name = itemNames[random.nextInt(itemNames.length)];
            double price = itemPrices[random.nextInt(itemPrices.length)];
            int quantity = itemQuantities[random.nextInt(itemQuantities.length)];
            predefinedItems.add(new ShopItem(name, price, quantity));
        }

        for (int i = 0; i < inventory.length; i++) {
            if (random.nextDouble() < 0.3) {
                inventory[i] = predefinedItems.get(random.nextInt(predefinedItems.size()));
            } else {
                String name = itemNames[random.nextInt(itemNames.length)];
                double price = 10.0 + (90.0 * random.nextDouble());
                int quantity = random.nextInt(10) + 1;
                inventory[i] = new ShopItem(name, price, quantity);
            }
        }

        Arrays.sort(inventory, Comparator.comparing(ShopItem::getName));

        for (ShopItem item : inventory) {
            System.out.println(item);
        }

        Map<ShopItem, Integer> itemCounts = new HashMap<>();

        for (ShopItem item : inventory) {
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
        }

        int duplicateItems = 0;
        for (Map.Entry<ShopItem, Integer> entry : itemCounts.entrySet()) {
            int count = entry.getValue();
            if (count > 1) {
                duplicateItems += count - 1;
            }
        }

        System.out.println("Количество одинаковых ShopItem: " + duplicateItems);
    }
}
