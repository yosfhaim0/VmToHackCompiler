
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


@4000
D=A
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@3 
M=D

@5000
D=A
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@3 
A=A+1
M=D

// push return-address
@Sys.main.ReturnAddress0
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
@Sys.main
0; JMP
// label return-address
(Sys.main.ReturnAddress0)

@SP
M=M-1
A=M
D=M
@1
A=A+1
A=A+1
A=A+1
A=A+1
A=A+1
M=D

(NestedCall.LOOP)

@NestedCall.LOOP
0;JMP

// label g
(Sys.main)
@5
D=A
@Sys.main_End
D; JEQ
(Sys.main_Loop)
@SP
A=M
M=0
@SP
M=M+1
@Sys.main_Loop
D=D-1;JNE
(Sys.main_End) //


@4001
D=A
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@3 
M=D

@5001
D=A
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@3 
A=A+1
M=D

@200
D=A
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@LCL
A=M 
A=A+1
M=D

@40
D=A
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@LCL
A=M 
A=A+1
A=A+1
M=D

@6
D=A
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@LCL
A=M 
A=A+1
A=A+1
A=A+1
M=D

@123
D=A
@SP
A=M
M=D
@SP
M=M+1

// push return-address
@Sys.add12.ReturnAddress1
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
@1  // = n-5 NUM
D=D-A
@ARG
M=D
// LCL = SP
@SP
D=M
@LCL
M=D
// goto g
@Sys.add12
0; JMP
// label return-address
(Sys.add12.ReturnAddress1)

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

@2
D=A
@LCL
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

@3
D=A
@LCL
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

@4
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
D=M
A=A-1
M=D+M

@SP
M=M-1
A=M
D=M
A=A-1
M=D+M

@SP
M=M-1
A=M
D=M
A=A-1
M=D+M

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
(Sys.add12)
@0
D=A
@Sys.add12_End
D; JEQ
(Sys.add12_Loop)
@SP
A=M
M=0
@SP
M=M+1
@Sys.add12_Loop
D=D-1;JNE
(Sys.add12_End) //


@4002
D=A
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@3 
M=D

@5002
D=A
@SP
A=M
M=D
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@3 
A=A+1
M=D

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

@12
D=A
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
