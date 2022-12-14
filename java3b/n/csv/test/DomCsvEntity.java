package sk.itlearning.java3.java3b.n.csv.test;

import sk.itlearning.java3.java3b.n.csv.core.CsvEntity;

public class DomCsvEntity extends Dom implements CsvEntity<Dom> {

	@Override
	public Dom toModel() {
		Dom modelObject = new Dom();
		modelObject.setCislo(this.getCislo());
		modelObject.setTyp(this.getTyp());
		modelObject.setUlica(this.getUlica());
		return modelObject;
	}

	public void setUlica(String ulica) {
		super.setUlica(ulica);
	}
	
	public void setCislo(String cislo) {
		super.setCislo(Integer.valueOf(cislo));
	}
	
	public void setTyp(String typ) {
		super.setTyp(typ);
	}
	
}
