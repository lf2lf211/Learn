package factoryMethodPattern;

public class DocDocument extends Document{
    public DocDocument(){
        System.out.println("I am class DocDocument");
    }
    public void Open(){
        System.out.println("I open a DocDocument");
    }
    public void Save(){
        System.out.println("I save the DocDocument");
    }
    public void Close(){
        System.out.println("I close the DocDocument");
    }
}
