package demo.calculate;

import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends LibExprBaseVisitor<Integer> {
    // 存放变量名和变量值的对应关系
    Map<String, Integer> memory = new HashMap<String, Integer>();

    // ID '=' expr NEWLINE
    @Override
    public Integer visitAssign(LibExprParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        int value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    // expr NEWLINE
    @Override
    public Integer visitPrintExpr(LibExprParser.PrintExprContext ctx) {
        Integer value = visit(ctx.expr());
        System.out.println(value);
        return 0;   // 返回一个假值
    }

    // INT
    @Override
    public Integer visitInt(LibExprParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    // ID
    @Override
    public Integer visitId(LibExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        return memory.containsKey(id) ? memory.get(id) : 0;
    }

    // expr ('*'|'/') expr
    @Override
    public Integer visitMulDiv(LibExprParser.MulDivContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        return ctx.op.getType() == LibExprParser.MUL ? left*right : left/right;
    }

    // expr op=('+'|'-') expr
    @Override
    public Integer visitAddSub(LibExprParser.AddSubContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        return ctx.op.getType() == LibExprParser.ADD ? left + right : left - right;
    }

    // '(' expr ')'
    @Override
    public Integer visitParens(LibExprParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

}
