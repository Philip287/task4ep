package by.suprun.task4.parser;

import by.suprun.task4.entity.AbstractTextComponent;

public abstract class AbstractTextParser {
    protected AbstractTextParser nextParser;

    public AbstractTextParser() {

    }

    public AbstractTextParser(AbstractTextParser nextParser) {
        this.nextParser = nextParser;
    }

    public abstract void parser(AbstractTextComponent textComponent, String data);

    protected void setNextParser(AbstractTextParser nextParser) {
        this.nextParser = nextParser;
    }
}
