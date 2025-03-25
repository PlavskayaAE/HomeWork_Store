package ru.netology;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Store.startStore();// Формирует актуальный лист со всеми продуктами из файла
        int[][] basket = newBasket();// В корзине будет храниться информация о наименовании товаров и их количестве
        int[][] previousBasket = newBasket();// В этой корзине будет храниться последний завершенный заказ. Пока не завершен первый заказ, корзина пуста
        Scanner scanner = new Scanner(System.in);

        System.out.println("Приветствуем в магазине шоколада!");
        printStartMsg();

        while (true) {
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    System.out.println("Сегодня можно купить:");
                    Store.printStoreList();
                    printStartMsg();
                    break;

                case 2:
                    System.out.println("Для добавления товара в корзину укажите его номер: ");
                    int articleForPut = Integer.parseInt(scanner.nextLine());
                    System.out.println("Укажите количество товара: ");
                    int amountForPut = Integer.parseInt(scanner.nextLine());
                    putOnBasket(basket, articleForPut, amountForPut);
                    printStartMsg();
                    break;

                case 3:
                    System.out.println("Для удаления товара из корзины укажите его номер: ");
                    int articleForRemove = Integer.parseInt(scanner.nextLine());
                    System.out.println("Укажите количество товара: ");
                    int amountForRemove = Integer.parseInt(scanner.nextLine());
                    RemoveFromBasket(basket, articleForRemove, amountForRemove);
                    printStartMsg();
                    break;

                case 4:
                    System.out.println("Укажите, пожалуйста, название товара, который Вы хотели бы найти: ");
                    String inputName = scanner.nextLine();
                    SerchProduct.searchByName(inputName);
                    printStartMsg();
                    break;

                case 5:
                    System.out.println("Укажите, пожалуйста, чьи товары Вы хотели бы найти: ");
                    String inputManufacturer = scanner.nextLine();
                    SerchProduct.searchByManufacturer(inputManufacturer);
                    printStartMsg();
                    break;

                case 6:
                    System.out.println("Укажите, пожалуйста, максимальную стоимость товаров, которые Вы хотели бы найти: ");
                    int inputPrice = Integer.parseInt(scanner.nextLine());
                    SerchProduct.searchByPrice(inputPrice);
                    printStartMsg();
                    break;

                case 7:
                    closingAnOrder(basket, previousBasket);
                    printStartMsg();
                    break;

                case 8:
                    if (basketIsEmpty(previousBasket)) {
                        System.out.println("Нет информации о предыдущем заказе. Соберите корзину еще раз.");
                    } else {
                        System.out.println("В прошлый раз Вы заказывали:");
                        printBasket(previousBasket);
                        System.out.println("Если хотите повторить заказ, напишете 'да':");
                        String yes = scanner.nextLine();
                        if (yes.equalsIgnoreCase("да")) {
                            repeatOrder(previousBasket, basket);
                        } else {
                            System.out.println("Хорошо,тогда выберите товары заново");
                            Store.printStoreList();
                            printStartMsg();
                        }
                    }
                    break;

                case 9:
                    printBasket(basket);
                    printStartMsg();
                    break;

                case 10:
                    System.out.println("Были рады Вас видеть! До новых встреч!");
                    return;
            }
        }

    }

    public static void printStartMsg() {
        System.out.println("""
                
                Выберите действие:
                1. Посмотреть доступные товары
                2. Добавить товары в корзину
                3. Удалить товары из корзины
                4. Поиск товара по названию
                5. Поиск товара по названию производителя
                6. Поиск товара по цене
                7. Оплатить и оформить доставку
                8. Повторить предыдущий заказ
                9. Отобразить корзину
                10. Завершить работу программы
                """);
    }


    public static void putOnBasket(int[][] basket, int article, int amount) {
        if ((article > 0) & (article <= basket.length) & (amount > 0)) {
            basket[article - 1][1] += amount;
            System.out.println("Товары успешно добавлены!");
        } else {
            System.out.println("Не удалось добавить товары в корзину! " +
                    "Убедитесь, что указали правильный номер товара и количество товаров больше 0");
        }
    }

    public static void RemoveFromBasket(int[][] basket, int article, int amount) {
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

    public static int[][] newBasket() {
        int[][] basket = new int[Store.getStore().size()][2];
        for (int i = 0; i < basket.length; i++) {
            basket[i][0] = Store.getStore().get(i).getArticle();
            basket[i][1] = 0;
        }
        return basket;
    }

    public static void printBasket(int[][] basket) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i][1] != 0) {
                count += basket[i][1];
                sum += Store.getStore().get(i).getPrice() * basket[i][1];
                System.out.println(Store.getStore().get(i).getName() + " - " + basket[i][1] + " шт.");
            }
        }
        if (count == 0) {
            System.out.println("Ваша корзина пока пуста!");
        } else {
            System.out.println("Всего " + count + " товаров на сумму " + sum + " рублей");
        }
    }

    public static void closingAnOrder(int[][] basket, int[][] previousBasket) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i][1] != 0) {
                previousBasket[i][1] = basket[i][1];
            }
        }
        printBasket(basket);
        System.out.println("Для оплаты товаров перейдите по ссылке: 'ССЫЛКА НА ОПЛАТУ' ");
        System.out.println("Оплата прошла успешно!");
        System.out.println("Товар доставлен!");
        for (int i = 0; i < basket.length; i++) {
            basket[i][1] = 0;
        }
    }

    public static void repeatOrder(int[][] previousBasket, int[][] basket) {
        for (int i = 0; i < basket.length; i++) {
            if (previousBasket[i][1] != 0) {
                basket[i][1] = previousBasket[i][1];
            }
        }
        printBasket(basket);
        System.out.println("Для оплаты товаров перейдите по ссылке: 'ССЫЛКА НА ОПЛАТУ' ");
        System.out.println("Оплата прошла успешно!");
        System.out.println("Товар доставлен!");
        for (int i = 0; i < basket.length; i++) {
            basket[i][1] = 0;
        }
    }

    public static boolean basketIsEmpty(int[][] basket) {
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