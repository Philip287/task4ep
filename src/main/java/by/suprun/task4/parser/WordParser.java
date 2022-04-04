package by.suprun.task4.parser;

import by.suprun.task4.entity.AbstractTextComponent;
import by.suprun.task4.entity.SymbolLeaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser extends AbstractTextParser {
    private static final Logger logger = LogManager.getLogger();

    public WordParser() {
    }

    public WordParser(AbstractTextParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parser(AbstractTextComponent textComponent, String data) {
        logger.info("Word parser start work");
        char[] symbols = data.toCharArray();
        for (char s : symbols) {
            SymbolLeaf symbol = new SymbolLeaf(s);
            textComponent.add(symbol);
        }
    }
}
