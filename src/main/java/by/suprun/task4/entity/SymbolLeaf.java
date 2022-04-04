package by.suprun.task4.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolLeaf extends AbstractTextComponent {
    private static final Logger logger = LogManager.getLogger();
    private char value;

    public SymbolLeaf(char value) {
        super(TextComponentType.SYMBOL);
        this.value = value;
    }

    public SymbolLeaf(TextComponentType componentType) {
        super(componentType);
    }

    @Override
    public String operation() {
        return String.valueOf(value);
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        logger.warn("Skipped attempt to add component to leaf element");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        logger.warn("Skipped attempt to remove component from leaf element");
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSize() {
        return 1;
    }
}
