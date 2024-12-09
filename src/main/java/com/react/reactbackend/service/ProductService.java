package com.react.reactbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.react.reactbackend.entity.Product;
import com.react.reactbackend.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public Product saveProduct(Product product) {
		return productRepository.save(product);
		
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product getProduct(int pid) {
		return productRepository.findById(pid).get();
	}

	public List<Product> saveProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}

	public void deleteProduct(int pid) {
		productRepository.deleteById(pid);
		
	}

	public Product updateProduct(int pid, Product newProduct) throws RuntimeException {
		Optional<Product> product= productRepository.findById(pid);
		if(product.isPresent())
		{
			Product productDB=product.get();
			productDB.setCategory(newProduct.getCategory());
			productDB.setDescription(newProduct.getDescription());
			productDB.setImage(newProduct.getImage());
			productDB.setPrice(newProduct.getPrice());
			productDB.setTitle(newProduct.getTitle());
			
			return productRepository.save(productDB);
		}
		
		else
		{
			throw new RuntimeException("Product Not Found");
		}
	}

}
