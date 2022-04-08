package by.suprun.task4.parser.impl;

import by.suprun.task4.entity.TextComponent;
import by.suprun.task4.entity.TextComponentType;
import by.suprun.task4.entity.TextComposite;
import by.suprun.task4.parser.CompositeParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TextParser implements CompositeParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PARAGRAPH_DELIMITER_REGEX = "\\t";
    private final CompositeParser nextParser = new ParagraphParser();

    @Override
    public TextComponent parse(String data) {
        LOGGER.info("Text parser start work.");
        TextComposite text = new TextComposite(TextComponentType.TEXT);
        List<String> paragraphStrings = List.of(data.split(PARAGRAPH_DELIMITER_REGEX));
        paragraphStrings.forEach(paragraph ->
        {
            if (!paragraph.isEmpty()) {
                text.add(nextParser.parse(paragraph));
            }
        });
        return text;
    }
}
