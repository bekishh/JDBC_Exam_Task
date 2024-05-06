package org.example.service;

import org.example.entity.Product;

import java.util.List;

public interface ProductService {
    String addProduct(Product product);

    Product getProductById(Long productId);

    String updateProduct(Long productId, Product newProduct);

    String deleteProduct(Long productId);

    List<Product> getLowRatingProducts();

    List<Product> getProductsWithPriceRange(int min_price, int max_price);
}
