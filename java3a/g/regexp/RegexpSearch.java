package sk.itlearning.java3.java3a.g.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpSearch {

	public static void main(String[] args) {

		/*
		 *  ^ = na zaciatku textu
		 *  $ = na konci textu
		 *  [0-9] = skupina znakov 0, 1, 2, 3.. - 9
		 *  {3} = 3 znaky musia zodpovedat predchadzajucemu vzoru
		 */
		
		String s = "nejakom texte nieco nachadza";
		System.out.println(s.indexOf("nieco"));
		
		Pattern p = Pattern.compile("1[0-9]{3}/\\d{6}"); // the expression / pattern - vzor, ktory budeme hladat v texte

		String text = "text s telefonnymi cislami, prve (1940/506077) v spravnom tvare, "
				+ "druhe (1940/506070) v nespravnom tvare (teda sa nenajde podla zadaneho vzoru)";

		Matcher m = p.matcher(text); // the source - zdrojovy text

		int pocetVyskytov = 0;

		while (m.find()) {
			pocetVyskytov++;
			System.out.println("najdeny vyskyt na pozicii " + m.start() + " " + text.substring(m.start(), m.end()));
		}

		System.out.println(); // prazdny riadok do konzoly
		System.out.println("pocet vyskytov: " + pocetVyskytov);

		// aj retazce mozme porovnavat voci regularnym vyrazom (patternom)

		System.out.println(); // prazdny riadok do konzoly
		System.out.println(text.matches(".*0[0-9]{3}/[0-9]{6}.*"));
		
		String mail = "dfasdf@yahoo.com";
		
		System.out.println(mail.matches("[\\w,_,-,.]+@[\\w]+\\.com"));
		
		// "abc874"
		
		// Example for sql
		// insert into Table (a, b, c) values (1, "a", ""); convert to ->
		// insert into Table (a, b, c, d) values (1, 1, "a", "");
		// replace (\d+,) with \1 \1 (\1 = stored found value)
		
	}

}
