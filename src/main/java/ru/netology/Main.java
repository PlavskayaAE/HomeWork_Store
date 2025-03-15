package ru.netology;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Product> store = new ArrayList<>();

    public static void main(String[] args) {
        store = startStore(); // Лист со всеми продуктами
        printStoreList(); // Выведение полки магазина в консоль


    }


    static List<Product> startStore() {
        String[] columnMapping = {"name", "manufacturer", "price"};
        List<Product> store = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("C:/Users/Александра/IdeaProjects/HW_MagicDrySOLID/src/main/java/ru/netology/store.csv"))) {
            ColumnPositionMappingStrategy<Product> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Product.class);
            strategy.setColumnMapping(columnMapping);
            CsvToBean<Product> csv = new CsvToBeanBuilder<Product>(reader)
                    .withMappingStrategy(strategy)
                    .build();
            store = csv.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return store;
    }

    static void printStoreList() {
        for (int i = 0; i < store.size(); i++) {
            System.out.println((i+1) + ". " + store.get(i).toString());
        }
    }
}