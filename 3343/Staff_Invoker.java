import java.util.ArrayList;
import java.util.List;

public class Staff_Invoker {
    private List<Staff_Command> commandHistory;

    public Staff_Invoker() {
        this.commandHistory = new ArrayList<>();
    }

    public void executeCommand(Staff_Command command) {
        command.execute();
        commandHistory.add(command);
    }

    public List<Staff_Command> getCommandHistory() {
        return commandHistory;
    }
}

