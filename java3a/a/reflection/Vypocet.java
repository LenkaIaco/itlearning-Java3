
package sk.itlearning.java3.java3a.a.reflection;

public interface Vypocet {//ak  chcen implementovat interface vypocet(vypocetsposob1) tak musim implementovat metodu vypocitaj(@Override)
	/*v praxi pouz: Urobime 1 appku ale chceme ju predat co najviac zakaznikom: Vypoc.rating klienta pri poziadani o uver.
	 * Chceme predat viac bankam. Tie samotne vypocty si kazda banka trochu upravi. tj pre kaz.banku urobime podla interface vlastnu triedu.
	 * Lenze cez implementovanu triedu sa da zistit zdrojovy kod interfacu aj vsetkych tried co ju implementuju, co by si banka v svojom Vypocet2 cez zdrojovy kod vedela najst cez class Vypocet a pozriet druhu class Vypocet 2 druhej banky - obch tajomstvo ako ona pocita uver rating.
	 * tak nepouzivame referenciu *vypocet v1 = new Vypocet, ale vid Main.java String conf String conf = "sk.itlearning.java3.a.reflection.VypocetA";		
	 * trieda class ma zaujimavu metodu unique pre java forName - daj mi triedu pre(takyto nazov) Ked mam triedu takto, potom skonstruujem triedu v Main, ale bez nazvu triedy. class je klucove slovo co nem pouzit, tak pouz clazz
	 * Constructor constructor = clazz.getconstructor(int.class) int je primitivna premenna ale ma vnorenu premennu class //( Class <?> s varargs
	 * doimportujeme hore package java.lang.reflect.Constructor
	*/

	public int vypocitaj();
	
}
