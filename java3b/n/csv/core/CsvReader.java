package sk.itlearning.java3.java3b.n.csv.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CsvReader<B, E> {

	private CSVReader csvReader;

	private Iterator<String[]> iterator;

	private Map<Integer, CsvMapping> mapping = new HashMap<>();

	private InputStream inputStream;

	private InputStreamReader inputStramReader;

	private Class<B> beanClass;

	private CsvReaderParams params;

	public CsvReader(Class<B> beanClass, CsvReaderParams params) throws FileNotFoundException {
		inputStream = params.getCsvFile();
		inputStramReader = new InputStreamReader(inputStream, params.getCharset());
		this.beanClass = beanClass;
		this.params = params;
		csvReader = new CSVReaderBuilder(inputStramReader).withSkipLines(params.getSkipLines())
				.withCSVParser(new CSVParserBuilder().withSeparator(params.getCsvSeparator()).build()).build();
		iterator = csvReader.iterator();
		setMapping(beanClass, params);
	}

	private void setMapping(Class<B> cls, CsvReaderParams params) {
		List<Method> methods = Arrays.asList(cls.getDeclaredMethods());
		Set<Method> setters = new HashSet<>();
		methods.stream().forEach(m -> {if (m.getName().startsWith("set")) setters.add(m);});
		setters.stream().forEach(s -> {
			params.getMappingList().forEach( m -> {
				if (m.getFieldName().equalsIgnoreCase(s.getName().substring(3))) {
					m.setMethod(s);
					mapping.put(m.getCsvIndex(), m);
				}});
		});
	}

	public boolean hasNext() {
		return iterator.hasNext();
	}

	public E getNext(CsvEntity<E> csvBean) {
		if (!iterator.hasNext()) {
			try {
				csvReader.close();
				inputStramReader.close();
				inputStream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return null;
		}
		String[] data = iterator.next();
		for (int i = 0; i < data.length; i++) {
			Method m = mapping.get(i) == null ? null : (Method) mapping.get(i).getMethod();
			if (m == null) continue;
			try {
				String value = data[i];
				if (value == "") value = null;
				m.invoke(csvBean, value);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		}
		return csvBean.toModel();
	}

	@SuppressWarnings("unchecked")
	public List<E> getNextBatch() {
		List<E> list = new ArrayList<>();
		for (int i = 0; i < params.getBatchSize(); i++) {
			try {
				CsvEntity<E> csvBean = (CsvEntity<E>) beanClass.getConstructor().newInstance();
				E entity = getNext(csvBean);
				if (entity != null) {
					list.add(entity);
				} else {
					break;
				}
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}

}
