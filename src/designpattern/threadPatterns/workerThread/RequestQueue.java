package designpattern.threadPatterns.workerThread;

import java.util.LinkedList;

public class RequestQueue {
	private LinkedList<Request> requests;

	RequestQueue(int workers) {
		requests = new LinkedList<Request>();
		for (int i = 0; i < workers; i++) {
			(new Thread(new Worker(this, "Worker"+i))).start();
		}
	}

	synchronized Request get() {
		//沒有request時等待
		while (requests.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return requests.removeFirst();
	}

	synchronized void put(Request request) {
		requests.addLast(request);
		//有新的request通知所有worker
		notifyAll();
	}
}
