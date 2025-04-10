package net.elbakay.university;

import net.elbakay.university.entities.Product;
import net.elbakay.university.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {
// dans une app , le premier qui vas demarrer c spring
    @Autowired //pour demander a spring d injecter dans cet objet un objet de type productRepository
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Computer", 5000.0,3));
        productRepository.save(new Product(null,"Printer", 1000.0,10));
        productRepository.save(new Product(null,"Smart Phone", 8000.0,5));
        List<Product> products = productRepository.findAll();
        products.forEach(product -> {
            System.out.println(product.toString());
        });

        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("----------");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("----------");
        System.out.println("**********");

        List<Product> productList = productRepository.findByNameContains("C");
        productList.forEach(product1 -> {
            System.out.println(product1);
        });
        System.out.println("**********");
        List<Product> productList2 = productRepository.search("%C%");
        productList2.forEach(product1 -> {
            System.out.println(product1);
        });
        System.out.println("**********");
        List<Product> productList3 = productRepository.findByPriceGreaterThan(3000);
        productList2.forEach(product1 -> {
            System.out.println(product1);
        });
        System.out.println("**********");
        List<Product> productList4 = productRepository.searchByPrice(3000);
        productList2.forEach(product1 -> {
            System.out.println(product1);
        });


    }
}
