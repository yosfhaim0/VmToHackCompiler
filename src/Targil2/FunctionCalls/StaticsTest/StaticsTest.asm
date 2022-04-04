@256
D=A
@SP
M=D
@Sys.init.returnAdd
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Sys.init.returnAdd
0;JMP
(Sys.init.returnAdd)

// label g
(Class1.set)
@0
D=A
@Class1.set_End
D; JEQ
(Class1.set_Loop)
@SP
A=M
M=0
@SP
M=M+1
@Class1.set_Loop
D=D-1;JNE
(Class1.set_End) //


@0
D=A
@ARG
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@0
M=D

@1
D=A
@ARG
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@1
M=D

@0
D=A
@SP
A=M
M=D
@SP
M=M+1

// FRAME = LCL
@LCL
D=M
// RET = * (FRAME-5)
// RAM[13] = (LOCAL - 5)
@5
A=D-A
D=M
@13
M=D
// * ARG = pop()
@SP
M=M-1
A=M
D=M
@ARG
A=M
M=D
		// SP = ARG+1
@ARG
D=M
@SP
M=D+1

// THAT = *(FRAM-1)
@LCL
M=M-1
A=M
D=M
@THAT
M=D

// THIS = *(FRAM-2)
@LCL
M=M-1
A=M
D=M
@THIS
M=D
// ARG = *(FRAM-3)
@LCL
M=M-1
A=M
D=M
@ARG
M=D
// LCL = *(FRAM-4)
@LCL
M=M-1
A=M
D=M
@LCL
M=D

// goto RET
@13
A=M
0;JMP

// label g
(Class1.get)
@0
D=A
@Class1.get_End
D; JEQ
(Class1.get_Loop)
@SP
A=M
M=0
@SP
M=M+1
@Class1.get_Loop
D=D-1;JNE
(Class1.get_End) //


@0
D=M
@SP
M=M+1
A=M-1
M=D

@1
D=M
@SP
M=M+1
A=M-1
M=D

@SP
M=M-1
A=M
D=M
A=A-1
M=M-D

// FRAME = LCL
@LCL
D=M
// RET = * (FRAME-5)
// RAM[13] = (LOCAL - 5)
@5
A=D-A
D=M
@13
M=D
// * ARG = pop()
@SP
M=M-1
A=M
D=M
@ARG
A=M
M=D
		// SP = ARG+1
@ARG
D=M
@SP
M=D+1

// THAT = *(FRAM-1)
@LCL
M=M-1
A=M
D=M
@THAT
M=D

// THIS = *(FRAM-2)
@LCL
M=M-1
A=M
D=M
@THIS
M=D
// ARG = *(FRAM-3)
@LCL
M=M-1
A=M
D=M
@ARG
M=D
// LCL = *(FRAM-4)
@LCL
M=M-1
A=M
D=M
@LCL
M=D

// goto RET
@13
A=M
0;JMP

// label g
(Class2.set)
@0
D=A
@Class2.set_End
D; JEQ
(Class2.set_Loop)
@SP
A=M
M=0
@SP
M=M+1
@Class2.set_Loop
D=D-1;JNE
(Class2.set_End) //


@0
D=A
@ARG
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@0
M=D

@1
D=A
@ARG
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@1
M=D

@0
D=A
@SP
A=M
M=D
@SP
M=M+1

// FRAME = LCL
@LCL
D=M
// RET = * (FRAME-5)
// RAM[13] = (LOCAL - 5)
@5
A=D-A
D=M
@13
M=D
// * ARG = pop()
@SP
M=M-1
A=M
D=M
@ARG
A=M
M=D
		// SP = ARG+1
@ARG
D=M
@SP
M=D+1

// THAT = *(FRAM-1)
@LCL
M=M-1
A=M
D=M
@THAT
M=D

// THIS = *(FRAM-2)
@LCL
M=M-1
A=M
D=M
@THIS
M=D
// ARG = *(FRAM-3)
@LCL
M=M-1
A=M
D=M
@ARG
M=D
// LCL = *(FRAM-4)
@LCL
M=M-1
A=M
D=M
@LCL
M=D

// goto RET
@13
A=M
0;JMP

