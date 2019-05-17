package com.supplier.inventory.securegatepass.securegatepassnew.models;

import org.springframework.data.annotation.Id;

public class Supplier {

	private String firmName;
	private long phoneNumber;
	private String address;
	private String email;

	public Supplier() {
		super();
	}
	public Supplier(String supplierId, String firmName, long phoneNumber, String address, String email,
			String password) {
		super();
		
		this.firmName = firmName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		
	}

	
	public String getFirmName() {
		return firmName;
	}
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Supplier [firmName=" + firmName + ", phoneNumber=" + phoneNumber + ", address=" + address + ", email="
				+ email + "]";
	}







}
