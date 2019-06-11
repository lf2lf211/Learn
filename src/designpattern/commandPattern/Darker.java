package designpattern.commandPattern;

//實作命令
public class Darker extends  LightCommand {
	public Darker(Light light) {
        super(light);
    }

    @Override
    public void execute() {
        light.darker();
    }
}
