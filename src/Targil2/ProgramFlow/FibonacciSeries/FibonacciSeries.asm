
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
@3 
A=A+1
M=D

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
@THAT
A=M 
M=D

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
@THAT
A=M 
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

@SP
M=M-1
A=M
D=M
@ARG
A=M 
M=D

(FibonacciSeries.MAIN_LOOP_START)

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
@FibonacciSeries.COMPUTE_ELEMENT
D;JNE

@FibonacciSeries.END_PROGRAM
0;JMP

(FibonacciSeries.COMPUTE_ELEMENT)

@0
D=A
@THAT
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

@1
D=A
@THAT
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
@THAT
A=M 
A=A+1
A=A+1
M=D

@1
D=A
@3
A=A+D
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
M=D+M

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

@FibonacciSeries.MAIN_LOOP_START
0;JMP

(FibonacciSeries.END_PROGRAM)
