package sk.itlearning.java3.java3a.h.threads;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class T3_ThreadCommunication {

	public static void main(String[] args) throws IOException {

		final Date start = new Date();

		final AtomicLong p1 = new AtomicLong();
		
		final SpocitajSubory s1 = new SpocitajSubory();
		
		Thread t1 = new Thread() {//anonymna trieda s prepisanim metody run
			public void run() {
				s1.spocitajSuboryNotify(new File("C:\\Windows\\System32\\drivers"), p1);
				Date stop1 = new Date();
				double seconds = (stop1.getTime() - start.getTime()) / 1000.0;
				System.out.println("Pocet suborov: " + p1.get() + " vyhladane za (sekund): " + seconds);
			}
		};//thread sa vyrobi
		t1.start();//thread sa nastartuje

		try {//vlakna komunikuju - objekt ma informaciu v kt vlakne zrovna prebieha ked su synchronised operacie - objekt ma lock co je vlastne monitor ze sa obj zrovna vykonava v thread1 a ten monitor potom lockne
			//monitor mozme vyuzit takto:
			synchronized (s1) {//monitor v S1: - musi byt synchronised ak chceme pouz metodu wait
				s1.wait();//kazdy object ma metodu wait. Pozastavi sa vykonavanie vlakna v kt.zrovna bezi a v kt zrovna volame metodu. ta si vyzaduje trycatch
			//ak je 
			};
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//toto sa nastartuje az ked dobehne to prve vlakno hore lebo sme nastavili aby medzi sebou vlakna komunikovali - pockali sa
		SpocitajSubory s2 = new SpocitajSubory();
		
		final AtomicLong p2 = new AtomicLong();
		s2.spocitajSuboryNotify(new File("C:\\Windows\\System32\\drivers"), p2);
		Date stop2 = new Date();
		double seconds = (stop2.getTime() - start.getTime()) / 1000.0;
		System.out.println("Pocet suborov: " + p2.get() + " vyhladane za (sekund): " + seconds);

	}

}
