package ru.netology;

import org.junit.Ignore;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Store.startStore();// Формирует актуальный лист со всеми продуктами из файла
        int[][] basket = new int[Store.getStore().size()][]; // В корзине будет храниться информация о наименовании товаров и их количестве
        Scanner scanner = new Scanner(System.in);

        System.out.println("Приветствуем в магазине шоколада!");
        printStartMsg();

        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                System.out.println("Сегодня можно купить:");
                Store.printStoreList();
                printStartMsg();
                break;

            case 2:
                //TODO  цикл, который предлагает покупателю добавить в корзину товар, запрашивая номер товара и количество.
                // Выводит сообщение о том, что для удаления товара из корзины необходимо указать номер товара и количество со знаком
                // "-", после принимает два инта, дабавляет в корзину товар по первому инту-1 и и его цену. Если в результате количество добавляемого товара
                // прогрмамма не падает, а ловит ошибку, и оставляет товар в корзине с количеством 0
                break;

            case 3:
                System.out.println("Укажите, пожалуйста, название товара, который Вы хотели бы найти: ");
                String inputName = scanner.nextLine();
                searchByName(inputName);
                printStartMsg();
                break;

            case 4:
                System.out.println("Укажите, пожалуйста, чьи товары Вы хотели бы найти: ");
                String inputManufacturer = scanner.nextLine();
                searchByManufacturer(inputManufacturer);
                printStartMsg();
                break;

            case 5:
                System.out.println("Укажите, пожалуйста, максимальную стоимость товаров, которые Вы хотели бы найти: ");
                int inputPrice = Integer.parseInt(scanner.nextLine());
                searchByPrice(inputPrice);
                printStartMsg();
                break;

            case 6:


        }

    }

    public static void printStartMsg() {
        System.out.println("""
                
                Выберите действие:
                1. Посмотреть доступные товары
                2. Сделать заказ
                3. Поиск товара по названию
                4. Поиск товара по названию производителя
                5. Поиск товара по цене
                6. Повторить предыдущий заказ
                7. Завершить работу программы
                """);
    }

    public static void searchByManufacturer(String manufacturer) {
        boolean count = false;
        for (Product product : Store.getStore()) {
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

    public static void searchByName(String name) {
        boolean count = false;
        for (Product product : Store.getStore()) {
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

    public static void searchByPrice(int price) {
        boolean count = false;
        for (Product product : Store.getStore()) {
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