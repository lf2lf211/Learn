package commandPattern;

//實作命令
public class TurnOn extends  LightCommand {
    public TurnOn(Light light) {
        super(light);
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
