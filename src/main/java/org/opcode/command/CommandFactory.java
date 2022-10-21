package org.opcode.command;

import java.util.HashMap;
import java.util.Map;
import org.opcode.exceptions.InvalidCommandException;
import org.opcode.model.RegisterState;

public class CommandFactory {
  private Map<String, CommandExecutor> commands = new HashMap<>();

  public CommandFactory(final RegisterState registerState) {
    commands.put(AddCommandExecutor.commandName, new AddCommandExecutor(registerState));
    commands.put(AdrCommandExecutor.commandName, new AdrCommandExecutor(registerState));
    commands.put(DcrCommandExecutor.commandName, new DcrCommandExecutor(registerState));
    commands.put(InrCommandExecutor.commandName, new InrCommandExecutor(registerState));
  }

  public CommandExecutor getCommandExecutor(final Command command) {
    final CommandExecutor commandExecutor = commands.get(command.getCommandName().toUpperCase());
    if (commandExecutor == null) {
      throw new InvalidCommandException();
    }
    return commandExecutor;
  }
}
