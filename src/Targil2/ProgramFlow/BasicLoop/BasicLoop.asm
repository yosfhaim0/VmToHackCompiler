
//C_PUSH
@0
D=A
@SP
A=M
M=D
@SP
M=M+1

//C_POP

@SP
M=M-1
A=M
D=M
@LCL
A=M 
M=D

(BasicLoop.LOOP_START)

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

@SP
M=M-1
A=M
D=M
A=A-1
M=D+M

//C_POP

@SP
M=M-1
A=M
D=M
@LCL
A=M 
M=D

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

//C_POP

@SP
M=M-1
A=M
D=M
@ARG
A=M 
M=D

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

@SP
M=M-1
A=M
D=M
@BasicLoop.LOOP_START
D;JNE

//C_PUSH
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
