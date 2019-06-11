package commandPattern;

//抽象命令(也可用介面)
public abstract class LightCommand {
    
    Light light;

    public LightCommand(Light light){
        this.light = light;
    }

    public abstract void execute();
}
