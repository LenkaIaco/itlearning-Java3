package sk.itlearning.java3.java3b.n.csv.test;

import java.math.BigDecimal;

public class Firma {

	private Integer id;
	private String name;
	private BigDecimal trzby;
	private String adresa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getTrzby() {
		return trzby;
	}

	public void setTrzby(BigDecimal trzby) {
		this.trzby = trzby;
	}
	
	@Override
	public String toString() {
		return "Id: " + id + " Nazov: " + name + " Trzby: " + trzby;
	}

	public void setAdresa(String adresa) {
		// TODO Auto-generated method stub
		this.adresa = adresa;
		
	}
}
