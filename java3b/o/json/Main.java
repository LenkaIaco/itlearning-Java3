package sk.itlearning.java3.java3b.o.json;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sk.itlearning.java3.java3b.n.csv.test.Firma;

public class Main {

	public static void main(String[] args) {
		
		//v foldri src si overime ci mame exvivalent json folder, ak hej pouzijeme relat referenciu:
		
		
		Reader r = new InputStreamReader(Main.class.getResourceAsStream("firmy.json"));
		
//		Gson gson = new Gson(); je bezna prax ale lepsie sa pracuje s metodami typu GsonBuilder:
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		//zakl json operacie - nacitat alebo vyprodukovat json subor
		Firma[] firmy = gson.fromJson(r, Firma [].class);
		
		for (Firma f : firmy) {
			f.setAdresa("nejaka adresa");
		}
		
		Arrays.asList(firmy).forEach(System.out::println);
		System.out.println(gson.toJson(firmy));
				
	
	}

}
