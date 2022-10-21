package org.opcode.command;

import java.util.List;
import org.opcode.model.Register;
import org.opcode.model.RegisterState;

public class AdrCommandExecutor extends CommandExecutor {

  public static String commandName = "ADR";

  public AdrCommandExecutor(final RegisterState registerState) {
    super(registerState);
  }

  public boolean validate(Command command) {
    final List<String> params = command.getParams();
    return params.size() == 2;
  }

  public void execute(Command command) {
    try {
      final Character register1Name = command.getParams().get(0).charAt(0);
      final Character register2Name = command.getParams().get(1).charAt(0);
      Register register1 = registerState.getRegister(register1Name);
      Register register2 = registerState.getRegister(register2Name);
      register1.setValue(register1.getValue() + register2.getValue());
    } catch (Exception e) {

    }
  }
}
