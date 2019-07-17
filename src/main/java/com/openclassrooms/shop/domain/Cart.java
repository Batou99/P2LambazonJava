package com.openclassrooms.shop.domain;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cart {
	
	private List<CartLine> cart;
	
	public Cart() {
		this.cart = new ArrayList<>();
	}

    /**
     *
     * @return the actual cartline list
     */
    public List<CartLine> getCartLineList() {
    	
        return cart;
    }

    /**
     * Adds a getProductById in the cart or increment its quantity in the cart if already added
     * @param product getProductById to be added
     * @param quantity the quantity
     */
    public void addItem(Product product, int quantity) {
    	
    	CartLine cartLine = new CartLine(product, quantity);
    	
    	//filters and gets a product
    	CartLine cartProduct = cart.stream() //convert to stream
				.filter(x -> product.equals(x.getProduct())) //filter out product
				.findFirst().orElse(null); //get the product
    	
    	//adds a product in the cart if empty
    	if (cartProduct == null) { 
    		
    		cart.add(cartLine);
    	//increase the quantity of added product
    	} else {
    		
    		//increase quantity
    		int q = cartProduct.getQuantity();
    		cartProduct.setQuantity(q + quantity);
    	}
    	
    }

    /**
     * Removes a getProductById form the cart
     * @param product the getProductById to be removed
     */
    public void removeLine(Product product) {
        getCartLineList().removeIf(l -> l.getProduct().getId().equals(product.getId()));
    }


    /**
     * @return total value of a cart
     */
    public double getTotalValue() {
    	
    	double totalValue = 0.0;
    	
    	//loop through cart
    	for (int i = 0; i < cart.size(); i++) {
    		
    		totalValue += cart.get(i).getSubtotal(); //increase totalValue 
    	}
    	
        return totalValue;
    }

    /**
     * @return Get average value of a cart
     */
    public double getAverageValue() {
    	
    	int totalQuantity = 0;
    		
    		//loop through cart
    		for (int j = 0; j < cart.size(); j++) {  			
    			
    			totalQuantity += cart.get(j).getQuantity(); //increases quantity
    		}
    	
        return getTotalValue() / totalQuantity; //returns the average value
    }

    /**
     * @param productId the getProductById id to search for
     * @return getProductById in the cart if it finds it
     */
    
    public Product findProductInCartLines(Long productId) {
    	
    	//loop through cart
    	for (int x = 0; x < cart.size(); x++) { 
    		
    		long id = cart.get(x).getProduct().getId();
    		
    		if (productId == id) {
    			
    			return cart.get(x).getProduct(); //returns a product
    		}
    	}
    	return null; //otherwise, returns nothing
    }

    /**
     *
     * @param index index of the cartLine
     * @return CartLine in that index
     */
    public CartLine getCartLineByIndex(int index)
    {
        return getCartLineList().get(index);
    }

    /**
     * Clears a the cart of all added products
     */
    public void clear()
    {
        List<CartLine> cartLines = getCartLineList();
        cartLines.clear();
    }
}
