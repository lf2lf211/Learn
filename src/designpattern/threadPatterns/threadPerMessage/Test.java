package designpattern.threadPatterns.threadPerMessage;

//https://openhome.cc/Gossip/DesignPattern/ThreadPerMessage.htm

public class Test {
	    public static void main(String[] args) {
//	        Service service = new Service();
//	        for(int i = 0; i < 10; i++) { 
//	            System.out.println("傳送資料");
//	            service.accept(i);
//	            System.out.println("資料送出");
//	        }
	        
	        ServicePerThread servicePT = new ServicePerThread();
	        for(int i = 0; i < 10; i++) { 
	            System.out.println("傳送資料");
	            servicePT.accept(i);
	            System.out.println("資料送出");
	        }
	    }
}
