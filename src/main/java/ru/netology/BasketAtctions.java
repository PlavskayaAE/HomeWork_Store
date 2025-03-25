package ru.netology;

import java.util.List;

public interface BasketAtctions {

    static int[][] newBasket(List<Product> list) {
        int[][] basket = new int[list.size()][2];
        for (int i = 0; i < basket.length; i++) {
            basket[i][0] = list.get(i).getArticle();
            basket[i][1] = 0;
        }
        return basket;
    }

    static void putOnBasket(int[][] basket, int article, int amount) {
        if ((article > 0) & (article <= basket.length) & (amount > 0)) {
            basket[article - 1][1] += amount;
            System.out.println("Товары успешно добавлены!");
        } else {
            System.out.println("Не удалось добавить товары в корзину! " +
                    "Убедитесь, что указали правильный номер товара и количество товаров больше 0");
        }
    }

    static void RemoveFromBasket(int[][] basket, int article, int amount) {
        if ((article > 0) & (article <= basket.length) & (amount > 0)) {
            if ((basket[article - 1][1] - amount) < 0) {
                basket[article - 1][1] = 0;
                System.out.println("В Вашей корзине не было такого количества товаров! Все товары с данным номером удалены из корзины.");
            } else {
                basket[article - 1][1] -= amount;
                System.out.println("Товары успешно удалены!");
            }
        } else {
            System.out.println("Не удалось удалить товары из корзины! " +
                    "Убедитесь, что указали правильный номер товара и количество товаров после удаления больше или равно 0");
        }
    }

    static void printBasket(int[][] basket, List<Product> list) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i][1] != 0) {
                count += basket[i][1];
                sum += list.get(i).getPrice() * basket[i][1];
                System.out.println(list.get(i).getName() + " - " + basket[i][1] + " шт.");
            }
        }
        if (count == 0) {
            System.out.println("Ваша корзина пока пуста!");
        } else {
            System.out.println("Всего " + count + " товаров на сумму " + sum + " рублей");
        }
    }

    static boolean basketIsEmpty(int[][] basket) {
        int count = 0;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i][1] != 0) {
                count += basket[i][1];
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

}
