package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_gen")
    @SequenceGenerator(
            name = "product_gen",
            sequenceName = "product_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private double rating;
    private int price;

    public Product(String name, double rating, int price) {
        this.name = name;
        this.rating = rating;
        this.price = price;
    }
}
