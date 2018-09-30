package com.ashok.store;

import java.util.List;

public class BillDetails {

	private String billId;
	private String billDate;
	private String customerName;
	private String customerType;
	private int totalNumberOfItems;
	private int discountOnTotal = 0;
	private String discountType;

	private float discountOnNonGroceryItems = 0;

	private float total = 0f;
	private float netAmount = 0f;
	private float nonGroceriesTotal = 0f;
	private float groceriesTotal = 0f;

	private List<Item> nonGroceryItemsList;
	private List<Item> groceryItemsList;

	/**
	 * @return the billId
	 */
	public String getBillId() {
		return billId;
	}

	/**
	 * @param billId
	 *            the billId to set
	 */
	public void setBillId(String billId) {
		this.billId = billId;
	}

	/**
	 * @return the billDate
	 */
	public String getBillDate() {
		return billDate;
	}

	/**
	 * @param billDate
	 *            the billDate to set
	 */
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerType
	 */
	public String getCustomerType() {
		return customerType;
	}

	/**
	 * @param customerType
	 *            the customerType to set
	 */
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	/**
	 * @return the totalNumberOfItems
	 */
	public int getTotalNumberOfItems() {
		return totalNumberOfItems;
	}

	/**
	 * @param totalNumberOfItems
	 *            the totalNumberOfItems to set
	 */
	public void setTotalNumberOfItems(int totalNumberOfItems) {
		this.totalNumberOfItems = totalNumberOfItems;
	}

	/**
	 * @return the discountOnTotal
	 */
	public int getDiscountOnTotal() {
		return discountOnTotal;
	}

	/**
	 * @param discountOnTotal
	 *            the discountOnTotal to set
	 */
	public void setDiscountOnTotal(int discountOnTotal) {
		this.discountOnTotal = discountOnTotal;
	}

	/**
	 * @return the discountType
	 */
	public String getDiscountType() {
		return discountType;
	}

	/**
	 * @param discountType
	 *            the discountType to set
	 */
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	/**
	 * @return the discountOnNonGroceryItems
	 */
	public float getDiscountOnNonGroceryItems() {
		return discountOnNonGroceryItems;
	}

	/**
	 * @param discountOnNonGroceryItems
	 *            the discountOnNonGroceryItems to set
	 */
	public void setDiscountOnNonGroceryItems(float discountOnNonGroceryItems) {
		this.discountOnNonGroceryItems = discountOnNonGroceryItems;
	}

	/**
	 * @return the total
	 */
	public float getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(float total) {
		this.total = total;
	}

	/**
	 * @return the netAmount
	 */
	public float getNetAmount() {
		return netAmount;
	}

	/**
	 * @param netAmount
	 *            the netAmount to set
	 */
	public void setNetAmount(float netAmount) {
		this.netAmount = netAmount;
	}

	/**
	 * @return the nonGroceriesTotal
	 */
	public float getNonGroceriesTotal() {
		return nonGroceriesTotal;
	}

	/**
	 * @param nonGroceriesTotal
	 *            the nonGroceriesTotal to set
	 */
	public void setNonGroceriesTotal(float nonGroceriesTotal) {
		this.nonGroceriesTotal = nonGroceriesTotal;
	}

	/**
	 * @return the groceriesTotal
	 */
	public float getGroceriesTotal() {
		return groceriesTotal;
	}

	/**
	 * @param groceriesTotal
	 *            the groceriesTotal to set
	 */
	public void setGroceriesTotal(float groceriesTotal) {
		this.groceriesTotal = groceriesTotal;
	}

	/**
	 * @return the nonGroceryItemsList
	 */
	public List<Item> getNonGroceryItemsList() {
		return nonGroceryItemsList;
	}

	/**
	 * @param nonGroceryItemsList
	 *            the nonGroceryItemsList to set
	 */
	public void setNonGroceryItemsList(List<Item> nonGroceryItemsList) {
		this.nonGroceryItemsList = nonGroceryItemsList;
	}

	/**
	 * @return the groceryItemsList
	 */
	public List<Item> getGroceryItemsList() {
		return groceryItemsList;
	}

	/**
	 * @param groceryItemsList
	 *            the groceryItemsList to set
	 */
	public void setGroceryItemsList(List<Item> groceryItemsList) {
		this.groceryItemsList = groceryItemsList;
	}

}
