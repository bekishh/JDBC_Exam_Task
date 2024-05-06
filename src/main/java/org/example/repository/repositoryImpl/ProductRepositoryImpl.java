package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.entity.Product;
import org.example.repository.ProductRepository;
import org.hibernate.HibernateException;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();

    @Override
    public String addProduct(Product product) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            return "Product added successfully";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }

    @Override
    public Product getProductById(Long productId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.find(Product.class, productId);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateProduct(Long productId, Product newProduct) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Product product = entityManager.find(Product.class, productId);
            product.setName(newProduct.getName());
            product.setRating(newProduct.getRating());
            product.setPrice(newProduct.getPrice());
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.getTransaction().commit();
            return "Product updated successfully";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteProduct(Long productId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Product product = entityManager.find(Product.class, productId);
            entityManager.getTransaction().begin();
            entityManager.remove(product);
            entityManager.getTransaction().commit();
            return "Product deleted successfully";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Product> getLowRatingProducts() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery("select p from Product p order by rating desc", Product.class).getResultList();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Product> getProductsWithPriceRange(int min_price, int max_price) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery("select p from Product p where price between :min_price and :max_price", Product.class)
                    .setParameter("min_price", min_price)
                    .setParameter("max_price", max_price)
                    .getResultList();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
