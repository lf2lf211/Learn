package factoryMethodPattern;

public class ExampleFactory {
    public static void main(String[] args){
        MyApplication App = new MyApplication();
        App.select = 1 ; // 使用 TextDocument
        // App.select = 2 ; // 使用 DocDocument
        App.NewDocument();
    }
}
