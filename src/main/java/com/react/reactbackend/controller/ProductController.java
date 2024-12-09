package com.react.reactbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.react.reactbackend.entity.Product;
import com.react.reactbackend.service.ProductService;


@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	

	@GetMapping("/")
	public String home(Model model)
	{
		List<Product> allProducts = productService.getProducts();
		model.addAttribute("products", allProducts);
		return "index";
	}
	
	@RequestMapping("/deleteProductFE/{id}")
	String deleteProduct(@PathVariable("id") int pid)
	{
		 productService.deleteProduct(pid);
		 return "redirect:/";
	}
	
	@RequestMapping("/updateProducForm/{id}")
	String updateProductForm(@PathVariable("id") int pid, Model model)
	{
		Product product = productService.getProduct(pid);
		model.addAttribute("product", product);
		return "update-product-form";
	}
	
	@PostMapping("/updateProductFE/{id}")
	String updateProduct(@PathVariable("id") int pid, @ModelAttribute Product newProduct)
	{
		productService.updateProduct(pid, newProduct);
		return "redirect:/";
	}
	
	@RequestMapping("/newProduct")
	public String newProduct(Model model)
	{
		Product product= new Product();
		model.addAttribute("product", product);
		return "add-new-product-form";
	}
	
	@PostMapping("/saveProduct")
	String saveProduct(@ModelAttribute Product product)
	{
		productService.saveProduct(product);
		return "redirect:/";
	}
}
