package ru.netology;

import java.util.ArrayList;
import java.util.List;

public interface Search {
    default <T> List<T> Search(String example, List<T> list) {
        List<T> search = new ArrayList<T>();
        for (T product : list) {
            if (product.toString().toLowerCase().contains(example.toLowerCase())) {
                if (search.isEmpty()) {
                    System.out.println("Вот что удалось найти:");
                }
                search.add(product);
            }
        }
        if (search.isEmpty()) {
            System.out.println("Товаров не найдено!");
        }
        System.out.println(search.toString());
        return search;
    }
}
