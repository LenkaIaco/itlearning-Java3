package sk.itlearning.java3.java3a.i.time;
///Java 8 je od 2014. Aplikacie su na trhu funkcne aj take co pred 20 r boli vymyslene, este stale su niekde v obehu
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatePreJava8 {

	public static void main(String[] args) {

		// aktualny timestamp ziskany zo systemoveho casu
		Date d = new Date();//kedysi pre cas existovala iba jedina trieda Date

		System.out.println(d);

		// formatovanie datumu na zelany tvar
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//naformatujeme si ho "yyyy-MM-dd" a rozsirime podla pravidiel ponuknutych v popup okienku pri definovani funkcie na "yyyy-MM-dd HH:mm"
		System.out.println(sdf.format(d));

		// extrakcia jednotlivych casti datumu
		Calendar c = new GregorianCalendar();//najprv bolo treba vynulovat casovu zlozku nastavit na nulu. Calendare podtypy su asi 4 a my pouzivame gregoriansky
		c.setTime(d);
//ked to mame vynulovane tak ideme definovat:
		//ale nesupportovalo to napr europsku vs americku definiciu csu (nasa zacina den od polnoci 00 oni od 12:00 + prestupne roky sa museli manualne pisat
		//teraz sa pouzivaju lokalne classes LocalDate + OffsetTime.class  - tam mam lokalny cas zratany s tym offsetom
		//plus tie nove maju dalsie metody na pracovanie s casovymi zaznamami
		//koli appkam kt este pracuju so starou Date musime ale poznat ako pracuje(pozri DateTime.java triedu)
		System.out.println("Aktualny cas je: "
			+ c.get(Calendar.HOUR)
			+ ":"
			+ c.get(Calendar.MINUTE)
			+ " week: "
			+ c.get(Calendar.DAY_OF_WEEK));

		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		System.out.println(c.getTime());

	}

}
