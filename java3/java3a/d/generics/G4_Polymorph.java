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

		Muz[] muzi = new Muz[]{new Muz(), new Muz()};//novy zoznam muzon

		List<Muz> listMuzi = new ArrayList<Muz>(Arrays.asList(muzi));//konkretna implementacia Listu je ArrayList, List je interface. asList prekonvertuje pole na List pri zachovani typu

		List<Clovek> listLudia = new ArrayList<Clovek>(); // prazdny zoznam
		listLudia.add(new Muz());//vlozime muza a zenu
		listLudia.add(new Zena());

		// Nasledovna metoda funguje pre polia, pretoze pre polia existuje vynimka ArrayStoreException,
		// ktora sa vyhodi pri pokuse o vlozenie objektu nespravneho typu.
		
		addClovek(muzi); //do pola muzi prida treti prvok muza
		
		// Rovnaka metoda pre genericke zoznamy nefunguje, pretoze kompilacia zmaze genericke typy,
		// takze JVM vidi iba List, ktory prijima lubovolny objekt a JVM nema informaciu, akeho typu su prvky
		// v zozname, takze nerozpozna ani pripadnu hrozbu vlozenia nespravneho typu. A preto je to rovno zakazane.
		
//		addClovek(listMuzi); tato nefunguje pre List<MUZ> lebo genericita ked ma zadefinovane zoznam clovekov tak nemozeme pridat zoznam muzov
//musi tu byt addClovek(listLudia) aby preslo
		readLudia(listMuzi);
		readSerializable(new ArrayList<Clovek>());
		addSuperType(listLudia);
		readAnyType(new ArrayList<String>());//tu mozme dat String, Object abo iny type lebo uplne dole mame zadefinovanu tuto metodu ako taku co akceptuje akykolvek typ
		readAnyType2(new ArrayList<Object>());
	}

	@SuppressWarnings("unused")//toto by preslo bez chyby kompilaciou, to je jedno obmedzenie pri genericite. 
	private static void addClovek(List<Clovek> list) {
		list.add(new Muz());
		list.add(new Zena());
	}

	private static void addClovek(Clovek[] list) {// sem pride addClovek(muzi); //toto by preslo kebyze dame addClovek ale dole nic nevkladame a dame extends(pozri dalsia metoda)
		list[0] = new Muz();
//		list[1] = new Zena(); //ArrayStoreException - muza viem, ale zenu neviem do pola vlozit
	}

	private static void readLudia(List<? extends Clovek> list) {
		for (Clovek c : list) {
			System.out.println(c);
		}
//		 list.add(new Muz()); // ako piseme v metode hore, ked je extends tak akceptuje pridanie kompatibilnych listov *Ludia Clovek, len je zakazane pridavat do zoznamu uz potom cez add
	}

	private static void readSerializable(List<? extends Serializable> list) {//aj ked serializable je interface tak pouzivame v genericite aj pre interfacy aj triedy pouzivame extends
		// do nothing
	}

	private static void addSuperType(List<? super Muz> list) {//mozme sem poslat hocaky zoznam co je muz abo hocaky zoznam zo super triedy *zoznam typu clovek. Zena neni supertrieda Muza takze to nemozme vlozit
		//takto mame moznost pridavat prvky, lebo mame priamo definovany konkretny typ s kt mozme pracovat*muz abo clovek
		list.add(new Muz());
//		list.add(new Zena());
		// metoda akceptuje genericky typ Muz a akykolvek objekt nadtriedy ku triede Muz
	}

	private static void readAnyType(ArrayList<?> list) { //akceptuje zoznam akychkolvej prvkok
		// metoda akceptuje genericky typ Muz a akykolvek objekt nadtriedy ku triede Muz
	}
	
	private static void readAnyType2(ArrayList<Object> list) {//akceptuje iba prvy Object
		// metoda akceptuje genericky typ Muz a akykolvek objekt nadtriedy ku triede Muz
	}
	
}
