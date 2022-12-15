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
		//dve vlakna kde sa dva objekty vzajomne pouzivaju, nemozme nastavit ako synchronized pozdrav aj odzdrav inak deadlock - prvy thread lockne obj1 ako prvy a druhy thread lockne obj2 ako prvy ale kedze nastartovali THready naraz tak napoly su nastartovane ale nemozu dobehnut koli tomu ze druhy obj ktory potrebuju su navzajom locknute tou druhou metodou. Vysledok je, ze ani jedno vlakno nikdy nedobehne a musime restartovat celu aplikaciu.
		new Thread(new Runnable() {
			public void run() {
				alphonse.pozdrav(gaston);
			}
		}).start();
		//anotation hore - nevyriesime!! to tak ze surroud try catch + sleep, aby oba programy nezacali naraz ale druha trochu pocka dake milisekundy lebo nevieme kolko trva zbehnutie metody 1 a kedy zrovna metoda1 zacne pouz obj 2
		//jedine riesenie je nepouzivat deadlock situaciu! - nepouzvat synchro bloky so vzaj. odkazovanim. V jave sa vieme tomu vyhnut ale v databaze nie
		//prva datab.tabulka1 druha datab tabulka2 - ked updatujeme tab1 tak metoda1 moze upd aj tab2 ale v tomto poradi:
		//met.1: upd tab1 potom upd tab2 ++ met2: upd tab1 a potom tab2 - nikdy nie !! met2: upd tab2 potom tab1!!!
		new Thread(new Runnable() {
			public void run() {
				gaston.pozdrav(alphonse);
			}
		}).start();
	}
	
}