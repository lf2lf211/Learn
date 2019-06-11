package designpattern.threadPatterns.threadPerMessage;

public class Helper {
    void process(int data) {
        System.out.println("開始處理 " + data);
        try {
            Thread.sleep(1000); // 處理過程很費時
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("處理完成");
    }
}
