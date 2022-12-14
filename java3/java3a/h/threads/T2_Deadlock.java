package sk.itlearning.java3.java3a.h.threads;

public class T2_Deadlock {
	
	static class Friend {
		private final String name;

		public Friend(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public void pozdrav(Friend bower) {
			System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
			bower.odzdrav(this);
		}

		public void odzdrav(Friend bower) {
			System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
		}
	}

	public static void main(String[] args) {
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");
		
		new Thread(new Runnable() {
			public void run() {
				alphonse.pozdrav(gaston);
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				gaston.pozdrav(alphonse);
			}
		}).start();
	}
	
}