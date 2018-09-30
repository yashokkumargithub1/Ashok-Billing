package com.ashok.store.utils;

import com.ashok.store.BillDetails;
import com.ashok.store.Item;
import com.ashok.store.entity.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BillingMachine {
	
	private static BillDetails billDetails;
	
	/**
	 * Calculate bill
	 * @param user
	 * @param itemsList
	 */
	public static void calculateBill(User user, List<Item> itemsList) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = new Date();
		billDetails = new BillDetails();
		billDetails.setBillId("BID" + new Random().nextInt(100 - 50 + 1));
		billDetails.setBillDate(formatter.format(currentDate));
		billDetails.setCustomerName(user.getUserName());
		billDetails.setTotalNumberOfItems(itemsList.size());
		List<Item> nonGroceryItemsList = new ArrayList<Item>();
		List<Item> groceryItemsList = new ArrayList<Item>();
		int discountPercentage = 0;
		int discountOnTotal = 0;
		float discountOnNonGroceryItems = 0;
		float total = 0f;
		float netAmount = 0f;
		float nonGroceriesTotal = 0f;
		float groceriesTotal = 0f;
		
		//list out grocery and non grocery items
		for (Item item : itemsList) {
			if (item.isGrocery()) {
				groceryItemsList.add(item);
				groceriesTotal += item.getPrice();
			} else {
				nonGroceryItemsList.add(item);
				nonGroceriesTotal += item.getPrice();
			}
			total = groceriesTotal + nonGroceriesTotal;
		}
		billDetails.setTotal(total);
		billDetails.setGroceryItemsList(groceryItemsList);
		billDetails.setNonGroceryItemsList(nonGroceryItemsList);
		billDetails.setGroceriesTotal(groceriesTotal);
		billDetails.setNonGroceriesTotal(nonGroceriesTotal);

		// Calculate relative discount percentage for user
		if (user.isStoreEmployee()) {
			discountPercentage = 30;
			billDetails.setDiscountType("30% Discount");
			billDetails.setCustomerType("Store Employee");
		} else if (user.isAffiliatedUser()) {
			discountPercentage = 10;
			billDetails.setDiscountType("10% Discount");
			billDetails.setCustomerType("Affiliated Customer");
		} else if (isMoreThanTwoYears(currentDate, user.getRegistrationDate())) {
			discountPercentage = 5;
			billDetails.setDiscountType("5% Discount");
			billDetails.setCustomerType("Long term Customer");
		} else {
			billDetails.setDiscountType("No Discount");
			billDetails.setCustomerType("Normal Customer");
		}

		// Calculate discount amount on non grocery items
		if (discountPercentage != 0) {
			discountOnNonGroceryItems = (nonGroceriesTotal * discountPercentage) / 100;
		}
		billDetails.setDiscountOnNonGroceryItems(discountOnNonGroceryItems);

		// Calculate discount amount on total amount
		if (total > 0) {
			discountOnTotal = ((int) total / 100) * 5;
		}
		billDetails.setDiscountOnTotal(discountOnTotal);
		
		//Calculate Net amount
		netAmount = total - discountOnNonGroceryItems - discountOnTotal;
		billDetails.setNetAmount(netAmount);
		
		//Print the bill
		printBill(billDetails);

	}
	
	/**
	 * 
	 * @param currentDate
	 * @param registrationDate
	 * @return
	 */
	private static boolean isMoreThanTwoYears(Date currentDate, Date registrationDate) {
		long diff = currentDate.getTime() - registrationDate.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);
		if (diffDays > 730) {
			return true;
		}
		return false;
	}

	/**
	 * Prints bill
	 * @param billDetails
	 */
	private static void printBill(BillDetails billDetails) {

		System.out.println("Bill Id :: " + billDetails.getBillId());
		System.out.println("Bill Date :: " + billDetails.getBillDate());
		System.out.println("Customer Name :: " + billDetails.getCustomerName());
		System.out.println("Customer Type :: " + billDetails.getCustomerType());
		System.out.println("Non Groceries discount :: " + billDetails.getDiscountType());
		System.out.println("Total items :: " + billDetails.getTotalNumberOfItems());

		System.out.println("-----------------------------------------------------------------" + "\n");

		int count = 1;
		System.out.println("Item Id" + "\t\t\t" + "Item Name" + "\t\t\t" + "Price");
		for (Item item : billDetails.getGroceryItemsList()) {
			if (count == 1)
				System.out.println("-Grocery items-");
			System.out.println(item.getItemId() + "\t\t" + item.getItemName() + "\t\t\t\t" + item.getPrice());
			count++;
		}
		if (billDetails.getGroceriesTotal() > 0) {
			System.out.println("\t\t\t\t" + "Groceries Total" + "\t" + billDetails.getGroceriesTotal());
		}

		count = 1;
		for (Item item : billDetails.getNonGroceryItemsList()) {
			if (count == 1)
				System.out.println("-Non Grocery items-");
			System.out.println(item.getItemId() + "\t\t" + item.getItemName() + "\t\t\t\t" + item.getPrice());
			count++;
		}
		if (billDetails.getNonGroceriesTotal() > 0) {
			System.out.println("\t\t\t" + "    Non Groceries Total" + " " + billDetails.getNonGroceriesTotal());
		}

		System.out.println("\t\t\t\t\t\t\t" + "----------");
		System.out.println("\t\t\t" + "Grand Total" + "\t\t\t" + billDetails.getTotal());
		System.out.println("\t" + billDetails.getDiscountType() + " on Non Grocery Items" + "\t\t"
				+ billDetails.getDiscountOnNonGroceryItems());
		System.out.println("Discoutn on Grand Total @ $5 for each $100" + "\t\t" + billDetails.getDiscountOnTotal());
		System.out.println("\t\t\t\t\t\t\t" + "-----------");
		System.out.println("\t\t\t\t\t" + "Net Payable" + "\t" + billDetails.getNetAmount());
		System.out.println("\t\t\t\t\t\t\t" + "-----------");
	}

}
