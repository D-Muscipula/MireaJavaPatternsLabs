package org.example.Labs.task8.command;

public class ConcreteCommandSecond implements Command{
    private final Receiver receiver;

    public ConcreteCommandSecond(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.commandSecond();
    }
}
