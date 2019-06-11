package designpattern.proxyPattern;
// http://c.biancheng.net/view/1359.html
//代理（Proxy）模式：為某對象提供一種代理以控制對該對象的訪問。即客戶端通過代理間接地訪問該對象，從而限制、增強或修改該對象的一些特性

/*	優點：
	1.代理模式在客戶端與目標對象之間起到一個中介作用和保護目標對象的作用；
	2.代理對象可以擴展目標對象的功能；
	3.代理模式能將客戶端與目標對象分離，在一定程度上降低了系統的耦合度；

	缺點：
	1.在客戶端和目標對象之間增加一個代理對象，會造成請求處理速度變慢；
	2.增加了系統的複雜度；*/

/*	主要角色：
	抽象主題（Subject）類：通過接口或抽像類聲明真實主題和代理對象實現的業務方法。
	真實主題（Real Subject）類：實現了抽象主題中的具體業務，是代理對象所代表的真實對象，是最終要引用的對象。
	代理（Proxy）類：提供了與真實主題相同的接口，其內部含有對真實主題的引用，它可以訪問、控製或擴展真實主題的功能。*/


public class ProxyTest {
	public static void main(String[] args) {
		Proxy proxy = new Proxy();
		proxy.Request();
	}
}

//抽象主題
interface Subject {
	void Request();
}

//真實主題
class RealSubject implements Subject {
	public void Request() {
		System.out.println("訪問真實主題方法...");
	}
}

//代理
class Proxy implements Subject {
	//內部宣告代理的類
	private RealSubject realSubject;

	@Override
	public void Request() {
		
		if (realSubject == null) {
			realSubject = new RealSubject();
		}
		preRequest();
		realSubject.Request();
		postRequest();
	}

	public void preRequest() {
		System.out.println("訪問真實主題之前的預處理。");
	}

	public void postRequest() {
		System.out.println("訪問真實主題之後的後續處理。");
	}
}
