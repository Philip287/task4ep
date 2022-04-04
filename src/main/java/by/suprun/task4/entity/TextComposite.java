package by.suprun.task4.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite extends AbstractTextComponent {
    protected List<AbstractTextComponent> componentList = new ArrayList<>();
    private int size = 0;

    public TextComposite(TextComponentType componentType) {
        super(componentType);
    }

    @Override
    public String operation() {
        String delimiter = componentType.getDelimiter();
        ArrayList<String> stringArrayList = new ArrayList<>();
        for(AbstractTextComponent component : componentList){
            stringArrayList.add(component.operation());
            stringArrayList.add(delimiter);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : stringArrayList){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        size++;
        componentList.add(textComponent);
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        size--;
        componentList.remove(textComponent);
    }

    @Override
    public TextComponentType getComponentType() {
        return super.getComponentType();
    }

    @Override
    public int getSize() {
        return this.size;
    }

    public List<AbstractTextComponent> getComponentList() {
        return componentList;
    }

    public AbstractTextComponent getComponent(int index){
        return componentList.get(index);
    }
}
