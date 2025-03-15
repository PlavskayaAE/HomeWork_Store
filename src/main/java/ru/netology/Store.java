package ru.netology;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Store {
    static List<Product> store = new ArrayList<>();

    static List<Product> getStore() {
        return store;
    }

    static void startStore() {
        String[] columnMapping = {"name", "manufacturer", "price"};

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

    }

    static void printStoreList() {
        for (int i = 0; i < store.size(); i++) {
            System.out.println((i + 1) + ". " + store.get(i).toString());
        }
    }

}
