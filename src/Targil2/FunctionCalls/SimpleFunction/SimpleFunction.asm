
// label g
(SimpleFunction.test)
@2
D=A
@SimpleFunction.test_End
D; JEQ
(SimpleFunction.test_Loop)
@SP
A=M
M=0
@SP
M=M+1
@SimpleFunction.test_Loop
D=D-1;JNE
(SimpleFunction.test_End) //


@0
D=A
@LCL
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

@1
D=A
@LCL
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
A=A-1
M=D+M

@SP
M=M-1
A=M
D=!M
M=D
@SP
M=M+1

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
A=A-1
M=D+M

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
