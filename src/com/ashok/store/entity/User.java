package com.ashok.store.entity;

import java.util.Date;

public class User {
	private String userId;
	private String userName;
	private boolean affiliatedUser;
	private boolean storeEmployee;
	private Date registrationDate;
	
	
	
	public User(String userId, String userName, boolean affiliatedUser, boolean storeEmployee, Date registrationDate) {		
		this.userId = userId;
		this.userName = userName;
		this.affiliatedUser = affiliatedUser;
		this.storeEmployee = storeEmployee;
		this.registrationDate = registrationDate;
	}



	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}



	/**
	 * @return the affiliatedUser
	 */
	public boolean isAffiliatedUser() {
		return affiliatedUser;
	}



	/**
	 * @return the storeEmployee
	 */
	public boolean isStoreEmployee() {
		return storeEmployee;
	}



	/**
	 * @return the registrationDate
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}	
		

}
