package org.opcode.command;

import java.util.HashMap;
import java.util.Map;
import org.opcode.exceptions.InvalidCommandException;
import org.opcode.model.RegisterState;

public class CommandFactory {
  private Map<String, CommandExecutor> commands = new HashMap<>();

  public CommandFactory(final RegisterState registerState) {
    commands.put(SetCommandExecutor.commandName, new SetCommandExecutor(registerState));
    commands.put(AddCommandExecutor.commandName, new AddCommandExecutor(registerState));
    commands.put(AdrCommandExecutor.commandName, new AdrCommandExecutor(registerState));
    commands.put(DcrCommandExecutor.commandName, new DcrCommandExecutor(registerState));
    commands.put(InrCommandExecutor.commandName, new InrCommandExecutor(registerState));
    commands.put(MovCommandExecutor.commandName, new MovCommandExecutor(registerState));
    commands.put(RstCommandExecutor.commandName, new RstCommandExecutor(registerState));
  }

  public CommandExecutor getCommandExecutor(final Command command) {
    final CommandExecutor commandExecutor = commands.get(command.getCommandName().toUpperCase());
    if (commandExecutor == null) {
      throw new InvalidCommandException();
    }
    return commandExecutor;
  }
}
