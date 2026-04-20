package br.com.herison.ecommercehm.product.service;

import br.com.herison.ecommercehm.product.model.Product;
import br.com.herison.ecommercehm.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product save(Product product){

        return repository.save(product);
    }

    public Optional<Product> getByCode(Long code){
        return repository.findById(code);
    }

    public void delete(Product product) {
        product.setActive(false);
        repository.save(product);
    }
}
