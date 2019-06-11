package designpattern.simpleFactoryPattern;

public class LoaderFactory {

	  public static Loader getLoader(LoaderType type) {
		  
		    switch(type) { //可再以策略模式(StrategyPattern)優化
		      case XML: {
		        return new XMLLoader();
		      }
		      case JSON: {
		        return new JSONLoader();
		      }
		      default: {
		        return null;
		      }
		    }
		  }
		  
	  public enum LoaderType {
		  XML,CSV,JSON
	  }
}
