package ru.netology;

public class Product implements SearchProduct {
    private int article;
    private String name;
    private String manufacturer;
    private int price;

    public Product() {
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
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
                article + ". Шоколад " + name + ", " +
                        "Производитель: " + manufacturer + ", " +
                        "Цена: " + price + " рублей";

    }
}
