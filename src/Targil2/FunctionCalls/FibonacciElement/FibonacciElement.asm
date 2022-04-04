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
@0
D=D-A
@5
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Sys.init
0;JMP
(Sys.init.returnAdd)

// label g
(Main.fibonacci)
@0
D=A
@Main.fibonacci_End
D;JEQ
(Main.fibonacci_Loop)
@SP
A=M
M=0
@SP
M=M+1
@Main.fibonacci_Loop
D=D-1;JNE
(Main.fibonacci_End)


//C_PUSH
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

//C_PUSH
@2
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
@SP
M=M-1
A=M
D=M-D
@IF_TRUE1
D;JLT
@SP
A=M
M=0
@IF_FALSE1
0;JMP
(IF_TRUE1)
@SP
A=M
M=-1
(IF_FALSE1)
@SP
M=M+1

@SP
M=M-1
A=M
D=M
@Main.IF_TRUE
D;JNE

@Main.IF_FALSE
0;JMP

(Main.IF_TRUE)

//C_PUSH
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

@LCL
D=M
@5
A=D-A
D=M
@13
M=D
@SP
M=M-1
A=M
D=M
@ARG
A=M
M=D
@ARG
D=M
@SP
M=D+1
@LCL
M=M-1
A=M
D=M
@THAT
M=D
@LCL
M=M-1
A=M
D=M
@THIS
M=D
@LCL
M=M-1
A=M
D=M
@ARG
M=D
@LCL
M=M-1
A=M
D=M
@LCL
M=D
@13
A=M
0;JMP

(Main.IF_FALSE)

//C_PUSH
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

//C_PUSH
@2
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
M=M-D

// push return-address
@Main.fibonacci.ReturnAddress0
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
@SP
D=M
@1
D=D-A
@5
D=D-A
@ARG
M=D
// LCL = SP
@SP
D=M
@LCL
M=D
// goto g
@Main.fibonacci
0;JMP
// label return-address
(Main.fibonacci.ReturnAddress0)

//C_PUSH
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

//C_PUSH
@1
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
M=M-D

// push return-address
@Main.fibonacci.ReturnAddress1
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
@SP
D=M
@1
D=D-A
@5
D=D-A
@ARG
M=D
// LCL = SP
@SP
D=M
@LCL
M=D
// goto g
@Main.fibonacci
0;JMP
// label return-address
(Main.fibonacci.ReturnAddress1)

@SP
M=M-1
A=M
D=M
A=A-1
M=D+M

@LCL
D=M
@5
A=D-A
D=M
@13
M=D
@SP
M=M-1
A=M
D=M
@ARG
A=M
M=D
@ARG
D=M
@SP
M=D+1
@LCL
M=M-1
A=M
D=M
@THAT
M=D
@LCL
M=M-1
A=M
D=M
@THIS
M=D
@LCL
M=M-1
A=M
D=M
@ARG
M=D
@LCL
M=M-1
A=M
D=M
@LCL
M=D
@13
A=M
0;JMP

// label g
(Sys.init)
@0
D=A
@Sys.init_End
D;JEQ
(Sys.init_Loop)
@SP
A=M
M=0
@SP
M=M+1
@Sys.init_Loop
D=D-1;JNE
(Sys.init_End)


//C_PUSH
@4
D=A
@SP
A=M
M=D
@SP
M=M+1

// push return-address
@Main.fibonacci.ReturnAddress2
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
@SP
D=M
@1
D=D-A
@5
D=D-A
@ARG
M=D
// LCL = SP
@SP
D=M
@LCL
M=D
// goto g
@Main.fibonacci
0;JMP
// label return-address
(Main.fibonacci.ReturnAddress2)

(Sys.WHILE)

@Sys.WHILE
0;JMP
