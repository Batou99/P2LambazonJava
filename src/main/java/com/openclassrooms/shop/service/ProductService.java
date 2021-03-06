package com.openclassrooms.shop.service;

import com.openclassrooms.shop.domain.Cart;
import com.openclassrooms.shop.domain.CartLine;
import com.openclassrooms.shop.repository.OrderRepository;
import com.openclassrooms.shop.domain.Product;
import com.openclassrooms.shop.repository.ProductRepository;

import org.apache.tomcat.util.descriptor.tld.TldRuleSet.Variable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

	private static final Logger log = LoggerFactory.getLogger(ProductService.class);

	private ProductRepository productRepository;
	private OrderRepository orderRepository;

	@Autowired
	public ProductService(ProductRepository repository, OrderRepository orderRepository) {
		this.productRepository = repository;
		this.orderRepository = orderRepository;
	}

	/**
	 * @return all products from the inventory
	 */
	public List<Product> getAllProducts() {

		//change the type from array to List<T>
		List<Product> listProducts = Arrays.asList(productRepository.findAll()); 
		
		return listProducts; //returns list of products
	}

	/**
	 * @param productId Id of the product
	 * @return a product from the inventory
	 */
	public Product getProductById(Long productId) {
		
		return productRepository.findOne(productId); //returns one product from the inventory
	}

	/**
	 * Update the quantities left for each product in the inventory depending of ordered the quantities
	 * @param productId ID of the product to be updated
	 */
	public void updateProductQuantities(Long productId, int quantity) {
		
		//update the product stock
		productRepository.updateProductStocks(productId.intValue(), quantity); //update the product stocks
	}
}
