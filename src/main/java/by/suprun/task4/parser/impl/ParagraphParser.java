package by.suprun.task4.parser.impl;

import by.suprun.task4.entity.TextComponent;
import by.suprun.task4.entity.TextComponentType;
import by.suprun.task4.entity.TextComposite;
import by.suprun.task4.parser.CompositeParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements CompositeParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PARAGRAPH_REGEX = ".+?[!?.…]$";
    private final CompositeParser nextParser = new SentenceParser();

    @Override
    public TextComponent parse(String data) {
        LOGGER.info("Paragraph parser start work!");
        TextComposite paragraph = new TextComposite(TextComponentType.PARAGRAPH);
        Pattern pattern = Pattern.compile(PARAGRAPH_REGEX);
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            paragraph.add(nextParser.parse(matcher.group()));
        }
        return paragraph;
    }
}
