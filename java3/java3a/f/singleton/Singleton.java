package sk.itlearning.java3.java3a.f.singleton;

public class Singleton {//vramci konkr typu programu mame tzv Design Patterns, kde si zadefinujeme standard techniky kt sa opakuju v tychtoch typoch programu tak si ich preddefinujeme
//je ich iba cca 20 a potom dalsich 20 je od nich odvodenych. Napr Singleton design Pattern, Factory, Adapter, Observer ...
	//Singleton - aplikacii doovolime aby existoval len jediny objekt
	//V Jave Singleton (vid papier poznamky) ide cez private konstruktor Singleton aby nikto ziaden user nemohol vytvroit svoj objekt, existuje iba jeden kt updatuju a vidia cez public metodu getInstance:

	private static final Singleton singleton = new Singleton();

	private Singleton() {
		super();
	}

	public static Singleton getInstance() {
		return singleton;
	}

}
