package sk.itlearning.java3.java3a.g.regexp;

import java.util.HashMap;
import java.util.Map;

public class DataParsing {

	/*
	 * Parsovanie dat je termin spojeny najme s konverziou textov na ine texty
	 * alebo na ine datove typy.
	 *
	 * Parsovanie dat sa casto pouziva sposobom vyhladavania urcitych vzorov
	 * v textovych suboroch a nasleduje konverzia najdeneho vzoru (podretazca, patternu)
	 * na iny text alebo na iny datovy typ
	 *
	 * Typicke pouzitia: kontrola syntaktickych pravidiel jazykov, jazykove prekladace,
	 * prekladace programov (kompilatory) atd.
	 *
	 */

	public static void main(String[] args) {

		String text = "This is an example of english text to be translated into Slovak";

		Map<String, String> slovnik = new HashMap<String, String>();
		slovnik.put("This", "toto");
		slovnik.put("is", "je");
		slovnik.put("example", "pr\u0060klad");
		slovnik.put("english", "anglickeho");
		slovnik.put("text", "text");
		slovnik.put("to", "byt");
		slovnik.put("translated", "prelozeny");
		slovnik.put("into", "do");
		slovnik.put("Slovak", "slovencina");

		String[] pole = text.split(" ");
		StringBuffer preklad = new StringBuffer();

		for (String s : pole) {
			String slovak = slovnik.get(s) == null ? s : slovnik.get(s);
			preklad.append(slovak + " ");
		}

		System.out.println(preklad.toString());

	}

}
