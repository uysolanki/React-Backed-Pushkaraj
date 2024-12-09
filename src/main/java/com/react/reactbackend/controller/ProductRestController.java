package com.react.reactbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.react.reactbackend.entity.Product;
import com.react.reactbackend.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1")
public class ProductRestController {

	@Autowired
	ProductService productService;

	@Operation(summary = "Saves single Product", description = "Save a new product")
	@PostMapping("/saveProduct")
	Product saveProduct(@RequestBody Product product)
	{
		return productService.saveProduct(product);
	}

	@Operation(summary = "Save multiple Products", description = "Saves a List of provided products")
	@PostMapping("/saveProducts")
	List<Product> saveProducts(@RequestBody List<Product> products)
	{
		return productService.saveProducts(products);
	}

	@Operation(summary = "Get Products", description = "Get List of all Products")
	@GetMapping("/getProducts")
	List<Product> getProducts()
	{
		return productService.getProducts();
	}
	
	@Operation(summary = "Get single Product", description = "Retrieve a product whose id is provided")
	@GetMapping("/getProduct/{id}")
	Product getProduct(@PathVariable("id") int pid)
	{
		return productService.getProduct(pid);
	}

	@Operation(summary = "delete single Product", description = "Delete a product whose id is provided")
	@DeleteMapping("/deleteProduct/{id}")
	String deleteProduct(@PathVariable("id") int pid)
	{
		 productService.deleteProduct(pid);
		 return "Product Deleted";
	}

	@Operation(summary = "Update the single Product", description = "Update a product whose id is provided")
	@PutMapping("/updateProduct/{id}")
	Product updateProduct(@PathVariable("id") int pid, @RequestBody Product newProduct)
	{
		return productService.updateProduct(pid, newProduct);
	}
	
}
