package com.openclassrooms.shop.domain;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

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
        //implement the method
    	CartLine cartL = new CartLine(product, quantity);
    	
    	CartLine cartP = getCartLineList().stream() //convert to stream
				.filter(x -> product.equals(x.getProduct())) //filter out product
				.findFirst().orElse(null); //get the product
    	
    	//adds a product in the cart if empty
    	if (cartP == null) { 
    		
    		cart.add(cartL);
    	//increase the quantity of added product
    	} else {
    		
    		//increase quantity
    		int q = cartP.getQuantity();
    		cartP.setQuantity(q + quantity);
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
        //implement the method
    	
    	//loop through cart
    	//get price get quantity
    	
    	double value = 0.0;
    	
    	for (int i = 0; i < cart.size(); i++) {
    		
    		//loop: cart -> cartLine -> total

    		value = cart.get(i).getSubtotal(); //PROBLEM: getSubtotal() does not have any value
    	}
    	
        return value; //this is returning 0.0
    }

    /**
     * @return Get average value of a cart
     */
    public double getAverageValue() {
        // TODO implement the method
    	
        return 0.0;
    }

    /**
     * @param productId the getProductById id to search for
     * @return getProductById in the cart if it finds it
     */
    public Product findProductInCartLines(Long productId) {
    	
        // TODO implement the method
    	//if cart contains cartL
    	//return product
    	//else do nothing
    	
    	    	
    	return null;
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
