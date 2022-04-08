package by.suprun.task4.parser.impl;

import by.suprun.task4.entity.TextComponentType;
import by.suprun.task4.entity.TextComposite;
import by.suprun.task4.parser.CompositeParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements CompositeParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PUNCTUATION_REGEX = "\\p{Punct}";
    private static final String WORD_REGEX = "[\\w&&\\D]+";
    private static final String MATH_EXPRESSION_REGEX = "[\\d+\\-*/()]{3,}";
    private final CompositeParser nextWordParser = new WordParser();
    private final CompositeParser nextSymbolParser = new SymbolParser();
    private final CompositeParser nextMathOperationParser = new MathExpressionParser();

    @Override
    public TextComposite parse(String data) {
        LOGGER.info("LexemeParser start work.");
        TextComposite lexeme = new TextComposite(TextComponentType.LEXEME);
        Pattern matchOperation = Pattern.compile(MATH_EXPRESSION_REGEX);
        Matcher mathMatcher = matchOperation.matcher(data);
        if (mathMatcher.matches()) {
            lexeme.add(nextMathOperationParser.parse(data));
        } else {
            Pattern wordPattern = Pattern.compile(WORD_REGEX);
            Pattern punctuationPattern = Pattern.compile(PUNCTUATION_REGEX);
            Matcher wordMatcher = wordPattern.matcher(data);
            Matcher punctuationMatcher = punctuationPattern.matcher(data);
            int i = 0;
            int j = 0;
            while (wordMatcher.find(i) && punctuationMatcher.find(j)) {
                if (wordMatcher.start() < punctuationMatcher.start()) {
                    lexeme.add(nextWordParser.parse(wordMatcher.group()));
                    i = wordMatcher.end();
                } else {
                    lexeme.add(nextSymbolParser.parse(punctuationMatcher.group()));
                    j = punctuationMatcher.end();
                }
            }
            while (wordMatcher.find(i)) {
                lexeme.add(nextWordParser.parse(wordMatcher.group()));
                i = wordMatcher.end();
            }

            while (punctuationMatcher.find(j)) {
                lexeme.add(nextSymbolParser.parse(punctuationMatcher.group()));
                j = punctuationMatcher.end();
            }

        }

        return lexeme;
    }
}
