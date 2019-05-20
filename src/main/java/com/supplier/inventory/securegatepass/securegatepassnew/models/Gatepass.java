package com.supplier.inventory.securegatepass.securegatepassnew.models;

import java.util.ArrayList;
import java.util.HashMap;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="class to store gatepass details")
public class Gatepass {


	@Id
	private ObjectId _id;
	
	private String supplierName;
	private String supplierAddress;
	private String supplierPhonenumber;
	
	private String inventoryName;
	private String inventoryAddress;
	private String inventoryPhonenumber;
	
	private String customerName;
	private String customerAddress;
	private String customerPhonenumber;
	
	private HashMap<String, String> products;
	
	public Gatepass() {
		
	}

	public Gatepass(String supplierName, String supplierAddress, String supplierPhonenumber, String inventoryName,
			String inventoryAddress, String inventoryPhonenumber, String customerName, String customerAddress,
			String customerPhonenumber, HashMap<String, String> products) {
		super();
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.supplierPhonenumber = supplierPhonenumber;
		this.inventoryName = inventoryName;
		this.inventoryAddress = inventoryAddress;
		this.inventoryPhonenumber = inventoryPhonenumber;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhonenumber = customerPhonenumber;
		this.products = products;
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

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public String getInventoryAddress() {
		return inventoryAddress;
	}

	public void setInventoryAddress(String inventoryAddress) {
		this.inventoryAddress = inventoryAddress;
	}

	public String getInventoryPhonenumber() {
		return inventoryPhonenumber;
	}

	public void setInventoryPhonenumber(String inventoryPhonenumber) {
		this.inventoryPhonenumber = inventoryPhonenumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhonenumber() {
		return customerPhonenumber;
	}

	public void setCustomerPhonenumber(String customerPhonenumber) {
		this.customerPhonenumber = customerPhonenumber;
	}

	public HashMap<String, String> getProducts() {
		return products;
	}

	public void setProducts(HashMap<String, String> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Gatepass [supplierName=" + supplierName + ", supplierAddress=" + supplierAddress
				+ ", supplierPhonenumber=" + supplierPhonenumber + ", inventoryName=" + inventoryName
				+ ", inventoryAddress=" + inventoryAddress + ", inventoryPhonenumber=" + inventoryPhonenumber
				+ ", customerName=" + customerName + ", customerAddress=" + customerAddress + ", customerPhonenumber="
				+ customerPhonenumber + ", products=" + products + "]";
	}

	
	
	
	
	
	
}