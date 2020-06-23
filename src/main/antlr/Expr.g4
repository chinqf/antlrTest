grammar Expr;
// 起始规则，语法分析的七点
prog: stat+ ;
stat: expr NEWLINE
    | ID '=' expr NEWLINE   // 使用 | 来分隔同一个语言规则的若干备选分支
    | NEWLINE
    ;
expr: expr ('*'|'/') expr   // 使用圆括号把一些符号组合成子规则
    | expr ('+'|'-') expr
    | INT
    | ID
    | '(' expr ')'
    ;
ID : [a-zA-Z]+ ;
INT: [0-9] + ;
NEWLINE: '\r'?'\n' ;
WS : [ \t]+ -> skip;