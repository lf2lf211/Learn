package designpattern.threadPatterns.workerThread;

//https://openhome.cc/Gossip/DesignPattern/WorkerThread.htm
public class Test {
	public static void main(String[] args) {
        RequestQueue queue = new RequestQueue(5);
        for(int i = 0; i < 5; i++) {
            (new Thread(new Client(queue))).start();
        }    
    }
}
