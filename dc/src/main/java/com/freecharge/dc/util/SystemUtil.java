package com.freecharge.dc.util;

import java.util.Random;

public class SystemUtil {
	
	public static int generateOTP() {
		Random rand  = new Random();
		return rand.nextInt((9999-100)+1)+10;
	}
	
}
