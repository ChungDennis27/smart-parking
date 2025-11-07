import java.util.ArrayList;
import java.util.List;

public class Driver_Invoker {
    private List<Driver_Command> commandHistory;

    public Driver_Invoker() {
        this.commandHistory = new ArrayList<>();
    }

    public void executeCommand(Driver_Command command) {
        command.execute();
        commandHistory.add(command);
    }

    public List<Driver_Command> getCommandHistory() {
        return commandHistory;
    }
}

