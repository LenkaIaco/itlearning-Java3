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
				for (int i = 0; i < 1000; i++) {
					c.decrement();
				}
			}
		};

		new Thread(r1).start();
		new Thread(r2).start();
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		while (Thread.activeCount() > 1);
		
		if (c.value != 0) {
			System.out.println(c.value);
		}
		
	}

}
