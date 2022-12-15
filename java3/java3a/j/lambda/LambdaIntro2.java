package sk.itlearning.java3.java3a.j.lambda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LambdaIntro2 {

	static class Tovar {//tu by sme mohli pridat Tovar implements Comparable<Tovar>(a naimportovat ju) ale to je stara metoda a nepouziva sa uz. Potom mozme pouzivat metodu sort co je dole zapoznamkovana
		//s comparable by som vedel porovnavat tovar iba s datumom vyroby(s triedou) a na kazdy iny comparisom by som musel robit extra triedu takze preto sa uz nepouziva.
		//Teraz sa pouziva namiesto toho Comparable triedu co ma comparator porovnavac
		
		LocalDate datumVyroby;//novsia trieda LocalDate sa uz pouziva nie Date
		
		public Tovar(LocalDate dv) {//vnorime si triedu do vnutra parenta, co skoro nikdy nerobime v praxi, tu je na edulkacne uceluy
			this.datumVyroby = dv;//chcem urobit ze vurobky usporiadam podla datumu vyuroby
		}
		@Override
		public String toString() {
			return datumVyroby.format(DateTimeFormatter.BASIC_ISO_DATE);
		}
//		@Override
//		public String compareTo(Tovar o) {//Comparable trieda umoznuje compareTo metodu kt. akceptuje porovnavat viacero typov imputov napr integer s datumami
//			return.this datumVyroby.compareTo(o.datumVyroby);
//		}
	}
	//najdolezitejsie API v jave je Collection interface - zbierka. Su tam typicke ybierky List, Set, Queue interfaces:
	/*
	 * List - 1.si zachovava poradie a 2.prvky sa mozu opakovat
	 * Set - 1.Poradie negarantovane tak jak vkladame. 3.A nedovoli duplicity vnutri sa opak prvky
	 * Queue - zasobnik typu FIFO - first in first out. V poradi ako vlozime prvky prve tak idu von prve. (cakaren u lekara, 
	 * -zasobnik typu LIFO - last in first out(mame stoh papierov na stole vytlaceny, kukame najprv na prvy hore)
	 */
	public static void main(String[] args) {

		Integer[] cislaArray = {1, 7, 4, 9, 3, 0, 4, 6, 2, 5, 8, 3};//array v tomto poradi prvky ako ich vkladam budu zapiosane v pamati

		List<Integer> cisla = Arrays.asList(cislaArray);//array prekonvertujem na list interface. Ak najprv je Array tok po konverzii na List zachova poradie prvkov 

		System.out.println(cisla);
	
//COllections je pom.trieda ku Collection. Ma metodu sort kde podhodime zoznam, prvky preusporiada od 1. najmen po navacs. ak su cisla zoznam:
		Collections.sort(cisla);

		System.out.println(cisla);
		
		Set<Integer> cislaSet = new HashSet<>(cisla); //import cislaSet. Skonstruujem ho s konstruktorom () a dnu dam array cisla, ale kedze tam sa prvky opakuju, tak z toho urobi Set, kde sa prvky neopakuju

		List<Tovar> tovar = new ArrayList<>();
		tovar.add(new Tovar(LocalDate.of(2016, 2, 11)));
		tovar.add(new Tovar(LocalDate.of(2016, 2, 1)));
		tovar.add(new Tovar(LocalDate.of(2016, 2, 8)));

		System.out.println(tovar);

//		 Collections.sort(tovar); // porovnat kazdy prvok s kazdym a tocit algorytmus kym nebudu abecedne zoradene. Tento dlho trva lebo je tam vela porovnavacich operacii. Su efektivnejsie algorytmy ako tento s mensim poctom porovn.operacii
		//sort si overuje ci tovar ma metodu compareTo (zapoznamkovane hore) ak nie vyhodi error
//		System.out.println(tovar);
//		Collections.reverse(tovar);
//		System.out.println(tovar);
		
//		Comparator<Tovar> c = new Comparator<>() {//zase,nevieme urobit interface, cize musime urobit cez anonymnu triedu vykonstruoanu na vzor interface
//			//ale vsade tam kde robime anonymnu triedu tak overime ci sa nejedna o interface s jedinou neimplementovanou(abstraktnou)metodou. Otvorime helppage k interfacu Comparator a hladame ci nema medzi metodami @Functional Interface. Ak hej tak to je jeho jedina neimplementovana metoda a tj mozem pouzit lambdy
//			@Override
//			public int compare(Tovar t1, Tovar t2) {
//				// TODO Auto-generated method stub
//				return t1.datumVyroby.compareTo(t2.datumVyroby);
//			}
//		};
//tu dole je altrernativa s lambdami
		Collections.sort(tovar, (t1, t2) -> t1.datumVyroby.compareTo(t2.datumVyroby));
		Collections.reverse(tovar);//este aj reverse sa da urobit ked chceme, je otocenie poradia prvkov zrkadlovo
		System.out.println(tovar);
		
	}

}
