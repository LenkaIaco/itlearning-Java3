package sk.itlearning.java3.java3a.d.generics;

import java.math.BigDecimal;
import java.util.Objects;

public class Obcan implements Zakaznik {

	private String rodneCislo;
	
	private String meno;
	
	private BigDecimal kredit;

	public String getRodneCislo() {
		return rodneCislo;
	}
	
	public Obcan(String rodneCislo, String meno) {
		setRodneCislo(rodneCislo);
		setMeno(meno);
	}

	public void setRodneCislo(String rodneCislo) {
		rodneCislo = rodneCislo.replace("/", "");
		long rcc = Long.valueOf(rodneCislo);
		if ( rcc % 11 == 0) {
			this.rodneCislo = rodneCislo;
		} else {
			throw new IllegalArgumentException("Zadali ste neplatne rodne cislo");
		}
	}

	public String getMeno() {
		return meno;
	}

	public void setMeno(String meno) {
		this.meno = meno;
	}

	public BigDecimal getKredit() {
		return kredit;
	}

	public void setKredit(BigDecimal kredit) {
		this.kredit = kredit;
	}
	
	@Override
	public String getId() {
		return getRodneCislo();
	}
	
	@Override
	public String toString() {
		return "Zakaznik; typ Obcan; RC = " + rodneCislo + "; Meno = " + meno;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Obcan)) 
			return false;
		Obcan o = (Obcan)obj;
		return Objects.equals(this.meno, o.meno) &&
			Objects.equals(this.rodneCislo, o.rodneCislo) &&
			Objects.equals(this.kredit, o.kredit);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.meno, this.kredit, this.rodneCislo);
	}
	
}
