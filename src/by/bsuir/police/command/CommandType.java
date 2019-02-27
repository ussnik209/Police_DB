package by.bsuir.police.command;

/**
 * The enum Command type.
 */
public enum CommandType {


    private ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }

    /**
     * Gets command.
     *
     * @return the command
     */
    public ActionCommand getCommand() {
        return command;
    }

}