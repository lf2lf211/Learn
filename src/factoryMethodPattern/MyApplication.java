package factoryMethodPattern;

public class MyApplication extends Application{
    int select ;
    public MyApplication(){
    }
    public Document CreateDocument(int select){
        if (select==1) return new TextDocument();
        if (select==2) return new DocDocument();
        return new TextDocument();
    }
}