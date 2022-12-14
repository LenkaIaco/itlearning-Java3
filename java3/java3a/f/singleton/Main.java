package sk.itlearning.java3.java3a.f.singleton;

public class Main {

	public static void main(String[] args) {
	
		Singleton s1 = Singleton.getInstance();
		
		Singleton s2 = Singleton.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		
	}
	
}
