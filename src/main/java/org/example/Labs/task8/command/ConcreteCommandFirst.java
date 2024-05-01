package org.example.Labs.task8.command;

public class ConcreteCommandFirst implements Command{
    private final Receiver receiver;

    public ConcreteCommandFirst(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.commandFirst();
    }
}
