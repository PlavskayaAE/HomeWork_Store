package ru.netology;

public class Product {
  private String name;
  private String manufacturer;
  private int price;

    public Product() {
    }

    public String getName() {
        return name;
    }

      public String getManufacturer() {
        return manufacturer;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return
                "Шоколад " + name + ", " +
                "Производитель: " + manufacturer + ", " +
                "Цена: " + price + " рублей";

    }
}
