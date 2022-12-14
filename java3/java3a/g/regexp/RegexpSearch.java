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
		 *  priklad pre regexpy sa validuju IBANY alebo mailove adresy m @ n. xy
		 */
		
		String s = "nejakom texte nieco nachadza";
		System.out.println(s.indexOf("nieco"));
		
		//pytame sa ci sa v String text dole nachadza, a kolko, tel.cisel
		Pattern p = Pattern.compile("1[0-9]{3}/\\d{6}"); // the expression / pattern - vzor, ktory budeme hladat v texte
//mozme napisat aj takto(ekvivalentny zapis): ("1\\d{3}/\\d{6}") kde \\je obycajne lomitko /
		String text = "text s telefonnymi cislami, prve (1940/506077) v spravnom tvare, "
				+ "druhe (1940/506070) v nespravnom tvare (teda sa nenajde podla zadaneho vzoru)";

		Matcher m = p.matcher(text); // the source - zdrojovy text

		int pocetVyskytov = 0;

		while (m.find()) {
			pocetVyskytov++;
			System.out.println("najdeny vyskyt na pozicii " + m.start() + " " + text.substring(m.start(), m.end()));//urobim substring, vystrihnem cast textu od index start po index end, substring je moje najdene tel.c.
		}

		System.out.println(); // prazdny riadok do konzoly
		System.out.println("pocet vyskytov: " + pocetVyskytov);

		// aj retazce mozme porovnavat voci regularnym vyrazom (patternom)
		
		text = "801222/1234";//tu by sme overovali: (text.matches("\\d{6}/(\\d{3}|\\d{3})")); za lomitkom v zatvorke (\\d{3}|\\d{3})znamena 3 ALEBO 4 cisla. Dalsi scenar (...\\d*\\d{3}") by znamenalo 0-n; cize by zobral aj dve
		// este sa da \\d? pouzit ako ze nepovinne napisat tu jednu digit: ("\\d{6}/(\\d?\\d{3})"))

		System.out.println(); // prazdny riadok do konzoly
		System.out.println(text.matches(".*0[0-9]{3}/[0-9]{6}.*"));
		
		String mail = "dfasdf@yahoo.com";
		
		System.out.println(mail.matches("[\\w,_,-,.]+@[\\w]+\\.com"));/// hocaky zo znakov, + @ + nieco  +. com \\pre bodku escape pred com
		
		// "abc874"
		
		// Example for sql - vid src/main/resources - insert.sql
		// insert into Table (a, b, c) values (1, "a", ""); convert to ->
		// insert into Table (a, b, c, d) values (1, 1, "a", "");
		// replace (\d+,) with \1 \1 (\1 = stored found value)
		
	}

}
