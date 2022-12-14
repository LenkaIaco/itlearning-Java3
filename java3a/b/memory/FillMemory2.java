package sk.itlearning.java3.java3a.b.memory;

public class FillMemory2 {

	public static void main(String[] args) {
	
		String[] array = new String[250_000_000];
		
		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
		
		System.out.println(array);
		
		for (int i = 0; i < array.length; i++) {//tu zacneme plnit jednotlive prvky pola array. Ked vytvorim 1 objekt 123 ako String - ma 4 byty 1 prvok + kazdy znak stringu ma 2 byty, spolu 10 bytov. Kebyze mam velky objekt 1 GB velkuy array, v nom ma kazdy prvok 10 bytov tak by mal cely v konecnom 20 GB. Pocas toho ako bezi for cyklus tak sa vytvara velke mnozstvo Stringov na Heape v prvkoch array i+1 kym neprekroci heap limit pamate a potom program spadne
			//array[i] = new String("0123456789abcdef");//technika optimalizacie prace so stringami. Specialna posledna cast pamate String pool funguje tak - bez konstruktora Java auto skonstruuje objekt na heape ale ked volame bez konstruktora Java da aj do SP a pozrie do heapu ci to iste ma ako v SP a ak hej tak v Heape existuje ten prvok len ako referencia na SP objekt a tym padom setri pamat v Heape, optimalizuje pracu so stringami
			//ale musime pamatat na overuse tohto mechanizmu, vedie ky vyrazne spomalenemu programuy vid trieda stringPool
			array[i] = new String("0123456789abcdef");
		}
		
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2);

	}
	
}
