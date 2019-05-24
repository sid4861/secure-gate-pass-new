package com.supplier.inventory.securegatepass.securegatepassnew.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Supplier {

	@Id
	private ObjectId _id;

	private String supplierName;
	private String supplierAddress;
	private String supplierPhonenumber;
	private String supplierEmail;
	private long supplierAuthCode;


	public Supplier() {
		super();
	}



	public Supplier(String supplierName, String supplierAddress, String supplierPhonenumber, String supplierEmail,
			long supplierAuthCode) {
		super();
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.supplierPhonenumber = supplierPhonenumber;
		this.supplierEmail = supplierEmail;
		this.supplierAuthCode = supplierAuthCode;
	}



	public String get_id() {
		return _id.toHexString();
	}


	public void set_id(ObjectId _id) {
		this._id = _id;
	}


	public String getSupplierName() {
		return supplierName;
	}


	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}


	public String getSupplierAddress() {
		return supplierAddress;
	}


	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}


	public String getSupplierPhonenumber() {
		return supplierPhonenumber;
	}


	public void setSupplierPhonenumber(String supplierPhonenumber) {
		this.supplierPhonenumber = supplierPhonenumber;
	}


	public String getSupplierEmail() {
		return supplierEmail;
	}


	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}


	public long getSupplierAuthCode() {
		return supplierAuthCode;
	}


	public void setSupplierAuthCode(long supplierAuthCode) {
		this.supplierAuthCode = supplierAuthCode;
	}



	@Override
	public String toString() {
		return "Supplier [supplierName=" + supplierName + ", supplierAddress=" + supplierAddress
				+ ", supplierPhonenumber=" + supplierPhonenumber + ", supplierEmail=" + supplierEmail
				+ ", supplierAuthCode=" + supplierAuthCode + "]";
	}



}
