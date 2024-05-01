package Labs.task8.command;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        Receiver receiver = new Receiver();
        Invoker invoker = new Invoker();
        Command command1 = new ConcreteCommandFirst(receiver);
        Command command2 = new ConcreteCommandSecond(receiver);
        List<Command> commands = List.of(command1, command2);
        Client client = new Client(receiver, invoker, commands);

        invoker = client.getInvoker();

        invoker.registerCommand("Первая команда", command1);
        invoker.registerCommand("Вторая команда", command2);

        invoker.executeCommand("Первая команда");
        invoker.executeCommand("Вторая команда");

    }
}
