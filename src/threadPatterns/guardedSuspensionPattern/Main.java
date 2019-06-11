package threadPatterns.guardedSuspensionPattern;

//guarded 是 "被保護著" 或 "被防衛著" 的意思. suspension 則是 "暫停" 的意思. 
//當現在不適合馬上執行某個操作時, 就想要要求該線程等待, 這就是 Guarded Suspension Pattern. 
//Guarded Suspension Pattern 會要求線程等候, 以保障實例的正常工作.

//有條件的 synchronized
//Guarded Suspension Pattern 是附加條件的 Single Threaded Execution Pattern。也就是有條件的 synchronized。

//多執行緒板的 if
//一般來說，單一執行緒的程式，防衛條件會使用 if 敘述處理。從這個角度來看，Guarded Suspension Pattern 就像是多執行緒版的 if。

//再利用性
//在程式中，會發現只有 RequestQueue 類別有用到 wait 及 notifyAll。之所以這樣做的原因是因為，使用 RequestQueue 類別的一方，
//並不需要考慮 wait 以及 notifyAll 的問題，只要呼叫 getRequest 方法與 putRequest 方法就行了。

//各式各樣的稱呼
//Guarded Suspension Pattern 共通的特徵有下面三點：
//有迴圈的存在,有條件的測試,因為某種原因在等待
//

//Main 類 : 
//在 Main 類中, 首先會先建立 RequestQueue 的實例, 
//並建立名為 Peter 的 ClientThread 與 名為 Mary 的 ServerThread, 並啟動它們. 
public class Main {
	public static void main(String[] args) {
		RequestQueue requestQueue = new RequestQueue();
		new ClientThread(requestQueue, "Alice", 3141592L).start();
		new ServerThread(requestQueue, "Bobby", 6535897L).start();
	}
}
