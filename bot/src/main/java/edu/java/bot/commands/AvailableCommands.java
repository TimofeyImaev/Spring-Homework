package edu.java.bot.commands;

public enum AvailableCommands {
    HELLO(new Hello()),
    HELP(new Help()),
    START(new Start()),
    LIST(new ListOfLinks()),
    TRACK(new Track()),
    UNTRACK(new Untrack());

    private final Command command;

    AvailableCommands(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
