package org.example.service.serviceImpl;

import org.example.entity.Product;
import org.example.repository.ProductRepository;
import org.example.repository.repositoryImpl.ProductRepositoryImpl;
import org.example.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public String addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.getProductById(productId);
    }

    @Override
    public String updateProduct(Long productId, Product newProduct) {
        return productRepository.updateProduct(productId, newProduct);
    }

    @Override
    public String deleteProduct(Long productId) {
        return productRepository.deleteProduct(productId);
    }

    @Override
    public List<Product> getLowRatingProducts() {
        return productRepository.getLowRatingProducts();
    }

    @Override
    public List<Product> getProductsWithPriceRange(int min_price, int max_price) {
        return productRepository.getProductsWithPriceRange(min_price, max_price);
    }
}
