package sk.itlearning.java3.java3a.b.memory;

public class StringPool {

	public static void main(String[] args) {
	
		String knihaString2 = "";
		//Date start = new Date()
		for (int i = 0; i < 300_000; i++) {//na heap skonstruujeme jediny string v premennej kniha. Tento string ideme rozsirovat, nepridavame dalsie prvky. Kniha je na zaciatku prazdna a pridavame hodnoty. Ked pustim cez green play button, tak to nejaky cas trva kym v Consoly uvidime vysledky - to je spomalenie cez String optimisation overuse.
			//takze upravime i z 300 000 na 100 000 a pojde rychlejsie
			knihaString2 += String.valueOf(i);
		}
		
		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
		
		System.out.println(knihaString2.length());
		//Date stop = new Date()
		//System.out.println(stop.getTime() - start.getTime()) //tu sme si urobili aby sme videli v console kolko nam trva kym prejde Java cez celu tuto StringPool main metodu. Pri 100 000 je  10 sekund pri 200000 je 30 sekund, nerastie linearne ale exponencialne. Keby sme dali viac prvkov(milion) tak sa nedockame ani dozajtra.
		//program je primitivny, tak preco je taky neefektivny? vacsinou primitivne programy ako naplnit strink trvaju milisekundy. Co robi tento? Urobi prazdno najprv, odlozi 1 ku, overi ci v Heap je 1; overi ci neni v SP koli optimalizacii pamate; potom prida dalsi prvok 2 do SP overi ci neni 2 v Heap, atd, stale pri kazdom novom stringu musi prehladat string pool. Potom ked sa mu naplni String pool limit v urcitom bode. Takze ak uz nema nove tak musi uvolnit(vymazat ) cast predoslych zapisov v SP aby mal miesto na nove SP zapisy. Ten VYmazavatel, garbage pool nam zaberie najviac casu. Takze vyhnut sa nadmernemu pouz SP a tomu pouz. garbage poolu. 
		//Ako obist String pool mechanizmus pri velkych obj? Cez StringBuffer, cez metodu append - robime to iste ako hore cez i++ ale obchadzame string pool mechanizmus
	// pozri triedu StringBuffer - vobec nedava zapisy do StringPool pamate, rovno do Ramky. + tam je buffrovaci mechanizmus co este optimalizuje pracu s ramkov\u kedze zapisuje po velkych kusoch
	}

}
