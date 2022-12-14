package sk.itlearning.java3.java3a.a.reflection;

public class Main {

	public static void main(String[] args) {

		Vypocet v1 = new VypocetSposob1(1);

		System.out.println(v1.vypocitaj());

		Vypocet v2 = new VypocetSposob2(1);

		System.out.println(v2.vypocitaj());

		//while (true) {
//		String conf = "sk.itlearning.java3.a.reflection.VypocetA";		///
//		try {
//		Thread.sleep(1000);//toto musim podhodit aby v kuse bez prestania bezal program, aby zacal fungovat program(zakaznici chcu aby bezal program cely rok bez vypadku - e.g. v sobotu od 2 rana do 4 budu sluzby nedostupne)
		//tzv hod redeployment bez vypadku sa takto robi ked chceme podhodit v kuse beziacemu programu novu grupu tried ale nechceme ho zastavit a rekonfigurovat, ale zabehu to spravit
//			Class<?> c = Class.forName(conf);
//			Constructor<?> cc = c.getConstructor(int.class);
//			Vypocet v = (Vypocet) cc.newInstance(10); //Vypocet v = constructor.newInstance(10);teraz mam triedu typu (Vypocet) bez toho aby som specificky referencoval triedu Vypocet v = new Vypocet(), lebo tak by si banky vedeli pozriet cez zdrojovy kod vypocet variantu dryhej banky
//			Method m = c.getMethod("vypocitaj");
//			System.out.println(m.invoke(v));//System.out.println(v.vypocitaj()); potom uz mozem robit s metodou ako keby som bol byval skonstruoval triedu predtym
//		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//			e.printStackTrace();
//		}
//	}
	}

}

//kedysu sa robily 3 catchblocky a odchytavali sa vsetky eventuality security vynimiek kt mohli nastat
//catch securityexception e {
//	printstactrace()
//catch ...ina exception
//catch ...
//teraz pre zjednodusenie sa to pise od Javy 7 spolu(vid ako hore):  catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
//}