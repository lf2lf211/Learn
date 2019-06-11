package designpattern.simpleFactoryPattern;

public class JSONLoader implements Loader{

	  @Override
	  public void load() {
	    System.out.println("Load from JSON");
	  }

	}
