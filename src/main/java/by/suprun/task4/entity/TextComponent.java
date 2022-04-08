package by.suprun.task4.entity;

import java.util.List;

public interface TextComponent {

    boolean  add(TextComponent textComponent);

    boolean  remove(TextComponent textComponent);

    public TextComponentType getComponentType();

    String toString();

    List<TextComponent> getComponentList();
}
