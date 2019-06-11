package simpleFactoryPattern;

public class FactoryTest {
	
	public static void main(String[] args) {
		
		//由factory取得物件
		Loader XMLloader = LoaderFactory.getLoader(LoaderFactory.LoaderType.XML);
		XMLloader.load();
		
		Loader JSONloader = LoaderFactory.getLoader(LoaderFactory.LoaderType.JSON);
		JSONloader.load();
		
		Loader xloader = new Loader() {
			@Override
			public void load(){
				System.out.println("Load from x");
			}
		};
		xloader.load();
		
		Loader xxloader = ()->{System.out.println("Load from xx");};
		xxloader.load();
		
		Loader xxxloader = System.out::println;
		xxxloader.load();
	}
}
//Reference: https://matthung0807.blogspot.com/2018/04/java-simple-factory-pattern.html