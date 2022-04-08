package by.suprun.task4.parser.impl;

import by.suprun.task4.entity.SymbolCompositeType;
import by.suprun.task4.entity.SymbolLeaf;
import by.suprun.task4.entity.TextComponent;
import by.suprun.task4.parser.CompositeParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolParser implements CompositeParser {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public TextComponent parse(String data) {
        LOGGER.info("Symbol parser start work.");
        char symbol = data.charAt(0);
        SymbolCompositeType symbolType;
        if (Character.isDigit(symbol)) {
            symbolType = SymbolCompositeType.DIGIT;
        } else if (Character.isLetter(symbol)) {
            symbolType = SymbolCompositeType.LETTER;
        } else {
            symbolType = SymbolCompositeType.PUNCTUATION;
        }

        return new SymbolLeaf(symbol, symbolType);
    }
}
