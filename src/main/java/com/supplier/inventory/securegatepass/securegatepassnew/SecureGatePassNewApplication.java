package com.supplier.inventory.securegatepass.securegatepassnew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class SecureGatePassNewApplication {

	public static final String ACCOUNT_SID =
			"AC8ed198a14c64a0bf02a2b215de4d3b91";
	public static final String AUTH_TOKEN =
			"2792c50a58225a98dc158a7b9055af78";

	public static void main(String[] args) {

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		SpringApplication.run(SecureGatePassNewApplication.class, args);
	}

}
