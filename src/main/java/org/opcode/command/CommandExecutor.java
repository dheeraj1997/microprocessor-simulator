package org.opcode.command;

import org.opcode.model.RegisterState;

public abstract class CommandExecutor {
  protected RegisterState registerState;

  public CommandExecutor(final RegisterState registerState) {
    this.registerState = registerState;
  }

  public abstract boolean validate(Command command);

  public abstract void execute(Command command);
}
