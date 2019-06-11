package threadPatterns.guardedSuspensionPattern;

import java.util.Random;


//ServerThread 類 : 
//ServerThread 類是用來接受請求的線程, 這個類也擁有 RequestQueue 的物件 (通常與 ClientThread 會是同一個) . ServerThread 會調用 getRequest 方法獲取請求. 

public class ServerThread extends Thread {
	private Random random;
	private RequestQueue requestQueue;

	public ServerThread(RequestQueue requestQueue, String name, long seed) {
		super(name);
		this.requestQueue = requestQueue;
		this.random = new Random(seed);
	}

	public void run() {
		for (int i = 0; i < 10000; i++) {
			Request request = requestQueue.getRequest();
			System.out.println(Thread.currentThread().getName() + " handles  " + request);
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
			}
		}
	}
}