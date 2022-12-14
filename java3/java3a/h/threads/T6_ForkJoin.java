package sk.itlearning.java3.java3a.h.threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class T6_ForkJoin {

	// Java 7 Fork and Join framework implements effective use of parallel cores -
	// distributes work to multiple cores and then joins them to return the result
	// set.

	// The core classes supporting the Fork-Join mechanism are ForkJoinPool and
	// ForkJoinTask.

	// The ForkJoinPool is basically a specialized implementation of ExecutorService
	// implementing a work-stealing algorithm.

	// Basically the Fork-Join breaks the task at hand into mini-tasks until the
	// mini-task is simple enough that it can be solved without further breakups.

	// It’s like a divide-and-conquer algorithm. One important concept to note in
	// this framework is that ideally no worker thread is idle.

	// They implement a work-stealing algorithm in that idle workers “steal” the
	// work from those workers who are busy.

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		pool.invoke(new MyTask1());
		pool.invoke(new MyTask2());
	}
	
	public static class MyTask1 extends RecursiveAction {
		private static final long serialVersionUID = 1L;

		@Override
		protected void compute() {
			System.out.println("done 1");
		}
	}

	public static class MyTask2 extends RecursiveTask<String> {
		private static final long serialVersionUID = 1L;

		@Override
		protected String compute() {
			String result = "done 2";
			System.out.println(result);
			return result;
		}
	}
	
}
