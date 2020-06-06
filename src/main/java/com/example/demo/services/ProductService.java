package com.example.demo.services;

import java.util.List;
import com.example.demo.domain.Product;

public interface ProductService {
	List<Product> listAllProducts();
	Product getProductById(Integer id);
	Product saveOrUpdateProduct(Product product);
}
