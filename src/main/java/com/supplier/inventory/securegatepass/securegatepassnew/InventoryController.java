package com.supplier.inventory.securegatepass.securegatepassnew;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.supplier.inventory.securegatepass.securegatepassnew.models.Gatepass;
import com.supplier.inventory.securegatepass.securegatepassnew.repositories.GatepassRepository;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@CrossOrigin
@RestController
@RequestMapping("/secure-gate-pass/inventory")
public class InventoryController {

	@Autowired
	private GatepassRepository gatepassRepository;


	@GetMapping("/validate-gatepass")

	public String validateGatepass(@RequestParam Map<String,String> allParams) {

		String Response;

		Gatepass gatepass = gatepassRepository.findByOtpQuery(Long.valueOf(allParams.get("otp")));
		System.out.println(gatepass.getStatus());
		if(gatepass.getStatus().equals("active")) {
			Message message = Message
					.creator(new PhoneNumber("+91"+gatepass.getCustomerPhonenumber()), // to
							new PhoneNumber("+12622610149"), // from
							"OTP : "+Long.toString(gatepass.getOtp())+" is validated")
					.create();

			
			System.out.println(message.getSid());
			
			Message message2 = Message
					.creator(new PhoneNumber("+91"+gatepass.getSupplierPhonenumber()), // to
							new PhoneNumber("+12622610149"), // from
							"OTP : "+Long.toString(gatepass.getOtp())+" is validated")
					.create();

			
			System.out.println(message2.getSid());
			gatepass.setStatus("validated");
			gatepassRepository.save(gatepass);
			Response = String.format("Supplier : %s\nCustomer : %s \n Products : %s", gatepass.getSupplierName(), gatepass.getCustomerName(), gatepass.getProducts());
			return Response;

		}

		else if(gatepass.getStatus().equals("validated")) {
			Response = "This OTP is already validated";
			return Response;
		}

		else {
			Response = "OTP is either invalid or has expired";
			return Response;
		}
	}
}

