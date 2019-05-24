package com.supplier.inventory.securegatepass.securegatepassnew.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.supplier.inventory.securegatepass.securegatepassnew.models.Supplier;

public interface SupplierRepository extends MongoRepository<Supplier, String> {

	@Query("{supplierEmail : ?0, supplierPhonenumber : ?1}")
	public Supplier findByEmailAndPhoneNumber(String supplierEmail, String supplierPhonenumber);

	@Query("{supplierAuthCode : ?0}")
	public Supplier findByAuthCode(long supplierAuthCode);

}
