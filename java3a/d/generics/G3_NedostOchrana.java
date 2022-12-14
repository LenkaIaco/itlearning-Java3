package sk.itlearning.java3.java3a.d.generics;

import java.util.ArrayList;
import java.util.List;

public class G3_NedostOchrana {

	public static void main(String[] args) {

		List<Zakaznik> zList = new ArrayList<Zakaznik>();
		zList.add(new Obcan("22", "Johny"));
		zList.add(new Obcan("33", "Donnie"));

		// Genericitou zabezpecena typova ochrana ale nie je 100%-na,
		// cez nezabezpecenu triedu nam lahko moze do zabezpeceneho
		// pola vklznut nespravny typ

		G0_Adder a = new G0_Adder();
		a.add(zList);

		for (Zakaznik i : zList) {
			System.out.println(i.getId());
		}
		
	}

}
