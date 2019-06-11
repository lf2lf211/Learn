package chainOfResp.ex1;

import java.util.HashMap;
import java.util.Map;

//定义：为了避免请求的发送者和接收者之间的耦合关系，使多个接受对象都有机会处理请求。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。

//抽象处理者(Handler)角色：定义出一个处理请求的接口。如果需要，接口可以定义 出一个方法以设定和返回对下家的引用。这个角色通常由一个Java抽象类或者Java接口实现。上图中Handler类的聚合关系给出了具体子类对下家的引用，抽象方法handleRequest()规范了子类处理请求的操作。

//具体处理者(ConcreteHandler)角色：具体处理者接到请求后，可以选择将请求处理掉，或者将请求传给下家。由于具体处理者持有对下家的引用，因此，如果需要，具体处理者可以访问下家。


//职责链模式优点：
//职责链模式使得一个对象无须知道是其他哪一个对象处理其请求，对象仅需知道该请求会被处理即可，接收者和发送者都没有对方的明确信息，且链中的对象不需要知道链的结构，由客户端负责链的创建，降低了系统的耦合度。
//请求处理对象仅需维持一个指向其后继者的引用，而不需要维持它对所有的候选处理者的引用，可简化对象的相互连接。
//在给对象分派职责时，职责链可以给我们更多的灵活性，可以通过在运行时对该链进行动态的增加或修改来增加或改变处理一个请求的职责。
//在系统中增加一个新的具体请求处理者时无须修改原有系统的代码，只需要在客户端重新建链即可，从这一点来看是符合“开闭原则”的。
//
//职责链模式缺点：
//因为一个请求没有明确的接收者，所以不能保证它一定会被处理，该请求可能一直到链的末端都得不到处理；一个请求也可能因职责链没有被正确配置而得不到处理。
//对于比较长的职责链，请求的处理可能涉及到多个处理对象，系统性能将受到一定影响，而且在进行代码调试时不太方便。
//如果建链不当，可能会造成循环调用，将导致系统陷入死循环。
public class Client {
	public static void main(String[] args) {
		// T1();// 未添加 专门负责维护职责链類
		T2();
	}

	public static void T1() {
		// 假设初始菜单都是以下这些东西
		HashMap<String, Integer> menu = new HashMap<String, Integer>();
		menu.put("汉堡", 5);
		menu.put("薯条", 5);
		menu.put("可乐", 5);
		menu.put("雪碧", 5);
		// 假设有5个分店
		Subbranch mcSubbranch1 = new McSubbranch(0, 0, new HashMap<String, Integer>(menu));
		Subbranch mcSubbranch2 = new McSubbranch(100, 120, new HashMap<String, Integer>(menu));
		Subbranch mcSubbranch3 = new McSubbranch(-100, -120, new HashMap<String, Integer>(menu));
		Subbranch mcSubbranch4 = new McSubbranch(1000, 20, new HashMap<String, Integer>(menu));
		Subbranch mcSubbranch5 = new McSubbranch(-500, 0, new HashMap<String, Integer>(menu));

		// 以下设置职责链
		mcSubbranch4.setSuccessor(mcSubbranch5);
		mcSubbranch3.setSuccessor(mcSubbranch4);
		mcSubbranch2.setSuccessor(mcSubbranch3);
		mcSubbranch1.setSuccessor(mcSubbranch2);
		// 小左开始订餐，假设小左的坐标是900,20
		HashMap<String, Integer> order = new HashMap<String, Integer>();
		order.put("汉堡", 2);
		order.put("可乐", 1);
		order.put("薯条", 1);

		print(mcSubbranch1);
		System.out.println("------------------------------------------");

		// 小左开始订餐，直接找mcSubbranch1的这一家分店订餐即可
		mcSubbranch1.handleOrder(new Order(900, 20, order));

		System.out.println("------------------------------------------");
		print(mcSubbranch1);

	}

	public static void T2() {

		// 假设初始菜单都是以下这些东西
		Map<String, Integer> menu = new HashMap<String, Integer>();
		menu.put("汉堡", 5);
		menu.put("薯条", 5);
		menu.put("可乐", 5);
		menu.put("雪碧", 5);
		// 假设有5个分店
		Subbranch mcSubbranch1 = new McSubbranch(0, 0, new HashMap<String, Integer>(menu));
		Subbranch mcSubbranch2 = new McSubbranch(100, 120, new HashMap<String, Integer>(menu));
		Subbranch mcSubbranch3 = new McSubbranch(-100, -120, new HashMap<String, Integer>(menu));
		Subbranch mcSubbranch4 = new McSubbranch(1000, 20, new HashMap<String, Integer>(menu));
		Subbranch mcSubbranch5 = new McSubbranch(-500, 0, new HashMap<String, Integer>(menu));

		// 注册5个分店
		OrderManager.getOrderManager().registerSubbranch(mcSubbranch1, mcSubbranch2, mcSubbranch3, mcSubbranch4,
				mcSubbranch5);

		// 小左开始订餐，假设小左的坐标是900,20
		Map<String, Integer> order = new HashMap<String, Integer>();
		order.put("汉堡", 2);
		order.put("可乐", 1);
		order.put("薯条", 1);

		print(mcSubbranch1);
		System.out.println("------------------------------------------");

		// 小左开始订餐，直接找订餐管理部门订餐
		OrderManager.getOrderManager().handleOrder(new Order(900, 20, order));

		System.out.println("------------------------------------------");
		print(mcSubbranch1);
	}

	public static void print(Subbranch subbranch) {
		if (subbranch == null) {
			return;
		}
		do {
			if (subbranch instanceof McSubbranch) {
				System.out.println("[" + subbranch + "]的菜单:" + ((McSubbranch) subbranch).getMenu());
			}
		} while ((subbranch = ((McSubbranch) subbranch).getNextSubbranch()) != null);
	}
}
