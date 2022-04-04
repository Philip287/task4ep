package by.suprun.task4.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private static final Logger logger = LogManager.getLogger();
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder(){

    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser){
        parsers.add(abstractTextParser);
        return this;
    }

    public AbstractTextParser built(){
        logger.info("Building parser dependency");
        for (int i = 0; i < parsers.size(); i++) {
            AbstractTextParser parser = parsers.get(i-1);
            parser.setNextParser(parsers.get(i));
        }
        return parsers.get(0);
    }
}
