package com.supplier.inventory.securegatepass.securegatepassnew;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
public class GatepassController {

	@Autowired
	private GatepassRepository gatepassRepository;


	@Autowired
	private SupplierRepository supplierRepository;

	@PostMapping("/generate-gatepass")
	public Gatepass saveGatepass(@Valid @RequestBody Gatepass gatePass) throws NoSuchAlgorithmException, NoSuchProviderException {

		Supplier supplier = supplierRepository.findByAuthCode(gatePass.getSupplierAuthCode());
		if(supplier != null) {

			w:
				while(true) {
					Long otp = OtpGeneration.generateOtp();
					Gatepass g = gatepassRepository.findByOtpQuery(otp);
					if(g==null) {
						gatePass.setOtp(otp);
						gatePass.setGatepassCreationTime(LocalDateTime.now());
						gatePass.set_id(ObjectId.get());
						gatePass.setStatus("active");
						gatePass.setSupplierName(supplier.getSupplierName());
						gatePass.setSupplierAddress(supplier.getSupplierAddress());
						gatePass.setSupplierPhonenumber(supplier.getSupplierPhonenumber());
						gatePass.setSupplierEmail(supplier.getSupplierEmail());
						gatePass.setSupplierAuthCode(supplier.getSupplierAuthCode());
						gatepassRepository.save(gatePass);
						Message message = Message
								.creator(new PhoneNumber("+91"+gatePass.getCustomerPhonenumber()), // to
										new PhoneNumber("+12622610149"), // from
										"Supplier:"+gatePass.getSupplierName()+"\n"+"OTP:"+Long.toString(gatePass.getOtp())+"products:"+gatePass.getProducts().toString())
								.create();

						System.out.println(message.getSid());
						return gatePass;
					}

					else
						continue w;

				}
		}

		else {
			return null;
		}


		/*w:
			while(true) {
				Long otp = OtpGeneration.generateOtp();
				Gatepass g = gatepassRepository.findByOtpQuery(otp);
				if(g==null) {
					Supplier supplier = supplierRepository.findByAuthCode(gatePass.getSupplierAuthCode());
					gatePass.setOtp(otp);
					gatePass.setGatepassCreationTime(LocalDateTime.now());
					gatePass.set_id(ObjectId.get());
					gatePass.setStatus("active");
					gatepassRepository.save(gatePass);
					Message message = Message
							.creator(new PhoneNumber("+91"+gatePass.getCustomerPhonenumber()), // to
									new PhoneNumber("+12622610149"), // from
									"Supplier:"+gatePass.getSupplierName()+"\n"+"OTP:"+Long.toString(gatePass.getOtp())+"products:"+gatePass.getProducts().toString())
							.create();

					System.out.println(message.getSid());
					return gatePass;
				}

				else
					continue w;

			}
		 */
	}

	@GetMapping("/retrieve-gatepasses")
	public List<Gatepass> retrieveGatepasses(@RequestParam(value="supplierAuthCode") long authCode) {

		List<Gatepass> gatePassList = new ArrayList<>();
		gatePassList = gatepassRepository.findBySupplierAuthCode(authCode);

		return gatePassList;
	}
	/*
	@PostMapping("/generate-gatepass/hardcoded")
	public Gatepass saveGatepassHardcoded() {

		HashMap<String, String> productHashMap = new HashMap<>();
		productHashMap.put("productName", "ada");
		productHashMap.put("productPrice", "500");
		productHashMap.put("productQuantity", "1000");
		Gatepass gatepass = new Gatepass("supp_name", "supp_add", "12345", "inv_name", "inv_add", "inv_ph", "cust_name", "cust_add", "cust_ph",LocalDateTime.now(), null, productHashMap, "active", 456789 );
		gatepass.set_id(ObjectId.get());
		repository.save(gatepass);


		return gatepass;
	}*/
}
