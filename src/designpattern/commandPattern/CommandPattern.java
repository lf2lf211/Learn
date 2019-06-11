package designpattern.commandPattern;

//http://c.biancheng.net/view/1380.html
//命令（Command）模式：將一個請求封裝為一個對象，使發出請求的責任和執行請求的責任分割開。

//命令模式的主要優點如下：
//1.降低系統的耦合度。命令模式能將調用操作的對象與實現該操作的對象解耦。
//2.增加或刪除命令非常方便。採用命令模式增加與刪除命令不會影響其他類，它滿足“開閉原則”，對擴展比較靈活。
//3.可以實現宏命令。命令模式可以與組合模式結合，將多個命令裝配成一個組合命令，即宏命令。
//4.方便實現Undo和Redo操作。命令模式可以與備忘錄模式結合，實現命令的撤銷與恢復。

//缺點：可能產生大量具體命令類。因為計對每一個具體操作都需要設計一個具體命令類，這將增加系統的複雜性。


//抽象命令
interface Command
{
    public abstract void  execute ();
}
//具體命令
class ConcreteCommand implements Command 
{
    private  Receiver  receiver ;
    ConcreteCommand ()
    {
        receiver = new  Receiver ();
    }
    public  void  execute ()
    {
        receiver . action ();
    }
}
//接收者(實際執行者)
class Receiver 
{
    public  void  action ()
    {
        System . out . println ( "接收者的action()方法被調用..." );
    }
}
//調用者(請求執行者)
class Invoker 
{
  private  Command  command ;
  public  Invoker ( Command  command )
  {
      this . command = command ;
  }
  public  void  setCommand ( Command  command )
  {
      this . command = command ;
  }
  public  void  call ()
  {
      System . out . println ( "調用者執行命令command..." );
      command . execute ();
  }
}

public  class CommandPattern 
{
	//客戶
    public  static  void  main ( String [] args )
    {
        Command  cmd = new  ConcreteCommand ();
        Invoker  invoker = new  Invoker ( cmd );
        System . out . println ( "客戶訪問調用者的call()方法..." );
        invoker . call ();
    }
}
