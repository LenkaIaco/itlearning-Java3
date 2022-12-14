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

		for (Object i : oList) {
			if (i instanceof String) {
				System.out.println(((String) i).toUpperCase());
			}
		}

		// Vo verzii Java 5 prislo riesenie na obmedzenie typu prvkov,
		// ktore je mozne vkladat do dynamickeho zoznamu
		List<Zakaznik> zList = new ArrayList<>();
		zList.add(new Obcan("22", "Johny"));
		zList.add(new Obcan("33", "Donnie"));

		for (Zakaznik i : zList) {
			System.out.println(i.getId());
		}

	}

}
