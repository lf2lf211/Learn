package factoryMethodPattern;

public class TextDocument extends Document{
    public TextDocument(){
        System.out.println("I am class TextDocument");
    }
    public void Open(){
        System.out.println("I open a TextDocument");
    }
    public void Save(){
        System.out.println("I save the TextDocument");
    }
    public void Close(){
        System.out.println("I close the TextDocument");
    }
}


