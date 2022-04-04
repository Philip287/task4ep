package by.suprun.task4.parser;

import by.suprun.task4.entity.AbstractTextComponent;
import by.suprun.task4.entity.SymbolLeaf;
import by.suprun.task4.entity.TextComponentType;
import by.suprun.task4.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractTextParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "[А-Яа-я\\w]{2,}";

    public LexemeParser() {

    }

    public LexemeParser(AbstractTextParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parser(AbstractTextComponent textComponent, String data) {
        logger.info("LexemeParser start work.");
        String[] lexemes = data.split(LEXEME_REGEX);
        Pattern wordPattern = Pattern.compile(WORD_REGEX);
        for (String lexeme : lexemes) {
            AbstractTextComponent lexemeComponent;
            Matcher matcher = wordPattern.matcher(lexeme);
            if (nextParser != null && matcher.find()) {
                lexemeComponent = new TextComposite(TextComponentType.WORD);
                nextParser.parser(lexemeComponent, lexeme);
            } else {
                char symbol = lexeme.charAt(0);
                lexemeComponent = new SymbolLeaf(symbol);
            }
            textComponent.add(lexemeComponent);
        }
    }
}
