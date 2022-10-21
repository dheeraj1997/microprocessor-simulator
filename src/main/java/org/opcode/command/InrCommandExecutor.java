package org.opcode.command;

import java.util.List;
import org.opcode.model.Register;
import org.opcode.model.RegisterState;

public class InrCommandExecutor extends CommandExecutor {

  public static String commandName = "INR";

  public InrCommandExecutor(final RegisterState registerState) {
    super(registerState);
  }

  public boolean validate(Command command) {
    final List<String> params = command.getParams();
    return params.size() == 1;
  }

  public void execute(Command command) {
    try {
      final Character registerName = command.getParams().get(0).charAt(0);
      Register register = registerState.getRegister(registerName);
      register.setValue(register.getValue() + 1);
    } catch (Exception e) {

    }
  }
}
