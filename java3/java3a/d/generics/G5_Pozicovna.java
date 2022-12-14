package sk.itlearning.java3.java3a.d.generics;

import java.util.ArrayList;
import java.util.List;


public class G5_Pozicovna {

	public static void main(String[] args) {
		List<Auto> listAuto = new ArrayList<Auto>();
		listAuto.add(new Auto("BMW"));
		listAuto.add(new Auto("Audi"));
		
		Pozicovna<Auto> pa = new Pozicovna<>(listAuto);	//kedze Pozicovna<T> hore je genericka tak sa da predefinovat aj s List typu Auto
		System.out.println(pa.dostupneNaVypozicanie);
		
		Auto pozicane = pa.pozicaj();
		System.out.println(pozicane);
		System.out.println(pa.dostupneNaVypozicanie);
		
		pa.vrat(pozicane);
		System.out.println(pa.dostupneNaVypozicanie);
		
		
		List<Saty> listSaty = new ArrayList<>();	//kedze trieda Pozicovna<T> je genericka tak sa da predefinovat aj s List typu Saty
		listSaty.add(new Saty("svadobne"));
		listSaty.add(new Saty("pracovne"));
		
		Pozicovna<Saty> ps = new Pozicovna<>(listSaty);
		System.out.println(ps.dostupneNaVypozicanie);
		
		Saty s = ps.pozicaj();
		System.out.println(ps.dostupneNaVypozicanie);
		
		ps.vrat(s);
		System.out.println(ps.dostupneNaVypozicanie);
		
		
	}
//	pozicovnaAut pa = new pozicovnaAut(listAuto);
//	Auto a = pa.pozicaj();
//	System.out.println(listAuto);
//	Auto a = pa.vrat();
//	System.out.println(listAuto);
//	
//	pa sa odkazuje na tuto triedu dole. 
//	static class PozicovnaAut {
//		private List<Auto> dostupneNaVypozicanie;
//
//		public PozicovnaAut(List<Auto> dostupneNaVypozicanie) {
//			this.dostupneNaVypozicanie = dostupneNaVypozicanie;
//		}
//
//		public Auto pozicaj() {
//			return dostupneNaVypozicanie.remove(0);//odober zo zoznamu pozicatelnych aut ked sa auto pozicuje
//		}
//
//		public void vrat(Auto t) {
//			dostupneNaVypozicanie.add(t);// ked sa vrati tak naspat vrat do zoznamu 
//		}
//	}

	
	
	static class Pozicovna<T> {//genericka trieda. Keby sme chceli jednu triedu Pozicovnuurobit co je kompatibilna pre pozicovnu aut aj pozicovnu siat atd.
		private List<T> dostupneNaVypozicanie;

		public Pozicovna(List<T> dostupneNaVypozicanie) {
			this.dostupneNaVypozicanie = dostupneNaVypozicanie;
		}

		public T pozicaj() {
			return dostupneNaVypozicanie.remove(0);
		}

		public void vrat(T t) {
			dostupneNaVypozicanie.add(t);
		}
	}

	
	static class Auto {
		String typ;
		public Auto(String typ) { this.typ = typ; }
		public String toString() {
			return typ;
		}
	}

	static class Saty {
		String typ;
		public Saty(String typ) { this.typ = typ; }
		public String toString() {
			return typ;
		}
	}

}