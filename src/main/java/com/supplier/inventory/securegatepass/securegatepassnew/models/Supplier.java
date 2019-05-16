package com.supplier.inventory.securegatepass.securegatepassnew.models;

public class Supplier {

	private String supplirId;
	private String firmName;
	private long phoneNumber;
	private String address;
	private String email;
	private String password;

	public Supplier() {
		super();
	}
	public Supplier(String supplirId, String firmName, long phoneNumber, String address, String email,
			String password) {
		super();
		this.supplirId = supplirId;
		this.firmName = firmName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	public String getSupplirId() {
		return supplirId;
	}
	public void setSupplirId(String supplirId) {
		this.supplirId = supplirId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Supplier [supplirId=" + supplirId + ", firmName=" + firmName + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", email=" + email + ", password=" + password + "]";
	}





}
