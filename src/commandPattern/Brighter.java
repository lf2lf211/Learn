package commandPattern;

//實作命令
public class Brighter extends  LightCommand {
	public Brighter(Light light) {
        super(light);
    }

    @Override
    public void execute() {
        light.brighter();
    }
}
