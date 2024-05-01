package org.example.Labs.task8.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Invoker {
    Map<String, Command> commandMap = new HashMap<>();
    public void registerCommand(String name, Command command) {
        commandMap.put(name, command);
    }

    public void executeCommand(String name) {
        Command command = commandMap.get(name);
        if (command != null) {
            command.execute();
        }
    }
}
