package org.opcode.command;

import java.util.List;
import org.opcode.model.Register;
import org.opcode.model.RegisterState;

public class AddCommandExecutor extends CommandExecutor {

  public static String commandName = "ADD";

  public AddCommandExecutor(final RegisterState registerState) {
    super(registerState);
  }

  public boolean validate(Command command) {
    final List<String> params = command.getParams();
    return params.size() == 2;
  }

  public void execute(Command command) {
    try {
      final Character registerName = command.getParams().get(0).charAt(0);
      final Integer value = Integer.parseInt(command.getParams().get(1));
      Register register = registerState.getRegister(registerName);
      register.setValue(register.getValue() + value);
    } catch (Exception e) {

    }
  }
}
