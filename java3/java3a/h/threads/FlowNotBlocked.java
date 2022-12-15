package sk.itlearning.java3.java3a.h.threads;

import java.io.IOException;
import java.time.LocalDateTime;

import sk.itlearning.java3.java3a.i.time.DateUtil;

public class FlowNotBlocked {

	public static void main(String[] args) throws IOException {
		
//		new Thread(new SpocitajRunnable()).start();//nove vlakno si pyta instanciu typu runnable. Ked implementujem interface musim prepisat nejaku triedu ako dole samostatne alebo vnorit anonymnu triedu
//		new Thread(new SpocitajRunnable()).start();//z main triedy moje programove riadky prikazy nastartuju nove programove vlakna a cele to dobehne naraz, nemusime cakat na metody
//		new Thread(new SpocitajRunnable()).start();
		LocalDateTime start = LocalDateTime.now();
		
		for (int i = 0; i < 1000; i++) {//for cyklus vytvori 1000vlakien zacnu a bezia nezavisle a v debug mode vidim ako postupne dobiehaju, nie naraz
			new Thread(new SpocitajRunnable(start)).start();
		}
		//teraz sa vytvorilo 100 nezavislych vlakien v ktorych sa mozu vykonavat metody dole rychlejsie nemusia 1 po druhej v 1 progr.vlakne sa cakat kym dobehnu
		//program je ovela vykonnejsi a rychlejsi(plus)
		//minus - ak nie sme opatrni mozu nastat dve velke chyby v programe - vid T1-RaceConditions
	}
	
	private static class SpocitajRunnable implements Runnable {//ked si urobim svoju triedu SpocitajRunnable tak to mam jednoduchsie mozem rovno vytvarat nove vlakna (new Thread)
	private LocalDateTime start;
	
	public SpocitajRunnable(LocalDateTime start) {
		super();
		this.start = start;

	}
	
		@Override
		public void run() {
	AtomicLong p1 = new AtomicLong();
	new SpocitajSubory().SpocitajSubory(newFile("C:\\Windows\\System32\\drivers"),p1);
	LocalDateTime stop = LocalDateTime.now();
	stop = LocalDateTime.now();
	System.out.println(DateUtil.getDurationFormatted(start, stop));
	}

}
}