package sk.itlearning.java3.java3a.d.generics;

import java.util.ArrayList;
import java.util.List;

public class G2_List {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		// List interface vo verzii Java 1.4 nemal obmedzeny typ,
		// dali sa do neho vkladat hocijake objekty
		List oList = new ArrayList();
		oList.add(0.0);
		oList.add(10);
		oList.add("text");
		oList.add(new Obcan("11", "Meno"));
		//oList.remove (0) prvy prvok removneme
		//oList.remove ("text") konkretny text removneme 
		for (Object i : oList) {// myslime si ze i je String ale nie je
			if (i instanceof String) {//pretypujem na String a potom mi vyhodi error
				System.out.println(((String) i).toUpperCase());
				//takze musime pridat riadok co overuje ci i je string ako prvy riadok za {
			}
		}
// toto je novy kod kt pozna genericitu. Hore neni este genericita, stary typ kodu. Ked skompilujem kod, tak nemusi byt kompatibilny so starymi kodmi kde este nebola genericita.
		//cize pri kompilacii kod prejde ale v praxi treba aby fungovalo este pridat dodatocnu ochranu: class GO Adder  List list - akceptuje akykolvek input do Listu. Lenze aj to moze vyhodit errory - ako v class G3 NedostOchrana
		// Vo verzii Java 5 prislo riesenie na obmedzenie typu prvkov,
		// ktore je mozne vkladat do dynamickeho zoznamu
		List<Zakaznik> zList = new ArrayList<>();
		zList.add(new Obcan("22", "Johny"));
		zList.add(new Obcan("33", "Donnie"));
// zList.add("") by hodilo complilation error lebo input do List neni string. akceptuje iba objekty typu Zakaznik
		for (Zakaznik i : zList) {
			System.out.println(i.getId());
		}

	}

}
