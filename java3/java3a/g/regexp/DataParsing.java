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
	 *napr rodne cislo ma 3. cislo 5 ak ide o zenu a po lomitku su 4 cisla
	 *"..5.../...." - hladame v stringu nejake vzory, casti, a prekladame ich
	 *java parser hlada v kode nejake casti a preklada ich do akcie
	 */

	public static void main(String[] args) {//Aj multijaz.aplikacie pouz. taketo mapy. Akurat neprekladaju po slovach ale po vetach

		String text = "This is an example of english text to be translated into Slovak";

		Map<String, String> slovnik = new HashMap<String, String>();
		slovnik.put("This", "toto");
		slovnik.put("is", "je");
		slovnik.put("example", "pr\u0060klad");//pri kodovani slovnika musi byt rovnake kodovanie ako aplikacie, napr utf 8 aby sa specialne znaky spravne preniesli, napr dlhe i
		slovnik.put("english", "anglickeho");
		slovnik.put("text", "text");
		slovnik.put("to", "byt");
		slovnik.put("translated", "prelozeny");
		slovnik.put("into", "do");
		slovnik.put("Slovak", "slovencina");

		String[] pole = text.split(" ");//rozdel text na csti, oddelene medzerou ziskam pole jednotl.slov
		StringBuffer preklad = new StringBuffer();//idem skladat vacsi retazec tak pouz buffer

		for (String s : pole) {//kazde jedno preloz a potom naspat poskladaj s medzerami do viet
			String slovak = slovnik.get(s) == null ? s : slovnik.get(s);
			preklad.append(slovak + " ");
		}

		System.out.println(preklad.toString());

	}

}
