package by.suprun.task4.entity;

public enum TextComponentType {
    TEXT("\n"),
    PARAGRAPH(" "),
    SENTENCE(" "),
    WORD(""),
    SYMBOL("");

    private String delimiter;

    TextComponentType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
