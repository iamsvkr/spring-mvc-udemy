package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.Product;
import com.example.demo.services.ProductService;

@Controller
public class ProductController {

	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/products")
	public String listProducts(Model model) {
		model.addAttribute("products",	productService.listAllProducts());
		return "products";
	}
	
	@RequestMapping("/product/{id}")
    public String getProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }
	
	@RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product){
        Product savedProduct = productService.saveOrUpdateProduct(product);
        return "redirect:/product/" + savedProduct.getId();
    }
}
