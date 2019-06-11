package threadPatterns.producerConsumerPattern;

//http://twmht.github.io/blog/posts/multithread/producer-consumer.html
public class Main {

	// Producer 是 “生產者” 的意思, 是指產生數據的線程. 而 Consumer 是 “消費者” 的意思,
	// 意指使用數據的線程. 生產者必須將數據安全的交給消費者. 雖然聽起來簡單, 但當生產者與消費者在不同的線程上運行時, 兩者處理的速度差將是最大問題. 當消費者要取數據時,
	// 生產者還沒建立數據, 或是生產者產出數據, 但是消費者還沒辦法接受數據等等. Producer-Consumer Pattern 是在生產者與消費者間加入一個 “橋樑參予者”,
	// 這個橋樑用來緩衝兩者間的速度差.

	// 1 Data參予者是由 Producer參予者所建立,並由 Consumer參予者所使用. 在以下範例, Data 參予者是 String 類(蛋糕).

	// 2 Producer參予者會建立 Data參予者,傳遞給 Channel 參予者. 在下面範例中由 MakerThread
	// 擔任Producer參予者的角色.(MakerThread.java)

	// 3 Consumer參予者會利用 Channel參予者獲取 Data 參予者. 在接下來範例由 EaterThread 擔任
	// Consumer參予者角色.(EaterThread.java)

	// 4 Channel參予者會從 Producer參予者接收 Data參予者, 並保管起來, 並回應Consumer 參予者要求, 將Data參予者傳送出去,為了確保Thread
	// Safe Issue, Producer 參予者與 Consumer參予者要對其進行訪問動作進行共享排斥(Table.java)

	// -------------------------------

	// Main 類會建立 Table, MakerThread 與 EaterThread 物件並啟動它們. 代碼如下 :
	public static void main(String[] args) {
		Table table = new Table(3);     // 建立可以放置3個蛋糕的桌子
		new MakerThread("MakerThread-1", table, 31415).start();
		new MakerThread("MakerThread-2", table, 92653).start();
		new MakerThread("MakerThread-3", table, 58979).start();
		new EaterThread("EaterThread-1", table, 32384).start();
		new EaterThread("EaterThread-2", table, 62643).start();
		new EaterThread("EaterThread-3", table, 38327).start();
	}

}
