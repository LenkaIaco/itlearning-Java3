package sk.itlearning.java3.java3b.n.csv.core;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderParams {

	private InputStream csvFile;

	private Character csvSeparator = ';';

	private Charset charset = StandardCharsets.UTF_8;

	private int skipLines;

	private List<CsvMapping> mappingList = new ArrayList<>();

	private int batchSize = 100;

	public Character getCsvSeparator() {
		return csvSeparator;
	}

	public void setCsvSeparator(Character csvSeparator) {
		this.csvSeparator = csvSeparator;
	}

	public Charset getCharset() {
		return charset;
	}

	public void setCharset(Charset charset) {
		this.charset = charset;
	}

	public int getSkipLines() {
		return skipLines;
	}

	public void setSkipLines(int skipLines) {
		this.skipLines = skipLines;
	}

	public List<CsvMapping> getMappingList() {
		return mappingList;
	}

	public int getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	public InputStream getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(InputStream csvFile) {
		this.csvFile = csvFile;
	}

}
