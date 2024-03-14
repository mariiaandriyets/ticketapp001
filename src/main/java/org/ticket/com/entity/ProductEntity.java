package org.ticket.com.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // auto increment
    private long id;

    @NotBlank(message =  "Product name cannot be empty")
    private String name;

    private String description;

    private double price;

    private String category;

    private String image;

    public ProductEntity(String name, String description, double price, String category, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
    }
}
