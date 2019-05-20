package com.supplier.inventory.securegatepass.securegatepassnew.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.supplier.inventory.securegatepass.securegatepassnew.models.Gatepass;

public interface GatepassRepository extends MongoRepository<Gatepass, String> {

	
}