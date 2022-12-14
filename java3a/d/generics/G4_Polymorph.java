package sk.itlearning.java3.java3a.d.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Clovek implements Serializable {
	private static final long serialVersionUID = 1L;
}

class Muz extends Clovek {
	private static final long serialVersionUID = 1L;
}

class Zena extends Clovek {
	private static final long serialVersionUID = 1L;
}

public class G4_Polymorph {
	
	public static void main(String[] args) {

		Muz[] muzi = new Muz[]{new Muz(), new Muz()};

		List<Muz> listMuzi = new ArrayList<Muz>(Arrays.asList(muzi));

		List<Clovek> listLudia = new ArrayList<Clovek>();
		listLudia.add(new Muz());
		listLudia.add(new Zena());

		// Nasledovna metoda funguje pre polia, pretoze pre polia existuje vynimka ArrayStoreException,
		// ktora sa vyhodi pri pokuse o vlozenie objektu nespravneho typu.
		
		addClovek(muzi);
		
		// Rovnaka metoda pre genericke zoznamy nefunguje, pretoze kompilacia zmaze genericke typy,
		// takze JVM vidi iba List, ktory prijima lubovolny objekt a JVM nema informaciu, akeho typu su prvky
		// v zozname, takze nerozpozna ani pripadnu hrozbu vlozenia nespravneho typu. A preto je to rovno zakazane.
		
//		addClovek(listMuzi);

		readLudia(listMuzi);
		readSerializable(new ArrayList<Clovek>());
		addSuperType(listLudia);
		readAnyType(new ArrayList<String>());
		readAnyType2(new ArrayList<Object>());
	}

	@SuppressWarnings("unused")
	private static void addClovek(List<Clovek> list) {
		list.add(new Muz());
		list.add(new Zena());
	}

	private static void addClovek(Clovek[] list) {
		list[0] = new Muz();
		list[1] = new Zena(); //ArrayStoreException
	}

	private static void readLudia(List<? extends Clovek> list) {
		for (Clovek c : list) {
			System.out.println(c);
		}
//		 list.add(new Muz());
	}

	private static void readSerializable(List<? extends Serializable> list) {
		// do nothing
	}

	private static void addSuperType(List<? super Muz> list) {
		list.add(new Muz());
//		list.add(new Zena());
		// metoda akceptuje genericky typ Muz a akykolvek objekt nadtriedy ku triede Muz
	}

	private static void readAnyType(ArrayList<?> list) {
		// metoda akceptuje genericky typ Muz a akykolvek objekt nadtriedy ku triede Muz
	}
	
	private static void readAnyType2(ArrayList<Object> list) {
		// metoda akceptuje genericky typ Muz a akykolvek objekt nadtriedy ku triede Muz
	}
	
}
