package commandPattern;

import java.util.ArrayList;
import java.util.List;

//Invoker調用者
public class LightInvoker {
	//用List裝入命令
	private List<LightCommand> commandList = new ArrayList<>();

    public void addCommand(LightCommand command) {
        commandList.add(command);
    }

    //執行List中所有命令
    public void execute(){
        for (LightCommand command :
                commandList) {
            command.execute();
        }
    }
}
