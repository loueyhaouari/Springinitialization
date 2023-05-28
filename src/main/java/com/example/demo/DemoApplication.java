package com.example.demo;

import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
@Autowired
private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
productRepository.save(new Product(null,"Computer",4300,3));
		productRepository.save(new Product(null,"Printer",1200,4));
		productRepository.save(new Product(null,"SmartPhone",3200,32));
		List<Product> products=productRepository.findAll();
		products.forEach(product -> {
			System.out.println(product.toString());
		});
	Product product=productRepository.findById(1L).get();
	System.out.println("-------------------------");
	System.out.println(product.toString());
	System.out.println("****************");
	List<Product> prods=productRepository.findByNameContains("c");
prods.forEach(p->{ System.out.println(p.toString());});
	System.out.println("+++++++++++++++++++++++++");
		List<Product> prods1=productRepository.search("%c%");
		prods.forEach(p->{ System.out.println(p.toString());});
		System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		List<Product> prods2=productRepository.findByPriceGreaterThan(3000);
		prods.forEach(p->{ System.out.println(p.toString());});
		System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrr");
		List<Product> prods3=productRepository.searchByPrice(3000);
		prods.forEach(p->{ System.out.println(p.toString());});

	}

}
