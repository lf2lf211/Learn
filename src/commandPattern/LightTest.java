package commandPattern;

//https://ithelp.ithome.com.tw/articles/10204425
public class LightTest {

	public static void main(String[] args) {
		
		Light light = new Light();

        LightCommand turnOn = new TurnOn(light);
        LightCommand brighter = new Brighter(light);
        LightCommand darker = new Darker(light);

        LightInvoker invoker = new LightInvoker();

        invoker.addCommand(turnOn);
        invoker.addCommand(brighter);
        invoker.addCommand(brighter);
        invoker.addCommand(brighter);
        invoker.addCommand(darker);

        invoker.execute();

	}

}
