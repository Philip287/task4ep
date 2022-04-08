package by.suprun.task4.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    protected List<TextComponent> componentList;
    private final TextComponentType type;

    public TextComposite(TextComponentType type) {
        this.type = type;
        componentList = new ArrayList<>();
    }

    @Override
    public String toString() {
        String delimiter = type.getDelimiter();
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent component : componentList) {
            stringBuilder.append(component.toString());
            stringBuilder.append(delimiter);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean add(TextComponent textComponent) {

        return componentList.add(textComponent);
    }

    @Override
    public boolean remove(TextComponent textComponent) {
        return componentList.remove(textComponent);
    }

    @Override
    public TextComponentType getComponentType(){
        return type;
    }

    public List<TextComponent> getComponentList() {
        return componentList;
    }
}
