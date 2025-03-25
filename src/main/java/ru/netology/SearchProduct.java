package ru.netology;

import java.util.List;

public interface SearchProduct {

      static void searchByManufacturer(String manufacturer, List <Product> list) {
        boolean count = false;
        for (Product product : list) {
            if (product.getManufacturer().toLowerCase().contains(manufacturer.toLowerCase())) {
                if (!count) {
                    System.out.println("Вот что удалось найти:");
                }
                System.out.println(product);
                count = true;
            }
        }
        if (!count) {
            System.out.println("Товаров с таким производителем не найдено!");
        }
    }

    static void searchByName(String name, List <Product>list) {
        boolean count = false;
        for (Product product : list) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                if (!count) {
                    System.out.println("Вот что удалось найти:");
                }
                System.out.println(product);
                count = true;
            }
        }
        if (!count) {
            System.out.println("Товаров с таким названием не найдено!");
        }
    }

    static void searchByPrice(int price, List<Product>list) {
        boolean count = false;
        for (Product product : list) {
            if (product.getPrice() <= price) {
                if (!count) {
                    System.out.println("Вот что удалось найти:");
                }
                System.out.println(product);
                count = true;
            }
        }
        if (!count) {
            System.out.println("Товаров в пределах такой стоимости не найдено!");
        }
    }


}