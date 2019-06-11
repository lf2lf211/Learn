package designpattern.threadPatterns.threadPerMessage;

public class ServicePerThread {
	private Helper helper = new Helper();
    void accept(int data) {
    	
    	new Thread(()->helper.process(data)).start();
    	
//        new Thread() {
//        	@Override
//        	public void run() {
//        		helper.process(data);
//        	}
//        }.start();
    }
}
