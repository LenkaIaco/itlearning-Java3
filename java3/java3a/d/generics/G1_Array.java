package sk.itlearning.java3.java3a.d.generics;

public class G1_Array {

	public static void main(String[] args) {

		// Polia maju definovany typ a nemozno do nich vlozit iny typ
		Integer[] iArray = new Integer[]{10, 20};//z tejto premennej robi pole vlavo iba pritomnost hranatych zatvoriek. Vpravo je [bud pocet napiseme prvkov] alebo rovno prvky vypisat v {}
//		Integer[] iArray = new Integer{10, 20}; aj takto sa da napisat lebo pocet prvkov je implicitne znamy z {} netreba []
		// este aj tu mozme vypustit zatvorky v jave a to je vsetko: String s = ""
		for (Integer i : iArray) {
			System.out.println(i);
		}

	}

}

