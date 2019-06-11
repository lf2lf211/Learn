package threadPatterns.guardedSuspensionPattern;

import java.util.LinkedList;

// RequestQueue 類 : 
//RequestQueue 類是用來依次存放請求的類. 這個類擁有 getRequest 與 putRequest 兩個方法 : 

//getRequest 方法 
//這個方法會從RequestQueue 裡存放的請求中, 將最早傳入的請求做為返回值 (類似Queue或是FIFO). 如果沒有任何一個請求, 就等待其它線程 putRequest.

//putRequest 方法 
//使用 putRequest 方法可以增加一個請求, 當線程想要在 RequestQueue 放入一個 Request 實例, 就會調用這個方法.


//這裡要注意的地方有 : 
// getRequest, putRequest 都是 synchronized 方法;
// getRequest 有 while 語句來判斷防衛條件使否滿足;
// 在 while 塊中 會使用 wait 來暫停線程.
// 在 while 語句後, 才會調用目的操作;
// 在putRequest 裡, 要調用notifyAll 或 notify.

public class RequestQueue {
	private final LinkedList queue = new LinkedList();

	public synchronized Request getRequest() {
		while (queue.size() <= 0) {
			try {
				// 當條件不滿足的時候，進入wait set
				wait();
				// 當被喚醒的時候，只有拿到鎖定的server thread才能執行下一個敘述
			} catch (InterruptedException e) {
			}
		}
		return (Request) queue.removeFirst();
	}

	public synchronized void putRequest(Request request) {
		queue.addLast(request);
		// 當條件滿足的時候，喚醒所有的server thread
		notifyAll();
	}
}
