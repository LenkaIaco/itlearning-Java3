package sk.itlearning.java3.java3a.h.threads;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

import sk.itlearning.java3.java3a.i.time.DateUtil;

public class FlowBlocked {

	public static void main(String[] args) throws IOException {

		LocalDateTime start = LocalDateTime.now();
		AtomicLong p1 = new AtomicLong();
		
		new SpocitajSubory().spocitajSubory(new File("C:\\Windows\\System32\\drivers"), p1);//v Jave neexistuje asynchronna metoda (zavola sa metoda a vykonava ale program bezi dalej. Preto davame hore sleep. V javaskripte je to naopak, vsetko bezi dalej

		LocalDateTime stop = LocalDateTime.now();//volame staticku metodu nepotrebujeme konstruktor new
		System.out.println( p1.value);
		System.out.println(DateUtil.getDurationFormatted(start, stop));
		
		//tuto to druhy raz spocitam ale uz caka Java 5 milisekund kym dobehne prve spocitanie
		for (int i = 0; i < 10; i++) {
			AtomicLong p2 = new AtomicLong();
			new SpocitajSubory().spocitajSubory(new File("C:\\Windows\\System32\\drivers"), p2);//v Jave neexistuje asynchronna metoda (zavola sa metoda a vykonava ale program bezi dalej. Preto davame hore sleep. V javaskripte je to naopak, vsetko bezi dalej
			System.out.println( p2.value);
		}
		stop = LocalDateTime.now();//volame staticku metodu nepotrebujeme konstruktor new
		System.out.println(DateUtil.getDurationFormatted(start, stop));
	}
		
//		double seconds = (stop.getTime() - start.getTime()) / 1000.0;
//		
//		System.out.println("Pocet suborov: " + p1.value + " vyhladane za (sekund): " + seconds);

		
//		MutableLong p2 = new MutableLong();
//		new SpocitajSubory().spocitajSubory(new File("C:\\Windows\\System32\\drivers"), p2);
//		stop = new Date();
//		seconds = (stop.getTime() - start.getTime()) / 1000.0;
//		System.out.println("Pocet suborov: " + p2.value + " vyhladane za (sekund): " + seconds);
		
	}


