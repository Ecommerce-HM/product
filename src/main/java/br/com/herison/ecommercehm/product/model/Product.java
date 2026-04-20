package br.com.herison.ecommercehm.product.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "unit_value", nullable = false, precision = 16, scale = 2)
    private BigDecimal unitValue;

    @Column(name = "active")
    private boolean active;

    @PrePersist
    public void prePersist(){
        setActive(true);
    }

}
