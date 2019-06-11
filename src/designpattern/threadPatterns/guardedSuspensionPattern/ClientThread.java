package designpattern.threadPatterns.guardedSuspensionPattern;

import java.util.Random;


//ClientThread 類 : 
//ClientThread 類是用來模擬送出請求的線程. ClientThread 擁有 RequestQueue 的物件, 會不斷調用 putRequest. 
public class ClientThread extends Thread {
	private Random random;
	private RequestQueue requestQueue;

	public ClientThread(RequestQueue requestQueue, String name, long seed) {
		super(name);
		this.requestQueue = requestQueue;
		this.random = new Random(seed);
	}

	public void run() {
		for (int i = 0; i < 10000; i++) {
			Request request = new Request("No." + i);
			System.out.println(Thread.currentThread().getName() + " requests " + request);
			requestQueue.putRequest(request);
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
			}
		}
	}
}
