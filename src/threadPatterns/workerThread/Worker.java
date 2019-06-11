package threadPatterns.workerThread;

public class Worker implements Runnable {

	private RequestQueue queue;
	private String name;

	Worker(RequestQueue queue, String name) {
		this.queue = queue;
		this.name = name;
	}

	@Override
	public void run() {

		while (true) {
			queue.get().execute(name);
		}

	}

}
