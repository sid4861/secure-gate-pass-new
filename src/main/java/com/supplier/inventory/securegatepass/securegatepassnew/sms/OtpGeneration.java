package com.supplier.inventory.securegatepass.securegatepassnew.sms;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class OtpGeneration {

	public static long generateOtp() throws NoSuchAlgorithmException, NoSuchProviderException {
		long otp = 0L;
		
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
		
		otp = secureRandomGenerator.nextInt(999999);
		return otp;
	}
}
