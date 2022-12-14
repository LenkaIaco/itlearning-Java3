package sk.itlearning.java3.java3a.d.generics;

public class G1_Array {

	public static void main(String[] args) {

		// Polia maju definovany typ a nemozno do nich vlozit iny typ
		Integer[] iArray = new Integer[]{10, 20};

		for (Integer i : iArray) {
			System.out.println(i);
		}

	}

}

