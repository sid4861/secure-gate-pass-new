package com.supplier.inventory.securegatepass.securegatepassnew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supplier.inventory.securegatepass.securegatepassnew.models.Gatepass;
import com.supplier.inventory.securegatepass.securegatepassnew.repositories.GatepassRepository;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping("/secure-gate-pass/inventory")
public class InventoryController {

	@Autowired
	private GatepassRepository repository;

	@GetMapping("/validate-gatepass")
	public String validateGatepass(@RequestParam(value="otp") long otp) {

		Gatepass g = repository.findByOtpQuery(otp);

		if(g!=null) {
			if(g.getStatus()=="active") {
				g.setStatus("validated");
				Message message = Message
						.creator(new PhoneNumber("+91"+g.getCustomerPhonenumber()), // to
								new PhoneNumber("+12622610149"), // from
								Long.toString(otp)+" : is validated")
						.create();
				System.out.println(message.getSid());
				return String.format("otp is validated"+"\n"+"Supplier name : "+g.getSupplierName()+"\nCustomer name : "+g.getCustomerName()+"\nProducts : "+g.getProducts().toString());

			}
		}

		return "OTP has expired or does not exist";
	}
}
