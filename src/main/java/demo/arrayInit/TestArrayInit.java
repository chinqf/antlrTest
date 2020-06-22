package demo.arrayInit;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


public class TestArrayInit {
    public static void main(String[] args) throws Exception {
        // 1. 获取字符输入流 CharStream
        ANTLRInputStream input = new ANTLRInputStream(System.in);

        // 2. 创建词法分析器
        ArrayInitLexer lexer = new ArrayInitLexer(input);

        // 3. 创建词法符号缓冲区，存储由词法分析器生成的词法符号
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // 4. 创建语法分析器
        ArrayInitParser parser = new ArrayInitParser(tokens);

        // 5. 生成语法分析树
        ParseTree tree = parser.init();

        // 6. 打印语法分析树
        System.out.println(tree.toStringTree(parser));
    }
}
