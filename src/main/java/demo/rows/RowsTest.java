package demo.rows;

import demo.arrayInit.ArrayInitLexer;
import demo.arrayInit.ArrayInitParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class RowsTest {
    public static void main(String[] args) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        RowsLexer lexer = new RowsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        int col = Integer.valueOf(args[0]);
        RowsParser parser = new RowsParser(tokens, col); // 传递序列号作为参数
        parser.setBuildParseTree(false);   // 不需要浪费时间建立语法分析树
        parser.file(); // 开始语法分析
    }
}
