package sk.itlearning.java3.java3a.h.threads;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

public class T5_Concurrency {

	public static void main(String[] args) {

		ExecutorService es = Executors.newSingleThreadExecutor();

		SpocitajSubory s1 = new SpocitajSubory();
		AtomicLong pocet = new AtomicLong();

		Callable<String> callable = () -> {
			s1.spocitajSubory(new File("C:/Windows/System32/drivers"), pocet);
			return String.valueOf(pocet.get());
		};
		
//		Future<String> future = es.submit(() -> { //tuto je to hore cez lambdu bez nutnosti vytvorenia novej anonymnej triedy(noveho obj)
//			s1.spocitajSubory(new File("C:/Windows/System32/drivers"), pocet);
//			return String.valueOf(pocet.get());
//		});

//		try {
//			System.out.println( future.get(10, TimeUnit.SECONDS) );
//			System.out.println( future.get());
//		} catch (InterruptedException | ExecutionException | TimeoutException e) {
//			e.printStackTrace();
//		}
		
		Future<String> future = es.submit(callable);
		try {
			if (future.isDone()) {
				System.out.println( future.get());
			}
			System.out.println( future.get(3, TimeUnit.SECONDS));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("Vysledok nedostupny v stanovenom ramci 3 sekundy");
		}
		System.out.println("Before end");
		
		es.shutdown();
	}
}
