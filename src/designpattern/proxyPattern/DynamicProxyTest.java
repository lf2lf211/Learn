package designpattern.proxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// https://juejin.im/post/5a99048a6fb9a028d5668e62
// https://segmentfault.com/a/1190000011291179
// http://wiki.jikexueyuan.com/project/ssh-noob-learning/dynamic-proxy.html

public class DynamicProxyTest {
	public static void main(String[] args) {
		//目标对象
		Subject2 target = new RealSubject2();
        System.out.println(target.getClass());
        //代理对象
        Subject2 proxy = (Subject2) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        //执行代理对象方法
		proxy.Request();
	}
}

//抽象主題
interface Subject2 {
	void Request();
}

//真實主題
class RealSubject2 implements Subject2 {
	public void Request() {
		System.out.println("訪問真實主題方法...");
	}
}

//代理工廠
class ProxyFactory {

    private Object target;// 维护一个目标对象

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 为目标对象生成代理对象 (用反射動態組裝一個新的代理類)
    public Object getProxyInstance() {
        return java.lang.reflect.Proxy.newProxyInstance(
        		target.getClass().getClassLoader(), //指定当前目标对象使用类加载器
        		target.getClass().getInterfaces(), //目标对象实现的接口的类型
                new InvocationHandler() { //實作事件處理器

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("訪問真實主題之前的預處理。");

                        // 执行目标对象方法
                        Object returnValue = method.invoke(target, args);

                        System.out.println("訪問真實主題之後的後續處理。");
                        return null;
                    }
                });
    }
}
