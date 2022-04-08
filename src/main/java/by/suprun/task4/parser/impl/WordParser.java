package by.suprun.task4.parser.impl;

import by.suprun.task4.entity.TextComponent;
import by.suprun.task4.entity.TextComponentType;
import by.suprun.task4.entity.TextComposite;
import by.suprun.task4.parser.CompositeParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser implements CompositeParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private final CompositeParser netParser = new SymbolParser();

    @Override
    public TextComponent parse(String data) {
        LOGGER.info("Word parser start work");
        TextComposite word = new TextComposite(TextComponentType.WORD);
        data.chars().forEach(symbol -> word.add(netParser.parse(Character.toString(symbol))));
        return word;
    }
}
