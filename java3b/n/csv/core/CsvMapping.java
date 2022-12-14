package sk.itlearning.java3.java3b.n.csv.core;

import java.lang.reflect.Method;

public class CsvMapping {

	private String fieldName;

	private Integer csvIndex;

	private Method method;

	public String getFieldName() {
		return fieldName;
	}

	public CsvMapping setFieldName(String fieldName) {
		this.fieldName = fieldName;
		return this;
	}

	public Integer getCsvIndex() {
		return csvIndex;
	}

	public CsvMapping setCsvIndex(Integer csvIndex) {
		this.csvIndex = csvIndex;
		return this;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}
}
