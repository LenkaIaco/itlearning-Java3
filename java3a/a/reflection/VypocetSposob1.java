package sk.itlearning.java3.java3a.a.reflection;

public class VypocetSposob1 implements Vypocet {

	private int param;

	@Override
	public int vypocitaj() {
		return param * 100;
	}

	public VypocetSposob1(int p) {
		super();
		param = p;
	}

}
