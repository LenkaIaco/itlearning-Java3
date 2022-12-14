package sk.itlearning.java3.java3a.h.threads;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FlowBlocked {

	public static void main(String[] args) throws IOException {

		Date start = new Date();

		MutableLong p1 = new MutableLong();
		new SpocitajSubory().spocitajSubory(new File("C:\\Windows\\System32\\drivers"), p1);
		Date stop = new Date();
		double seconds = (stop.getTime() - start.getTime()) / 1000.0;
		System.out.println("Pocet suborov: " + p1.value + " vyhladane za (sekund): " + seconds);

		
		MutableLong p2 = new MutableLong();
		new SpocitajSubory().spocitajSubory(new File("C:\\Windows\\System32\\drivers"), p2);
		stop = new Date();
		seconds = (stop.getTime() - start.getTime()) / 1000.0;
		System.out.println("Pocet suborov: " + p2.value + " vyhladane za (sekund): " + seconds);
		
	}

}
