package sk.itlearning.java3.java3a.b.memory;

public class FillMemory {

	public static void main(String[] args) {
	
		String[] array = new String[500_000];//konstruujem pole(array ktory ma urc pocet prvkov. 500 000 prvkov aka 500 000 bytov; alebo dam 1 megabyte aka 1024 bytov 1 referencia zaberie 4 bytu tj 500000prvkov x 4 su 2 miliony bytov, tj 2 MB. Tak dame 500 000 000 tj 2 GB. A to nam neprejde lebo java ma max 2 GB nakonfigurovane (out of heapspace hlasenie). Tak dame 100 000 000. To by sme mali velku cast RAM zablok. 1 objektom. Tomu sa snazime v praxi vyhnut. Nikdy nenacitavame do pamate vsetky data, ale streamujeme - bezi blok dat kym bezi v pozadi sa nacitava dalsi lbok a ten ked sa nacita tak predosly sa zahodi. Tak velke aplikacie v praxi bezia.
		//ked sa nam minie heapspace tak uz nemozeme dalsie objekty. Kym prechadza program cez metodu main tak ten objekt musi existovat az do konca programu, tj dovtedy bude ta ram vytazena
		
		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);//trieda runtime: beziace prostredie. daj kolko mam celkovej pamate co mozem pouzit. Kazdy program co pustame si vyhradi nejaku cast pamate ram a v nej operuje.
		/*
		 * Java si na zac. vyhradi blok pamate, 1 blok je 128 MB a v nej operuje. Sikovne programuy ked naplnia program tak si vedia vypytat viac pamate. Java si vypyta dalsich 18 atd... up to max 2GB total. 
		 * Zakaznik nam nedovoli aby si Java vyhradila unho pre seba 2GB RAMky.
		 * Javove progr pustis cez java.exe class path urcis triedy a main kde program zacne. Predtym este pridavame argumenty -x konfiguracne parametre pri starte
		 * Ak cez eclipse nie java exe tak vieme cez rigtclick Arguments: google java vm arguments: Xmx Xms pridame a tam zadame kolko min a max velkosti memory si java moze vyhradit. Odporuca sa davat 2 na ntu cisla(g je giga m je megabyte): -Xms512m -Xmx1g alebo ekvivalent 1ho giga 1024mega: -Xms512m -Xmx1024m
		 * najprv aspon raz musime
		 */
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
		
	}
	
}
