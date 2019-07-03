package com.openclassrooms.shop.domain;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

public class Cart {
	
	private List<CartLine> cart;
    Product product;
	
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
    	
    	//adds a product in the cart
    	if (cart.isEmpty()) { 
    		
    		cart.add(cartL);    		
    		
    	//increase the quantity of added product
    	} else {
    		CartLine cartP = getCartLineList().stream() //convert to stream
    				.filter(x -> product.equals(x.getProduct())) //filter out product
    				.findFirst().get(); //get the product
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
    	
        return 0.0;
    }

    /**
     * @return Get average value of a cart
     */
    public double getAverageValue() {
        //implement the method
    	
        return 0.0;
    }

    /**
     * @param productId the getProductById id to search for
     * @return getProductById in the cart if it finds it
     */
    public Product findProductInCartLines(Long productId) {
    	
        // TODO implement the method
    	//if productId > 0 then return product
    	
    	    	
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
