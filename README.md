# microprocessor-simulator
An opcode simulator for microprocessor operations.

This repository simulates microprocessor operations like 8085. It supports for opcode simulation like-
1. ADD
2. ADR
3. MOV
4. RST
5. SET
6. INR
7. DCR

It also offers support for maintaining the registers and their states. We can easily add a new `register` just by creating a new register with a character for it and adding to the list of registers  and it will support all the pre-implemented commands out of the box.
We can also add a new command just by adding a new file for it which implements the required interface of a `Command` and adding this new command in the `CommandFactory`
### Pre-requisites
1. Maven version 3.8.6
2. Java verion 11

### How to setup this repo?
Clone this repo to your local.
Run mvn clean install
In a terminal run - java -jar target/opcode-simulator-1.0.0-SNAPSHOT.jar

#### Supported commands
`ADD A 1`  add 1 to value of register A  
`ADR A B`   add value of B to value to A  
`MOV A B`  move value of B to A  
`RST A`   reset the value of A to 0  
`SET A 5`  set value of A to 5  
`INR A`  increase value of A by 1  
`DCR A`  decrease value of A by 1  