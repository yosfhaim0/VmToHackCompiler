
@0
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
M=D

(BasicLoop.LOOP_START)

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

@SP
M=M-1
A=M
D=M
@LCL
A=M 
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

@SP
M=M-1
A=M
D=M
@ARG
A=M 
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

@SP
M=M-1
A=M
D=M
@BasicLoop.LOOP_START
D;JNE

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
