package ru.netology;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Store.startStore();// Формирует актуальный лист со всеми продуктами из файла
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Приветствуем в магазине шоколада!
                Выберите действие:
                1. Посмотреть доступные товары
                2. Сделать заказ
                3. Поиск товара по названию производителя
                4. Поиск товара по цене
                5. Повторить предыдущий заказ
                """);
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case (1):Store.printStoreList();
        }

    }






}