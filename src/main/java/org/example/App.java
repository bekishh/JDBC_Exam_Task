package org.example;

import org.example.entity.Product;
import org.example.service.ProductService;
import org.example.service.serviceImpl.ProductServiceImpl;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerLn = new Scanner(System.in);

        ProductService productService = new ProductServiceImpl();

        while (true) {
            System.out.println("""
                    ------------------- Products -------------------
                    1) Добавить продукт
                    2) Получить продукт по ID
                    3) Обновить продукт
                    4) Удалить продукт
                    5) Вывести продукты по рейтингу
                    6) Вывести продукты по min_price, max_price
                                        
                    Ваша команда:
                    """);
            switch (scannerNum.nextInt()) {
                case 1 -> {
                    System.out.println("Введите название продукта: ");
                    String name = scannerLn.nextLine();

                    System.out.println("Введите рейтинг продукта: ");
                    double rating = scannerNum.nextDouble();

                    System.out.println("Введите цену продукта: ");
                    int price = scannerNum.nextInt();

                    System.out.println(productService.addProduct(new Product(name, rating, price)));
                }
                case 2 -> {
                    System.out.println("Введите ID продукта: ");
                    System.out.println(productService.getProductById(scannerNum.nextLong()));
                }
                case 3 -> {
                    System.out.println("Введите ID продукта которого хотите обновить: ");
                    Long productId = scannerNum.nextLong();

                    System.out.println("Введите новое название продукта: ");
                    String name = scannerLn.nextLine();

                    System.out.println("Введите новый рейтинг продукта: ");
                    double rating = scannerLn.nextDouble();

                    System.out.println("Введите новую цену продукта: ");
                    int price = scannerNum.nextInt();

                    System.out.println(productService.updateProduct(productId, new Product(name, rating, price)));
                }
                case 4 -> {
                    System.out.println("Введите ID продукта которого хотите удалить: ");

                    System.out.println(productService.deleteProduct(scannerNum.nextLong()));
                }
                case 5 -> {
                    System.out.println(productService.getLowRatingProducts());
                }
                case 6 -> {
                    System.out.println("Введите минимальную цену: ");
                    int minPrice = scannerNum.nextInt();

                    System.out.println("Введите максимальную цену: ");
                    int maxPrice = scannerNum.nextInt();

                    System.out.println(productService.getProductsWithPriceRange(minPrice, maxPrice));
                }
            }

        }
    }
}
