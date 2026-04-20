package br.com.herison.ecommercehm.product.repository;

import br.com.herison.ecommercehm.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
