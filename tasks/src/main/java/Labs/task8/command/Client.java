package Labs.task8.command;

import java.util.List;

public class Client {
    private final Receiver receiver;
    private final Invoker invoker;
    private final List<Command> commandList;

    public Client(Receiver receiver, Invoker invoker, List<Command> commandList) {
        this.receiver = receiver;
        this.invoker = invoker;
        this.commandList = commandList;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public Invoker getInvoker() {
        return invoker;
    }

    public List<Command> getCommandList() {
        return commandList;
    }

}
