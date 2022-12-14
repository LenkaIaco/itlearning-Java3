package sk.itlearning.java3.java3a.d.generics;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class G6_PrintMap {

	public static void main(String[] args) {

		Map<String, Obcan> mapaObcanov = new HashMap<>();
		mapaObcanov.put("11", new Obcan("11", "Jano"));//mapa je zoznam co definuje parove hodnoty ktore k sebe patria. ID obcana je 11(kluc) co je cislo zaznamu a potom je cely zaznam. To sa vola mapa 
		mapaObcanov.put("22", new Obcan("22", "Miso"));

		Map<Integer, BigDecimal> mapaCisel = new HashMap<>();
		mapaCisel.put(1, BigDecimal.valueOf(10));
		mapaCisel.put(2, BigDecimal.valueOf(20));

//		printObcania();//vytvorim staticku metodu :
//		private static void printObcania(Map<String, Obcan> mapa) {
//			for (String k : mapa.keySet()) {//takto sa klasicky prechadza zoznam typu mapa, kde kluc je vzdy prvy zaznam(key from keyset) V zozname mape nemozome ma v klucoch duplicitne zaznamy
//				System.out.println(mapa.get(k));
//			}
//		mapa.forEach((k, v) -> System.out.println(v));
//		}
		printAnyMap(mapaObcanov);

		printAnyMap(mapaCisel);

	}
//urobime genericku verziu metody: printAnyMap(Map<K,V> neber zatial ako triedu ale ako zastupne symboly, zatial nie su definovane. Preto to piseme aj za public static <K, V>
	public static <K, V> void printAnyMap(Map<K, V> map) {//definovane budu az ked tu metodu pouzijem v zozname ktory ma svoje parametre svojho typu
		for (K key : map.keySet()) {//s mapou nepouzivame verziu for i integer lebo nema integre ma cykly. V realite stale budeme lambdy uz pouzivat
			V hodnota = map.get(key);
			System.out.println(hodnota); // univerzalne metody kt akceptuju aj mapaCisel aj mapaObsahov
		}
	}

}
