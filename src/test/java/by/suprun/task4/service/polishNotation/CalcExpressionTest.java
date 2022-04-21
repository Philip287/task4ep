package by.suprun.task4.service.polishNotation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static by.suprun.task4.service.polishNotation.CalcExpression.calc;

public class CalcExpressionTest {
    private static final double EXPECTED = 13;
    private static final String EXPRESSION_TEST = "5*2+((5+4)/3)";
    private static ExpressionParser expressionParser = new ExpressionParser();


    @Test
    public void calcTest() {
        List<String> expression = expressionParser.parse(EXPRESSION_TEST);
        double actual = calc(expression);
        Assert.assertEquals(actual, EXPECTED);
    }
}