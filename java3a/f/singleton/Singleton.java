package sk.itlearning.java3.java3a.f.singleton;

public class Singleton {

	private static final Singleton singleton = new Singleton();

	private Singleton() {
		super();
	}

	public static Singleton getInstance() {
		return singleton;
	}

}
