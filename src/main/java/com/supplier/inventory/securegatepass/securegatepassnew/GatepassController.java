package com.supplier.inventory.securegatepass.securegatepassnew;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.supplier.inventory.securegatepass.securegatepassnew.models.Gatepass;
import com.supplier.inventory.securegatepass.securegatepassnew.repositories.GatepassRepository;

@RestController
@RequestMapping("/secure-gate-pass/supplier")
public class GatepassController {

	@Autowired
	private GatepassRepository repository;
	
	@PostMapping("/generate-gatepass")
	public Gatepass saveGatepass(@Valid @RequestBody Gatepass gatePass) {

		gatePass.set_id(ObjectId.get());
		repository.save(gatePass);
		return gatePass;
	}
}
