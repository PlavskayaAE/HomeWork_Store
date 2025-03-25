package ru.netology;

public class Tea extends Product {
    private int article;
    private String name;
    private int price;

    @Override
    public String getManufacturer() {
        return "Собственного производства";
    }

    public Tea(int article, String name, int price) {
        this.article = article;
        this.name = name;
        this.price = price;
    }

    @Override
    public int getArticle() {
        return article;
    }

    @Override
    public void setArticle(int article) {
        super.setArticle(article);
    }

    @Override
    public String getName() {
        return "Чай " + name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return article + ". " + getName() + ", " +
                getManufacturer() + ", " +
                "Цена: " + price + " рублей";

    }


}
