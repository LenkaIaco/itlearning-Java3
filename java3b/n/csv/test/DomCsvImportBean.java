package sk.itlearning.java3.java3b.n.csv.test;

import java.io.FileNotFoundException;
import java.util.List;

import sk.itlearning.java3.java3b.n.csv.core.CsvReader;
import sk.itlearning.java3.java3b.n.csv.core.CsvReaderParams;

public class DomCsvImportBean {

	private CsvReader<DomCsvEntity, Dom> reader;

	public List<Dom> getNextBatch(CsvReaderParams params) {
		if (reader == null) {
			try {
				reader = new CsvReader<>(DomCsvEntity.class, params);
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
		return reader.getNextBatch();
	}

	public void resetReader() {
		reader = null;
	}

}
