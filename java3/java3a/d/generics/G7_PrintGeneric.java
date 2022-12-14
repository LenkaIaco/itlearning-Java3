package sk.itlearning.java3.java3a.d.generics;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class G7_PrintGeneric {

	public static void main(String[] args) {

		Map<String, Obcan> mapaObcanov = new HashMap<>();
		mapaObcanov.put("11", new Obcan("11", "Jano"));
		mapaObcanov.put("22", new Obcan("22", "Miso"));

		Map<Integer, BigDecimal> mapaCisel = new HashMap<>();
		mapaCisel.put(1, BigDecimal.valueOf(10));
		mapaCisel.put(2, BigDecimal.valueOf(20));

		printAnyMap(mapaObcanov);

		printAnyMap(mapaCisel);

	}

	public static <K, V> void printAnyMap(Map<K, V> mapa) {
		for (K key : mapa.keySet()) {
			System.out.println(mapa.get(key));
		}
	}

}