// label g
(Class2.get)
@0
D=A
@Class2.get_End
D; JEQ
(Class2.get_Loop)
@SP
A=M
M=0
@SP
M=M+1
@Class2.get_Loop
D=D-1;JNE
(Class2.get_End) //


@0
D=M
@SP
M=M+1
A=M-1
M=D

@1
D=M
@SP
M=M+1
A=M-1
M=D

@SP
M=M-1
A=M
D=M
A=A-1
M=M-D

// FRAME = LCL
@LCL
D=M
// RET = * (FRAME-5)
// RAM[13] = (LOCAL - 5)
@5
A=D-A
D=M
@13
M=D
// * ARG = pop()
@SP
M=M-1
A=M
D=M
@ARG
A=M
M=D
		// SP = ARG+1
@ARG
D=M
@SP
M=D+1

// THAT = *(FRAM-1)
@LCL
M=M-1
A=M
D=M
@THAT
M=D

// THIS = *(FRAM-2)
@LCL
M=M-1
A=M
D=M
@THIS
M=D
// ARG = *(FRAM-3)
@LCL
M=M-1
A=M
D=M
@ARG
M=D
// LCL = *(FRAM-4)
@LCL
M=M-1
A=M
D=M
@LCL
M=D

// goto RET
@13
A=M
0;JMP

// label g
(Sys.init)
@0
D=A
@Sys.init_End
D; JEQ
(Sys.init_Loop)
@SP
A=M
M=0
@SP
M=M+1
@Sys.init_Loop
D=D-1;JNE
(Sys.init_End) //


@6
D=A
@SP
A=M
M=D
@SP
M=M+1

@8
D=A
@SP
A=M
M=D
@SP
M=M+1

// push return-address
@Class1.set.ReturnAddress0
D=A
@SP
A=M
M=D
@SP
M=M+1
// push LCL
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
// push ARG
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
// push THIS
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
// push THAT
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
// ARG = SP-n-5
@SP
D=M
@2  // = n-5 NUM
D=D-A
@ARG
M=D
// LCL = SP
@SP
D=M
@LCL
M=D
// goto g
@Class1.set
0; JMP
// label return-address
(Class1.set.ReturnAddress0)

@SP
M=M-1
A=M
D=M
@0
A=A+1
A=A+1
A=A+1
A=A+1
A=A+1
M=D

@23
D=A
@SP
A=M
M=D
@SP
M=M+1

@15
D=A
@SP
A=M
M=D
@SP
M=M+1

// push return-address
@Class2.set.ReturnAddress1
D=A
@SP
A=M
M=D
@SP
M=M+1
// push LCL
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
// push ARG
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
// push THIS
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
// push THAT
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
// ARG = SP-n-5
@SP
D=M
@2  // = n-5 NUM
D=D-A
@ARG
M=D
// LCL = SP
@SP
D=M
@LCL
M=D
// goto g
@Class2.set
0; JMP
// label return-address
(Class2.set.ReturnAddress1)

@SP
M=M-1
A=M
D=M
@0
A=A+1
A=A+1
A=A+1
A=A+1
A=A+1
M=D

// push return-address
@Class1.get.ReturnAddress2
D=A
@SP
A=M
M=D
@SP
M=M+1
// push LCL
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
// push ARG
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
// push THIS
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
// push THAT
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
// ARG = SP-n-5
@SP
D=M
@0  // = n-5 NUM
D=D-A
@ARG
M=D
// LCL = SP
@SP
D=M
@LCL
M=D
// goto g
@Class1.get
0; JMP
// label return-address
(Class1.get.ReturnAddress2)

// push return-address
@Class2.get.ReturnAddress3
D=A
@SP
A=M
M=D
@SP
M=M+1
// push LCL
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
// push ARG
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
// push THIS
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
// push THAT
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
// ARG = SP-n-5
@SP
D=M
@0  // = n-5 NUM
D=D-A
@ARG
M=D
// LCL = SP
@SP
D=M
@LCL
M=D
// goto g
@Class2.get
0; JMP
// label return-address
(Class2.get.ReturnAddress3)

(Sys.WHILE)

@Sys.WHILE
0;JMP
