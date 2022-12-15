package sk.itlearning.java3.java3b.n.csv.test;
//pozri source databazu - csv file z priecinka src/main resources - sk - itlearning - java 3 - java 3b - n - csv - test
//toto je komplikovane tak sme to na hodine moc nebrali. V podstate odovzdam jave parametre nieco s nimi urobime a nacitame vysled
import java.nio.charset.StandardCharsets;
import java.util.List;

import sk.itlearning.java3.java3b.n.csv.core.CsvMapping;
import sk.itlearning.java3.java3b.n.csv.core.CsvReaderParams;

public class DomMain {

	public static void main(String[] args) {
		
		CsvReaderParams params = new CsvReaderParams();
		
		params = new CsvReaderParams();
		params.setBatchSize(10);
		params.setCharset(StandardCharsets.UTF_8);
		params.setCsvFile(DomMain.class.getResourceAsStream("domy.csv"));//tento modul neni v java packages ale v src packagi
		//aby sme ho vedeli pouzit aj pre csv file, musim si z neho urobit kniznicu *vybuildovat kniznicu.
		//aj aby sme vedeli pouzit relative path. Absolute v programovani nepouzivame vzdy sa ref. na okolite subory alebo programy relativne k nasmu, lebo ak transfernem na iny pc tam mozu byt ine struktury adresarov
		//klik na java 3 b dame Run - Maven Build [prvy) - vybuilduje kniznicu java 3b, v Users sk-itlrning - java3b - n -csv - test - tam je otestovana skompilovana nacitana trieda javou a je tam prilozena aj class aj kniznica 3b
		params.setCsvSeparator(';');
		params.setSkipLines(1);
//		 odovzdam jave parametre :
		params.getMappingList().add(new CsvMapping().setCsvIndex(0).setFieldName("ulica"));
		params.getMappingList().add(new CsvMapping().setCsvIndex(1).setFieldName("cislo"));
		params.getMappingList().add(new CsvMapping().setCsvIndex(2).setFieldName("typ"));
		//nieco s nimi urobime :
		DomCsvImportBean bytCsvImportBean = new DomCsvImportBean();
		//nacitame vysled:
		List<Dom> domy = bytCsvImportBean.getNextBatch(params);
		
		for (Dom f : domy) {
			System.out.println(f);
		}
//		Tuto treba doimportovat z githubu aktualnu verziu tejto triedy, tu chyba kus kodu
		
	}
	
}
