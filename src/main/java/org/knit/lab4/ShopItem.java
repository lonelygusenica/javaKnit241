package org.knit.lab4;

import java.util.Objects;

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
        return "org.knit.lab4.ShopItem{name='" + name + "', price=" + price + ", quantity=" + quantity + "}";
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
}
