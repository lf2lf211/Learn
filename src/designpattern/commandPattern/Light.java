package designpattern.commandPattern;

//Receiver接收者
public class Light {
	
    public void turnOn(){
        System.out.println("打開燈");
    }

    public void turnOff(){
        System.out.println("關燈");
    }

    public void brighter(){
        System.out.println("亮度提高");
    }

    public void darker(){
        System.out.println("亮度降低");
    }

}
