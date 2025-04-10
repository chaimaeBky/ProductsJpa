package net.elbakay.university.web;

import net.elbakay.university.entities.Product;
import net.elbakay.university.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // format json
public class ProductRestService {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/products") // l'url a acceder dans le web
    public List<Product> products(){
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public Product findproduct(@PathVariable Long id){
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }
}
