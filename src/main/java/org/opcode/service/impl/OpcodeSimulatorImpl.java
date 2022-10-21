package org.opcode.service.impl;

import java.util.List;
import org.opcode.command.Command;
import org.opcode.command.CommandExecutor;
import org.opcode.command.CommandFactory;
import org.opcode.exceptions.InvalidCommandException;
import org.opcode.model.Register;
import org.opcode.model.RegisterState;
import org.opcode.service.OpcodeSimulator;

public class OpcodeSimulatorImpl implements OpcodeSimulator {

  private final RegisterState registerState;
  private final CommandFactory commandFactory;

  public OpcodeSimulatorImpl(final List<Register> registers) {
    this.registerState = new RegisterState(registers);
    this.commandFactory = new CommandFactory(this.registerState);
  }

  @Override
  public RegisterState execute(List<String> instructions) {
    for (String instruction : instructions) {
      Command command = new Command(instruction);
      CommandExecutor commandExecutor = commandFactory.getCommandExecutor(command);
      if (commandExecutor.validate(command)) {
        System.out.println("Validated command: " + command + " Executing now.....");
        commandExecutor.execute(command);
      } else {
        System.out.println("Invalid command provided");
        throw new InvalidCommandException();
      }
    }
    return this.registerState;
  }
}
