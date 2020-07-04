grammar Rows;
// 自定义构造器以便能传入希望提取的列号(从1开始计数)
@parser::members {   // 在生成的RowsParser中添加一些成员
    int col;
    public RowsParser(TokenStream input, int col) {
        this(input);
        this.col = col;
    }
}

// 匹配输入文件的语法
file : (row NL)+ ;
row
locals [int i=0]
    : (  STUFF
         {
         $i++;
         if ( $i == col ) System.out.println($STUFF.text);
         }
    )+
  ;

TAB   : '\t' -> skip ;  // 匹配但是不将其传递给语法分析器
NL    : '\r'?'\n' ;     // 匹配并将其传递给语法分析器
STUFF : ~[\t\r\n]+ ;    // 匹配除tab符合换行符之外的任何字符
