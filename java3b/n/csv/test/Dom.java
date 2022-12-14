package sk.itlearning.java3.java3b.n.csv.test;

public class Dom {

	private String ulica;
	private Integer cislo;
	private String typ;

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public Integer getCislo() {
		return cislo;
	}

	public void setCislo(Integer cislo) {
		this.cislo = cislo;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	@Override
	public String toString() {
		return "Dom: " + this.ulica+ "  ###  cislo: " + this.cislo + "  ###  Typ: " + this.typ; 
	}

}
