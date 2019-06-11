package threadPatterns.workerThread;

//模擬 Client 置入請求
public class Client implements Runnable {
	private RequestQueue queue;
	private int requestCount;

	Client(RequestQueue queue) {
		this.queue = queue;
	}

	//每0-3秒新增一個 request裝入queue
	public void run() {
		while (true) {
			Request request = new Request() {
				public void execute(String name) {
					System.out.println(name + "執行客戶請求" + requestCount + "...");
					try {
						Thread.sleep((int) (Math.random() * 3000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			queue.put(request);
			requestCount++;
			try {
				Thread.sleep((int) (Math.random() * 3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
