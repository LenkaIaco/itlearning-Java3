package sk.itlearning.java3.java3a.h.threads;

import java.io.IOException;

public class FlowNotBlocked {

	public static void main(String[] args) throws IOException {
		
		new Thread(new SpocitajRunnable()).start();
		
	}
	
	private static class SpocitajRunnable implements Runnable {
		@Override
		public void run() {

		}
	}

}
