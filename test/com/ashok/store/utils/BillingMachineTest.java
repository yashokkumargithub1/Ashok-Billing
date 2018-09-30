package com.ashok.store.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ashok.store.entity.User;
import com.ashok.store.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BillingMachineTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("\n***\t\t\t***\t\t\t***");
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * This verifies Store employee scenario
	 * 
	 * @throws Exception
	 */
	@Test
	public void testStoreEmployee() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = new Date();
		User user1 = new User("UID001", "Ashok", false, true, formatter.parse(formatter.format(currentDate)));
		Item item1 = new Item("ITMID001", "item1", 300, false);
		Item item2 = new Item("ITMID002", "item2", 400, true);
		Item item3 = new Item("ITMID003", "item3", 500, false);
		Item item4 = new Item("ITMID004", "item4", 600, true);
		List<Item> itemsList = new ArrayList<Item>();
		itemsList.add(item1);
		itemsList.add(item2);
		itemsList.add(item3);
		itemsList.add(item4);
		BillingMachine.calculateBill(user1, itemsList);
	}

	/**
	 * This verifies Affiliated Customer scenario
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAffiliatedCustomer() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = new Date();
		User user1 = new User("UID001", "Kumar", true, false, formatter.parse(formatter.format(currentDate)));
		Item item1 = new Item("ITMID001", "item1", 400, false);
		Item item2 = new Item("ITMID002", "item2", 600, false);
		Item item3 = new Item("ITMID003", "item3", 700, true);
		Item item4 = new Item("ITMID004", "item4", 800, true);
		Item item5 = new Item("ITMID005", "item5", 500, false);
		Item item6 = new Item("ITMID006", "item6", 100, false);
		List<Item> itemsList = new ArrayList<Item>();
		itemsList.add(item1);
		itemsList.add(item2);
		itemsList.add(item3);
		itemsList.add(item4);
		itemsList.add(item5);
		itemsList.add(item6);
		BillingMachine.calculateBill(user1, itemsList);
	}

	/**
	 * This verifies Long term User - more than 2 years association scenario
	 * 
	 * @throws Exception
	 */
	@Test
	public void testLongTermUser() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date pastDate = formatter.parse("27/08/2016");
		User user1 = new User("UID001", "Gunvanth", false, false, pastDate);
		Item item1 = new Item("ITMID001", "item1", 400, false);
		Item item2 = new Item("ITMID002", "item2", 600, true);
		Item item3 = new Item("ITMID003", "item3", 700, false);
		Item item4 = new Item("ITMID004", "item4", 800, true);
		Item item5 = new Item("ITMID005", "item5", 500, false);
		Item item6 = new Item("ITMID006", "item6", 100, true);
		List<Item> itemsList = new ArrayList<Item>();
		itemsList.add(item1);
		itemsList.add(item2);
		itemsList.add(item3);
		itemsList.add(item4);
		itemsList.add(item5);
		itemsList.add(item6);
		BillingMachine.calculateBill(user1, itemsList);
	}
	
	
	/**
	 * This verifies non Store employee, non Affiliated customer and non Long term customer scenario
	 * 
	 * @throws Exception
	 */
	@Test
	public void testNormalUser() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date pastDate = formatter.parse("27/08/2018");
		User user1 = new User("UID001", "Gunvanth", false, false, pastDate);
		Item item1 = new Item("ITMID001", "item1", 400, false);
		Item item2 = new Item("ITMID002", "item2", 600, true);
		Item item3 = new Item("ITMID003", "item3", 700, false);
		Item item4 = new Item("ITMID004", "item4", 800, true);
		Item item5 = new Item("ITMID005", "item5", 500, false);
		Item item6 = new Item("ITMID006", "item6", 100, true);
		List<Item> itemsList = new ArrayList<Item>();
		itemsList.add(item1);
		itemsList.add(item2);
		itemsList.add(item3);
		itemsList.add(item4);
		itemsList.add(item5);
		itemsList.add(item6);
		BillingMachine.calculateBill(user1, itemsList);
	}

	/**
	 * This verifies Store Employee bought only groceries scenario
	 * 
	 * @throws Exception
	 */
	@Test
	public void testStoreEmployeeWithOnlyGroceries() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = new Date();
		User user1 = new User("UID001", "Lali", false, true, formatter.parse(formatter.format(currentDate)));
		Item item1 = new Item("ITMID001", "item1", 300, true);
		Item item2 = new Item("ITMID002", "item2", 400, true);
		Item item3 = new Item("ITMID003", "item3", 500, true);
		Item item4 = new Item("ITMID004", "item4", 600, true);
		List<Item> itemsList = new ArrayList<Item>();
		itemsList.add(item1);
		itemsList.add(item2);
		itemsList.add(item3);
		itemsList.add(item4);
		BillingMachine.calculateBill(user1, itemsList);
	}

	/**
	 * This verifies Affiliated customer bought only non grocery items scenario
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAffiliatedCustomerWithOnlyNonGroceryItems() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = new Date();
		User user1 = new User("UID001", "Prasu", true, false, formatter.parse(formatter.format(currentDate)));
		Item item1 = new Item("ITMID001", "item1", 400, false);
		Item item2 = new Item("ITMID002", "item2", 600, false);
		Item item3 = new Item("ITMID003", "item3", 700, false);
		Item item4 = new Item("ITMID004", "item4", 800, false);
		Item item5 = new Item("ITMID005", "item5", 500, false);
		Item item6 = new Item("ITMID006", "item6", 100, false);
		List<Item> itemsList = new ArrayList<Item>();
		itemsList.add(item1);
		itemsList.add(item2);
		itemsList.add(item3);
		itemsList.add(item4);
		itemsList.add(item5);
		itemsList.add(item6);
		BillingMachine.calculateBill(user1, itemsList);
	}

}
