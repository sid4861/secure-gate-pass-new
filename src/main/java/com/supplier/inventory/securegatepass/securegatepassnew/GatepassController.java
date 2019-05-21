package com.supplier.inventory.securegatepass.securegatepassnew;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.LocalDateTime;
import java.util.HashMap;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.supplier.inventory.securegatepass.securegatepassnew.models.Gatepass;
import com.supplier.inventory.securegatepass.securegatepassnew.repositories.GatepassRepository;
import com.supplier.inventory.securegatepass.securegatepassnew.sms.OtpGeneration;

@RestController
@RequestMapping("/secure-gate-pass/supplier")
public class GatepassController {

	@Autowired
	private GatepassRepository repository;
	

	
	@PostMapping("/generate-gatepass")
	public Gatepass saveGatepass(@Valid @RequestBody Gatepass gatePass) throws NoSuchAlgorithmException, NoSuchProviderException {

		gatePass.setGatepassCreationTime(LocalDateTime.now());
		gatePass.set_id(ObjectId.get());
		
		w:
		while(true) {
			Long otp = OtpGeneration.generateOtp();
			Gatepass g = repository.findByOtpQuery(otp);
		if(g==null) {
		gatePass.setOtp(otp);
		repository.save(gatePass);
		return gatePass;
		}
		
		else
			continue w;
		
		}
		/*
		 code to send OTP to customer's phone number
		 */
		
			
		
	}
	
	@PostMapping("/generate-gatepass/hardcoded")
	public Gatepass saveGatepassHardcoded() {

		HashMap<String, String> productHashMap = new HashMap<>();
		productHashMap.put("productName", "ada");
		productHashMap.put("productPrice", "500");
		productHashMap.put("productQuantity", "1000");
		Gatepass gatepass = new Gatepass("supp_name", "supp_add", "12345", "inv_name", "inv_add", "inv_ph", "cust_name", "cust_add", "cust_ph",LocalDateTime.now(), null, productHashMap, "active", 456789 );
		gatepass.set_id(ObjectId.get());
		repository.save(gatepass);
		
		/*
		 code to send OTP to customer's phone number
		 */
		return gatepass;
	}
}
