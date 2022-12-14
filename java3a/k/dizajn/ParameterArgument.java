package sk.itlearning.java3.java3a.k.dizajn;

public class ParameterArgument {

	public static void main(String[] args) {
		// pri volani metody odovzavam metode ARGUMENTY
		System.out.println(vypocitaj(10, 20));
	}
	
	// metoda definuje vstupne PARAMETRE
	private static int vypocitaj(int a, int b) {
		return a + b;
	}
	
}
