grammar LibExpr;
import CommonLexerRules;
prog: stat+ ;
stat: expr NEWLINE                  # printExpr
    | ID '=' expr NEWLINE           # assign
    | NEWLINE                       # blank
    ;
expr: expr op=('*'|'/') expr           # MulDiv
    | expr op=('+'|'-') expr           # AddSub
    | INT                           # int
    | ID                            # id
    | '(' expr ')'                  # parens
    ;

// 为运算符这样词法符号定义一些名字
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;