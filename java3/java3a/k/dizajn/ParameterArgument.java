package sk.itlearning.java3.java3a.k.dizajn;

public class ParameterArgument {

	public static void main(String[] args) {
		// pri volani metody odovzavam metode ARGUMENTY (10 a 20 ) - argumenty su pri pouziti
		System.out.println(vypocitaj(10, 20));
	}
	
	// pri definicii metody definujem vstupne PARAMETRE (a, b - moje buduce 10 a 20) - parametre su pri definicii
	private static int vypocitaj(int a, int b) {
		return a + b;
	}
	
}
