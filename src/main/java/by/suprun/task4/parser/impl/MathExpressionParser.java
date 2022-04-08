package by.suprun.task4.parser.impl;

import by.suprun.task4.entity.TextComponent;
import by.suprun.task4.entity.TextComponentType;
import by.suprun.task4.entity.TextComposite;
import by.suprun.task4.parser.CompositeParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.Context;
import java.util.List;

public class MathExpressionParser implements CompositeParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private final CompositeParser nextParser = new SymbolParser();


    @Override
    public TextComponent parse(String data) {
        LOGGER.info("Math expression parser start work.");
        TextComposite mathExpression = new TextComposite(TextComponentType.MATH_EXPRESSION);
    //    List<String> polishFormTokens = FromInfixToPostfixConverter.convert(data);
    //    List<MathematicalExpression> expressions = PolishNotationOperator.defineSequence(polishFormTokens);
     //   Context context = new Context();
     //   expressions.forEach(expression -> expression.interpret(context));
    //    data = context.pop().toString();
        data.chars().forEach(symbol -> mathExpression.add(nextParser.parse(Character.toString(symbol))));
        return mathExpression;
    }
}
