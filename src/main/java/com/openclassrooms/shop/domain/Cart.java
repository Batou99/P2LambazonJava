package com.openclassrooms.shop.domain;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

public class Cart {
	
	private Product product;
    private int quantity;
    private List<Cart> cart = new ArrayList<>(); 
    
	CartLine cartL = new CartLine(product, quantity);

    /**
     *
     * @return the actual cartline list
     */
    public List<CartLine> getCartLineList() {
    	
        return getCartLineList();
    }

    /**
     * Adds a getProductById in the cart or increment its quantity in the cart if already added
     * @param product getProductById to be added
     * @param quantity the quantity
     */
    public void addItem(Product product, int quantity) {
        // TODO implement the method
    	
    	//if product not in cart, then add
    	//else if product in cart, then quantity+
    	if (cart.isEmpty() == true) { 
    		quantity = product.getStock();
    	} else {
    		quantity++;
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
    	
        return cartL.getSubtotal();
    }

    /**
     * @return Get average value of a cart
     */
    public double getAverageValue() {
        //implement the method
    	
        return cartL.getSubtotal() / cartL.getQuantity();
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
