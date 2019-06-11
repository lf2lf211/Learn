package factoryMethodPattern;

public abstract  class Application {

    int select ;
    public abstract Document CreateDocument(int select) ;
    public void NewDocument(){
        Document doc = CreateDocument(select);
        doc.Open() ;
        doc.Save() ;
        doc.Close() ;
    }
}
