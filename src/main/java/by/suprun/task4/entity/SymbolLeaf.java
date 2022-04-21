package by.suprun.task4.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SymbolLeaf implements TextComponent {
    private static final Logger logger = LogManager.getLogger();
    private char value;
    private SymbolCompositeType type;

    public SymbolLeaf(char value, SymbolCompositeType type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean add(TextComponent textComponent) {
        logger.warn("Skipped attempt to add component to leaf element");
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(TextComponent textComponent) {
        logger.warn("Skipped attempt to remove component from leaf element");
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComponent> getComponentList() {
        logger.warn("Skipped attempt to get componentList from leaf element");
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public TextComponentType getComponentType() {
        logger.warn("Skipped attempt to get component type from leaf element");
        throw new UnsupportedOperationException();
    }
}
