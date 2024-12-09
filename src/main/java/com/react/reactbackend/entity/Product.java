package com.react.reactbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String title;
	double price;
	@Column(length = 1000)
	String description;
	String category;
	String image;
}

//"id": 1,
//"title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
//"price": 109.95,
//"description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
//"category": "men's clothing",
//"image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",