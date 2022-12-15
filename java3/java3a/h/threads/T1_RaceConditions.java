package sk.itlearning.java3.java3a.h.threads;

public class T1_RaceConditions {

	static class Counter {
	    private int value = 0;

	    public synchronized void increment() {
	    	value++;
	    }

	    public synchronized void decrement() {
	    	value--;
	    }
	}

	public static void main(String[] args) {

		Counter c = new Counter();
		
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					c.increment();
				}
			}
		};

		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {//ak by sme mali uy viacnasobne vlakien( a nemali synchronised) napr 10000 zacnu sa diat chyby koli tzv konkurentnosti vlakien:
					/*
					 * zvysujeme premennu o 1 - najprv sa vypyta z pamate nulova, potom zvysime o 1 a uklada sa do docasnej medzipamate a nakoniec sa zapise do pamate ako 1 - to su atomicke kroky metody kt nevidime
					 * vlakno dostane cas na tieto kroky, na pracu a druhe vlakno musi pockat kym sa tie atomicke kroky urobia
					 *ale ked mame vela vlakien ako vo FlowNotBlocked tak sa snazia bezat naraz a potom si navzajom prepisuju tie atomicke medzivysledky
					 *ak su mutable premenne tak nastava tento problem prepisovania v pamati, pri immutable nie, mozme pouzivat FlowNotBlocked
					* ak sa 2 vlakna biju o tu istu premennu tak vysledok moze byt ze vysledok neni ani z 1 ani druhej lebo si navzajom prekazaju
					* preto pouzivame synchronised block v objekte kt pouzivame napr c, na c sas urobi neviditelna znacka c ktora je synchronised, a ked zacne synchro operacia na objekte tak na objekte sa nastavi lock, kym je pouz operacia vlaknom T1. Ked T2 progr.vlakno chce pouz ten isty objekt musi pockat kym dobehne T1 a zrusi sa lock a potom moze pouzit T2 tento objekt. T2 si potom vytvori svoj lock atd.
					 */
					c.decrement();
				}
			}
		};

		new Thread(r1).start();//prve vlakno zvysuje premennu o 1000 a 
		new Thread(r2).start();///druhe znizi o 1000 vysledok =0
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		while (Thread.activeCount() > 1);//nestaci cakat x milisekund ako v annotation hore, musime dat podnienku ze kym nedobehnut vlakna
		
		if (c.value != 0) 
			System.out.println(c.value);
		}
		
	}


