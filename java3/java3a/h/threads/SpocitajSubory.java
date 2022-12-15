package sk.itlearning.java3.java3a.h.threads;

import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

class SpocitajSubory {

//	void spocitajSubory(File vAdresari, MutableLong pocet) {// tu musime podhodit objekt v kt budeme naratavat subory (MutableLong)
		// koli priecinkom a podpriecinkom vyuzivame rekurzivu lebo jeden subor moze mat
		// viac podsuborov cize v nom musime viackrat vykonat spocitaciu operaciu pre
		// kazdy podsubor
	void spocitajSubory(File vAdresari, AtomicLong pocet) {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//vlakno v ktorom bude volana tato metoda tak pozdrzim na 5 milisekund. takto sa spravi asynchronna metoda
//		Date start = new Date(); stara metoda
		if (vAdresari.isFile()) {
			pocet.incrementAndGet();
		}
		if (pocet.get()>=200) {
			synchronized (this) {//this je ten obj v kt zrovna ma monitor(T3-ThreadCommunication
				this.notifyAll();//dalsia z metod kt ma trieda Object.  ked je vysledok metody zapisany do objektu, notify vs. metody co cakaju ze mozu pokracovat dalsie vypocty
				//synchronised podporuje monitor kt sleduje ci uz zbehol prvy thread a potom notify all kt cakaju na zbehnutie prveho kym sa zacnu vykonavat
			}
		}
		if (vAdresari.listFiles() != null) {
			for (File f : vAdresari.listFiles()) {
				spocitajSuboryNotify(f, pocet);// tu pouzijem rekurzivu, zavolam sam seba, subory si spocitaju vsetko co je v
											// ich podspuboroch
			}
		}
	}

	void spocitajSuboryNotify(File vAdresari, AtomicLong p) {

	}

}
