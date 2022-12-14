package sk.itlearning.java3.java3a.b.memory;

import java.util.Date;

public class StringBuffer {

	public static void main(String[] args) {
				
		// fullname lebo conflict s nazvom triedy
		java.lang.StringBuffer kniha1 = new java.lang.StringBuffer();
		
		//radsej StringBuffer, lebo je Thread safe
		
		// StringBuilder kniha2 = new StringBuilder();//SBuilder to iste ako SBuffer ale je string-safe(thread-safe) takze v praxi pouzivame SBuld miesto S Buf
		
		Date d = new Date();
		
		for (int i = 0; i < 100_000; i++) {
			kniha1.append(String.valueOf(i));
		}
		
		Date stop = new Date();
		
		System.out.println(stop.getTime() - d.getTime());
		
		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
		
	}

}
