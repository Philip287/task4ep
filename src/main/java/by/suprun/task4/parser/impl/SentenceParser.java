package by.suprun.task4.parser.impl;

import by.suprun.task4.entity.TextComponent;
import by.suprun.task4.entity.TextComponentType;
import by.suprun.task4.entity.TextComposite;
import by.suprun.task4.parser.CompositeParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SentenceParser implements CompositeParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SENTENCE_REGEX = "\\s+";
    private final CompositeParser nextParser = new LexemeParser();

    @Override
    public TextComponent parse(String data) {
        LOGGER.info("Sentence parser start work!");
        TextComposite sentence = new TextComposite(TextComponentType.SENTENCE);
        List<String> lexemeStrings = List.of(data.split(SENTENCE_REGEX));
        lexemeStrings.forEach(lexeme -> sentence.add(nextParser.parse(lexeme)));
        return sentence;
    }
}

