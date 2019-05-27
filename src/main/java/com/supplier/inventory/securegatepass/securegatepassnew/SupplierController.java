package com.supplier.inventory.securegatepass.securegatepassnew;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supplier.inventory.securegatepass.securegatepassnew.models.Gatepass;
import com.supplier.inventory.securegatepass.securegatepassnew.models.Supplier;
import com.supplier.inventory.securegatepass.securegatepassnew.repositories.GatepassRepository;
import com.supplier.inventory.securegatepass.securegatepassnew.repositories.SupplierRepository;
import com.supplier.inventory.securegatepass.securegatepassnew.sms.OtpGeneration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@CrossOrigin
@RestController
@RequestMapping("/secure-gate-pass/supplier")
public class SupplierController {

	@Autowired
	private SupplierRepository repository;

	@PostMapping("/register")

	public Object registerSupplier(@Valid @RequestBody Supplier supplier) throws NoSuchAlgorithmException, NoSuchProviderException {
		// this method register supplier in the database and generated a supplier auth code


		Long otp = OtpGeneration.generateOtp();
		Supplier s = repository.findByEmailAndPhoneNumber(supplier.getSupplierEmail(), supplier.getSupplierPhonenumber());
		if(s==null) {
			supplier.setSupplierAuthCode(otp);
			supplier.set_id(ObjectId.get());
			repository.save(supplier);
			/*Message message = Message
					.creator(new PhoneNumber("+91"+supplier.getSupplierPhonenumber()), // to
							new PhoneNumber("+12622610149"), // from
							"You are registered as a supplier. \n Supplier auth code : "+Long.toString(supplier.getSupplierAuthCode()))
					.create();

			System.out.println(message.getSid());
			 */
			return supplier;
		}

		else
			return "This email id/ phone number already exists";

	}

	@GetMapping("/forgot-authcode")

	public String retrieveAuthCode(@RequestParam Map<String,String> allParams) {

		Supplier supplier = repository.findByEmailAndPhoneNumber(allParams.get("Email"), allParams.get("PhoneNumber"));
		if(supplier != null) {
			/*Message message = Message
					.creator(new PhoneNumber("+91"+supplier.getSupplierPhonenumber()), // to
							new PhoneNumber("+12622610149"), // from
							"You are registered as a supplier. \n Supplier auth code : "+Long.toString(supplier.getSupplierAuthCode()))
					.create();

			System.out.println(message.getSid());*/
			return("auth code sent over sms : " +Long.toString(supplier.getSupplierAuthCode()));

		}

		else {
			return "No supplier registered with this email and mobile number";
		}
	}
}
