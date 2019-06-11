package designpattern.threadPatterns.producerConsumerPattern;

//在Table 類中的 put 和 take 方法中使用了 Guarded Suspension Pattern. 而警戒條件則是 while 條件的邏輯判斷

//Producer-Consumer Pattern 中, 肩負保護安全性的使命是Channel 參與者. Channel 參與者進行線程間的共享互斥, 
//讓Producer 參與者能正確的將Data 參與者送到 Consumer 參與者手上. 範例程式中, Table 類的 put 方法 與 take 方法都使用了 Guarded Suspension Pattern. 
//但 MakerThread 與 EaterThread 類都不想依賴於Table 的詳細實現. 也就是說 MakerThread 不必理會其它線程, 只要調用 put 方法就好; 
//而 EaterThread 也是只要調用 take 方法就好. 使用 synchronized, wiat 與 notifyAll 這些考慮到多線程的操作代碼, 都已經封裝在 Channel 參與者 (Table)裡面.

public class Table {
	private final String[] buffer;
	private int tail;  // 下一個put的地方
	private int head;  // 下一個take的地方
	private int count; // buffer內的蛋糕數

	public Table(int count) {
		this.buffer = new String[count];
		this.head = 0;
		this.tail = 0;
		this.count = 0;
	}

	// 放置蛋糕
	public synchronized void put(String cake) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " puts " + cake);
		while (count >= buffer.length) {
			wait();
		}
		buffer[tail] = cake;
		tail = (tail + 1) % buffer.length;
		count++;
		notifyAll();
	}

	// 取得蛋糕
	public synchronized String take() throws InterruptedException {
		while (count <= 0) {
			wait();
		}
		String cake = buffer[head];
		head = (head + 1) % buffer.length;
		count--;
		notifyAll();
		System.out.println(Thread.currentThread().getName() + " takes " + cake);
		return cake;
	}
}
