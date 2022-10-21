package org.opcode.command;

import java.util.HashMap;
import java.util.Map;
import org.opcode.exceptions.InvalidCommandException;
import org.opcode.model.RegisterState;

public class CommandFactory {
  private Map<String, CommandExecutor> commands = new HashMap<>();

  public CommandFactory(final RegisterState registerState) {
  }

  public CommandExecutor getCommandExecutor(final Command command) {
    final CommandExecutor commandExecutor = commands.get(command.getCommandName().toUpperCase());
    if (commandExecutor == null) {
      throw new InvalidCommandException();
    }
    return commandExecutor;
  }
}
