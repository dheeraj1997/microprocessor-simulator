package org.opcode;

import java.util.ArrayList;
import java.util.List;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;
import org.opcode.service.OpcodeSimulator;
import org.opcode.service.impl.OpcodeSimulatorImpl;

public class MicroProcessorSimulator {
    public static void main(String[] args) {
        List<Register> registers = new ArrayList<>();
        registers.add(new Register('A'));
        registers.add(new Register('B'));
        registers.add(new Register('C'));
        registers.add(new Register('D'));
        OpcodeSimulator opcodeSimulator = new OpcodeSimulatorImpl(registers);

        List<String> instructions = new ArrayList<>();
        instructions.add("ADD A 1");
        instructions.add("ADD B 2");
        instructions.add("ADD C 3");
        instructions.add("ADR A B");
        instructions.add("ADR A C");
        RegisterState registerState = opcodeSimulator.execute(instructions);

        System.out.println("A: " + registerState.getRegister('A').getValue());
        System.out.println("B: " + registerState.getRegister('B').getValue());
        System.out.println("C: " + registerState.getRegister('C').getValue());
        System.out.println("D: " + registerState.getRegister('D').getValue());

    }
}
