package by.suprun.task4.entity;

public enum TextComponentType {
    TEXT("\n"),
    PARAGRAPH("\t\n "),
    SENTENCE(" "),
    LEXEME("\u0020"),
    MATH_EXPRESSION(""),
    WORD("");


    private String delimiter;

    TextComponentType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
