package sk.itlearning.java3.java3a.h.threads;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class T5_Concurrency {

	public static void main(String[] args) {

		ExecutorService es = Executors.newSingleThreadExecutor();

		SpocitajSubory s1 = new SpocitajSubory();
		MutableLong ml = new MutableLong();

		Future<String> future = es.submit(() -> {
			s1.spocitajSubory(new File("C:/Windows/System32/drivers"), ml);
			return String.valueOf(ml.value);
		});

		try {
			System.out.println( future.get(10, TimeUnit.SECONDS) );
			System.out.println( future.get());
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}

		es.shutdown();
	}

}
