package sk.itlearning.java3.java3a.a.reflection;

public class VypocetSposob2 implements Vypocet {

	private int param;

	@Override
	public int vypocitaj() {
		return param * 200;
	}

	public VypocetSposob2(int p) {
		super();
		param = p;
	}

}
