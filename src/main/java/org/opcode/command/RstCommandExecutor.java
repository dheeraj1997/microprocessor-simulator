package org.opcode.command;

import java.util.List;
import org.opcode.model.RegisterState;

public class RstCommandExecutor extends CommandExecutor {

  public static String commandName = "RST";

  public RstCommandExecutor(final RegisterState registerState) {
    super(registerState);
  }

  public boolean validate(Command command) {
    final List<String> params = command.getParams();
    return params.size() == 0;
  }

  public void execute(Command command) {
    try {
      registerState.reset();
    } catch (Exception e) {

    }
  }
}
