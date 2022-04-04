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
(Class1.set)
@0
D=A
@Class1.set_End
D;JEQ
(Class1.set_Loop)
@SP
A=M
M=0
@SP
M=M+1
@Class1.set_Loop
D=D-1;JNE
(Class1.set_End)


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

//C_POP
@SP
A=M-1
D=M
@Class1.0
M=D
@SP
M=M-1

//C_PUSH
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

//C_POP
@SP
A=M-1
D=M
@Class1.1
M=D
@SP
M=M-1

//C_PUSH
@0
D=A
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

// label g
(Class1.get)
@0
D=A
@Class1.get_End
D;JEQ
(Class1.get_Loop)
@SP
A=M
M=0
@SP
M=M+1
@Class1.get_Loop
D=D-1;JNE
(Class1.get_End)


//C_PUSH
@Class1.0
D=M
@SP
A=M
M=D
@SP
M=M+1

//C_PUSH
@Class1.1
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
(Class2.set)
@0
D=A
@Class2.set_End
D;JEQ
(Class2.set_Loop)
@SP
A=M
M=0
@SP
M=M+1
@Class2.set_Loop
D=D-1;JNE
(Class2.set_End)


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

//C_POP
@SP
A=M-1
D=M
@Class2.0
M=D
@SP
M=M-1

//C_PUSH
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

//C_POP
@SP
A=M-1
D=M
@Class2.1
M=D
@SP
M=M-1

//C_PUSH
@0
D=A
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

// label g
(Class2.get)
@0
D=A
@Class2.get_End
D;JEQ
(Class2.get_Loop)
@SP
A=M
M=0
@SP
M=M+1
@Class2.get_Loop
D=D-1;JNE
(Class2.get_End)


//C_PUSH
@Class2.0
D=M
@SP
A=M
M=D
@SP
M=M+1

//C_PUSH
@Class2.1
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
@6
D=A
@SP
A=M
M=D
@SP
M=M+1

//C_PUSH
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
@SP
D=M
@2
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
@Class1.set
0;JMP
// label return-address
(Class1.set.ReturnAddress0)

//C_POP
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

//C_PUSH
@23
D=A
@SP
A=M
M=D
@SP
M=M+1

//C_PUSH
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
@SP
D=M
@2
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
@Class2.set
0;JMP
// label return-address
(Class2.set.ReturnAddress1)

//C_POP
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
@SP
D=M
@0
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
@Class1.get
0;JMP
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
@SP
D=M
@0
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
@Class2.get
0;JMP
// label return-address
(Class2.get.ReturnAddress3)

(Sys.WHILE)

@Sys.WHILE
0;JMP
