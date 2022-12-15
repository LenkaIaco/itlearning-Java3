package sk.itlearning.java3.java3a.h.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class T4_MethodTimeout {

	public static void main(String[] args) {

		Timeoutable t = new Timeoutable();
		t.casovoObmedzenaMetoda();
		System.out.println(t.vysledok);

	}

	private static class Timeoutable {
		boolean timeout = false;
		FileReader vysledok;

		public void casovoObmedzenaMetoda() {

			Runnable casovoNarocnyBlok = new Runnable() {
				@Override
				public void run() {
				    String fileName = "C:\\tmp\\a.txt";//tato metoda caka na tento subor. Ma nastaveny timeout, ak taky subor existuje hned pokracuje s dalsim kodom dole. Ak sa nedocka, caka nejaky casovy limit, ci tam do priecinka nehodim ten subor, tak sa metoda vyresetuje zrusi a vrati vysledok 0, uz dalej necaka.
				    //metoda sa neresetuje, resetuje sa vlakno. 
				    File file = new File(fileName);
				    FileReader fr = null;
				    while (fr == null && !timeout) {
					    try {
							fr = new FileReader(file);
						} catch (FileNotFoundException e) {
							fr = null;
						}
				    }
				    vysledok = fr;
				    synchronized (Timeoutable.this) {
					    timeout = true;
					    Timeoutable.this.notify();
					}
				}
			};

			Thread timer = new Thread(new MethodTimer(this), "timer");
			timer.start();


			Thread metoda = new Thread(casovoNarocnyBlok, "metoda");
			metoda.start();
			while (timeout == false) {
				try {
					synchronized (this) {
						wait();
					}
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			metoda.interrupt();//tuto sa prerusi metoda aj timer - zresetuje sa programove vlakno. Manualne cele toto je strasne zlozite pisat, preto java ma na to automatizovane kniznicu Concurency API, ktora zjednodusuje pracu s vlaknami. Ale stale sa musime vuyhnut dvom zakladnym chybam kt mozu nastat v praci s vlaknami, RaceConditions a Deadlock, aj pri Concurrency kniznici praci
			timer.interrupt();
		}
	}

	private static class MethodTimer implements Runnable {
		private Timeoutable timeoutable;

		public MethodTimer(Timeoutable timeoutable) {
			this.timeoutable = timeoutable;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			}
			timeoutable.timeout = true;
			synchronized (timeoutable) {
				timeoutable.notifyAll();
			}
		}
	}

}
