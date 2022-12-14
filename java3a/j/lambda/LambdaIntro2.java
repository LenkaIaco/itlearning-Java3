package sk.itlearning.java3.java3a.j.lambda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaIntro2 {

	static class Tovar {
		
		LocalDate datumVyroby;
		
		public Tovar(LocalDate dv) {
			this.datumVyroby = dv;
		}
		@Override
		public String toString() {
			return datumVyroby.format(DateTimeFormatter.BASIC_ISO_DATE);
		}
	}

	public static void main(String[] args) {

		Integer[] cislaArray = {1, 7, 4, 9, 3, 0, 4, 6, 2, 5, 8, 3};

		List<Integer> cisla = Arrays.asList(cislaArray);

		System.out.println(cisla);

		Collections.sort(cisla);

		System.out.println(cisla);

		List<Tovar> tovar = new ArrayList<>();
		tovar.add(new Tovar(LocalDate.of(2016, 2, 11)));
		tovar.add(new Tovar(LocalDate.of(2016, 2, 1)));
		tovar.add(new Tovar(LocalDate.of(2016, 2, 8)));

		System.out.println(tovar);

//		 Collections.sort(tovar);
		
//		Comparator<Tovar> c = new Comparator<>() {
//			@Override
//			public int compare(Tovar arg0, Tovar arg1) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		};

		Collections.sort(tovar, (a, b) -> a.datumVyroby.compareTo(b.datumVyroby));
		
		System.out.println(tovar);
		
	}

}
