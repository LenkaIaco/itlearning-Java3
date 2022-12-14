package sk.itlearning.java3.java3a.d.generics;

import java.util.ArrayList;
import java.util.List;


public class G5_Pozicovna {

	public static void main(String[] args) {
		List<Auto> listAuto = new ArrayList<Auto>();
		listAuto.add(new Auto("BMW"));
		listAuto.add(new Auto("Audi"));
		
		Pozicovna<Auto> pa = new Pozicovna<>(listAuto);
		System.out.println(pa.dostupneNaVypozicanie);
		
		Auto pozicane = pa.pozicaj();
		System.out.println(pozicane);
		System.out.println(pa.dostupneNaVypozicanie);
		
		pa.vrat(pozicane);
		System.out.println(pa.dostupneNaVypozicanie);
		
		
		List<Saty> listSaty = new ArrayList<>();
		listSaty.add(new Saty("svadobne"));
		listSaty.add(new Saty("pracovne"));
		
		Pozicovna<Saty> ps = new Pozicovna<>(listSaty);
		System.out.println(ps.dostupneNaVypozicanie);
		
		Saty s = ps.pozicaj();
		System.out.println(ps.dostupneNaVypozicanie);
		
		ps.vrat(s);
		System.out.println(ps.dostupneNaVypozicanie);
		
		
	}
	
	static class Pozicovna<T> {
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