package designpattern.simpleFactoryPattern;

public class NoFactoryTest {

	public static void main(String[] args) {
		
		// 直接用new建立物件
		Loader XMLloader = new XMLLoader(); 
		XMLloader.load();
	    
		Loader JSONloader = new JSONLoader();
		JSONloader.load();
		
	}

}
