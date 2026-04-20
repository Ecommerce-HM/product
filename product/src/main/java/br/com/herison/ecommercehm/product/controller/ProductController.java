package br.com.herison.ecommercehm.product.controller;

import br.com.herison.ecommercehm.product.model.Product;
import br.com.herison.ecommercehm.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<Product> salvar(@RequestBody Product product) {
        service.save(product);
        return ResponseEntity.ok(product);
    }

    @GetMapping("{code}")
    public ResponseEntity<Product> getData(@PathVariable("code") Long code) {
        return service
                .getByCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{code}")
    public ResponseEntity<Void> delete(@PathVariable("code") Long code) {
        var product = service.getByCode(code)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "non-existent product"
                ));

        service.delete(product);
        return ResponseEntity.noContent().build();
    }

}
