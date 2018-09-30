package com.ashok.store;

public class Item {
	private String itemId;
	private String itemName;
	private float price;
	private boolean grocery;
	
	
	public Item(String itemId, String itemName, float price, boolean grocery) {		
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.grocery = grocery;
	}


	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}


	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}


	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}


	/**
	 * @return the grocery
	 */
	public boolean isGrocery() {
		return grocery;
	}
	

}
