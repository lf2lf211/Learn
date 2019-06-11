package designpattern.threadPatterns.threadPerMessage;

public class Service {
    private Helper helper = new Helper();
    void accept(int data) {
        helper.process(data);
    }
}
