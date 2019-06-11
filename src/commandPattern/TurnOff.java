package commandPattern;

//實作命令
public class TurnOff extends  LightCommand {
	public TurnOff(Light light) {
        super(light);
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
